package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.MecanumDriveFO;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.ServoGate;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Shooter;
@TeleOp
public class FTC25_26_ThroughtPut extends OpMode {
    MecanumDriveFO mecanumDriveFO = new MecanumDriveFO();
    Intake intake  = new Intake();
    Shooter shooter = new Shooter();
    double forwards, strafe, rotate;

    boolean tri, sqr, circle, cross, up, down, left, right, L1, R1, L2, R2;

    @Override
    public void init(){
        mecanumDriveFO.init(hardwareMap);
        intake.init(hardwareMap);
        shooter.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        forwards = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        L2 = gamepad1.left_trigger > .2;
        R2 = gamepad1.right_trigger > .5;

        tri = gamepad1.triangle;
        sqr = gamepad1.squareWasPressed();
        circle = gamepad1.circle;
        cross = gamepad1.crossWasPressed();
        up = gamepad1.dpad_up;
        down = gamepad1.dpad_down;
        left = gamepad1.dpad_left;
        right = gamepad1.dpad_right;
        L1 = gamepad1.left_bumper;
        R1 = gamepad1.right_bumper;

        mecanumDriveFO.driveFieldReltive(forwards, strafe, rotate);
        intake.intake(L1, R1);
        shooter.shooter(sqr,cross);
        shooter.Hood(circle);
        mecanumDriveFO.variableSpeed(tri);
    }
}
