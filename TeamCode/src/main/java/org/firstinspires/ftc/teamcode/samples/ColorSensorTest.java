package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.samples.ExampleMechanisms.TestBenchColor;
@TeleOp

public class ColorSensorTest extends OpMode {
    TestBenchColor bench = new TestBenchColor();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        bench.getDetectedColor(telemetry);
    }
}
