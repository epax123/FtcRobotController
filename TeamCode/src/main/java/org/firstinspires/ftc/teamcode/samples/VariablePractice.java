package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class VariablePractice extends OpMode {

    @Override
    public void init() {
        int teamNumber = 6741;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "mylanLover";
        int motorAngle = 67;

        telemetry.addData("teamNumber", teamNumber);
        telemetry.addData("motorSpeed", motorSpeed);
        telemetry.addData("clawState", clawClosed);
        telemetry.addData("teamName", teamName);
        telemetry.addData("motorAngle", motorAngle);
    }

    @Override
    public void loop() {

    }
}
