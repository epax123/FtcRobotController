package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class IfPractice extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double leftY = gamepad1.left_stick_y;

        telemetry.addData("Left Y Value", leftY);
    }
}
