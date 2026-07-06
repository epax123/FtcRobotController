package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.AprilTagLogitech;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.MecanumDriveFO;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Shooter;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@TeleOp
public class AprilTagAutoAlignMecanum extends OpMode {
    private final AprilTagLogitech aprilTagLogitech = new AprilTagLogitech();
    private final MecanumDriveFO mecanumDriveFO = new MecanumDriveFO();
    private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();
    boolean tri, sqr, circle, cross, up, down, left, right, L1, R1, L2, R2;

    //----------------------------PD controller-----------------------------
    double kP = 0.0177;
    double error = 0;
    double lastError = 0;
    double goalX = 0;
    double angleTolerance = 0.2;
    double kD = 0.0003;
    double curTime = 0;
    double lastTime = 0;

    //-----------------------------driving setup-----------------------------
    double forward, strafe, rotate, y;

    //-----------------------controller based PD tuning----------------------
    double [] stepSizes = {1.0, 0.1, 0.01, 0.001, 0.0001};
    int stepIndex = 2;

    @Override
    public void init() {
        aprilTagLogitech.init(hardwareMap, telemetry);
        mecanumDriveFO.init(hardwareMap, telemetry);
        mecanumDriveFO.IMUinit(hardwareMap);
        intake.init(hardwareMap);
        shooter.init(hardwareMap, telemetry);
    }

    public void start(){
        resetRuntime();
        curTime = getRuntime();
    }

    @Override
    public void loop() {
        //-----------------------get mecanum drive inputs---------------------------
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        L2 = gamepad1.left_trigger > .2;
        R2 = gamepad1.right_trigger > .5;
        tri = gamepad1.triangleWasPressed();
        sqr = gamepad1.squareWasReleased();
        circle = gamepad1.circleWasPressed();
        cross = gamepad1.crossWasPressed();
        up = gamepad1.dpad_up;
        down = gamepad1.dpad_down;
        left = gamepad1.dpad_left;
        right = gamepad1.dpad_right;
        L1 = gamepad1.left_bumper;
        R1 = gamepad1.right_bumper;

        //--------------------------get apriltag info-------------------------------
        aprilTagLogitech.update();
        AprilTagDetection id20 = aprilTagLogitech.getTagBySpecificID(20);
        if (id20 != null){
            y = id20.ftcPose.y;
        }else {
            y = 0;
        }

        //-----------------------auto align rotation logic--------------------------

        if (gamepad1.left_trigger > 0.3){
            if(id20 != null) {
                error = goalX - id20.ftcPose.bearing;

                if (Math.abs(error) < angleTolerance){
                    rotate = 0;
                }else {
                    double pTerm = error * kP;

                    curTime = getRuntime();
                    double dT = curTime - lastTime;
                    double dTerm = ((error - lastError) / dT) * kD;

                    rotate = Range.clip(pTerm + dTerm, -.6, .6);

                    lastError = error;
                    lastTime = curTime;
                }
            } else {
                lastError = 0;
                lastTime = getRuntime();
            }
        } else {
            lastError = 0;
            lastTime = getRuntime();
        }
        //------------------------------drive motors--------------------------------
        mecanumDriveFO.drive(forward, strafe, rotate);
        intake.intake(L1, R1);
        shooter.shooter(sqr, cross, y);
        mecanumDriveFO.variableSpeed(circle);
        //----------------------------on the fly tuning-----------------------------
            if (gamepad1.bWasPressed()) {
                stepIndex = (stepIndex + 1) % stepSizes.length;
            }

            if (gamepad1.dpadRightWasPressed()) {
                kP += stepSizes[stepIndex];
            }

            if (gamepad1.dpadLeftWasPressed()) {
                kP -= stepSizes[stepIndex];
            }

            if (gamepad1.dpadUpWasPressed()) {
                kD += stepSizes[stepIndex];
            }

            if (gamepad1.dpadDownWasPressed()) {
                kD -= stepSizes[stepIndex];
            }
        //-------------------telem---------------------
        if (id20 != null) {
            telemetry.addLine("AUTO ALIGN READY");
            aprilTagLogitech.displayDetectionTelemetry(id20);
            telemetry.addData("Angle from tag : ", error);
            telemetry.addData("distance from goal", id20.ftcPose.y);
        }else {
            telemetry.addLine("AUTO ALIGN NOT READY, ROTATE MANUALLY");
        }
        telemetry.addData("P value", "%.4f (D-Pad L/R)", kP);
        telemetry.addData("D Value", "%.4f (D-Pad U/D)", kD);
        telemetry.addData("Step Size", "%.4f (B)", stepSizes[stepIndex]);
    }
}
