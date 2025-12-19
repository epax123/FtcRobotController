package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.machanisms.MecanumDriveFO;
@TeleOp
public class MecanumFO extends OpMode {

    MecanumDriveFO driveFieldRelative = new MecanumDriveFO();
    double forward, strafe, rotate;

    @Override
    public void init() {
        driveFieldRelative.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y/2;
        strafe = gamepad1.left_stick_x/2;
        rotate = gamepad1.right_stick_x/2;

        telemetry.addData("Forward", driveFieldRelative.getNewForward(forward, strafe));
        telemetry.addData("Strafe", driveFieldRelative.getNewStrafe(forward, strafe));
}
}
