package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.MecanumDriveFO;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Spindexer;

@TeleOp
public class FTC_25_26_TeleOp extends OpMode {

    MecanumDriveFO driveFO = new MecanumDriveFO();
    Intake intake = new Intake();
    Shooter shooter = new Shooter();
    Spindexer spindex = new Spindexer();

    double forward, strafe, rotate, intakePower, hood, speed;
    boolean up, down, right, left, tri, sqr;
    boolean r1, r2, l1, l2;
    @Override
    public void init() {
        driveFO.init(hardwareMap);
        intake.init(hardwareMap);
        shooter.init(hardwareMap);
        spindex.init(hardwareMap);
        speed = 1;
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y/2;
        strafe = gamepad1.left_stick_x/2;
        rotate = gamepad1.right_stick_x/2;
        l1 = gamepad1.left_bumper;
        r2 = gamepad1.right_trigger > 0.3;
        r1 = gamepad1.right_bumper;
        l2 = gamepad1.left_trigger > 0.3;
        tri = gamepad1.triangle;
        sqr = gamepad1.square;
        up = gamepad1.dpad_up;
        down = gamepad1.dpad_down;
        right = gamepad1.dpad_right;
        left = gamepad1.dpad_left;

        if (l1){
            intakePower = 1;
        } else if (r1) {
            intakePower = -1;
        } else {
            intakePower = 0;
        }

        if (tri){
            speed += .05;
        } else if (speed > 2) {
            speed = 1;
        }

        driveFO.driveFieldReltive(forward, strafe, rotate);
        intake.intake(l1,r1);
        driveFO.variableSpeed(speed);
        shooter.shooter(l2);
        shooter.Hood(r2);
        spindex.Input(right, left, sqr);

        telemetry.addData("Hood", hood);
        telemetry.addData("Speed", speed);
}
}
