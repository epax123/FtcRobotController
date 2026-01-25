package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.samples.ExampleMechanisms.SensorTouchTest;
@Disabled
@TeleOp
public class TouchSensorPractice extends OpMode {
    SensorTouchTest sensor = new SensorTouchTest();

    @Override
    public void init() {
        sensor.init(hardwareMap);
    }

    @Override
    public void loop() {
        String touchSensorState ="NotPressed!";
        if (sensor.isTouchSensorPressed()) {
            touchSensorState = "Pressed!";
        }
        telemetry.addData("TouchSensorState", touchSensorState);
    }
}
