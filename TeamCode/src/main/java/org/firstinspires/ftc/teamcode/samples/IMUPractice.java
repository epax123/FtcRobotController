package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.samples.ExampleMechanisms.IMUTest;

@TeleOp
public class IMUPractice extends OpMode {
    IMUTest bench = new IMUTest();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Heading", bench.getHeading(AngleUnit.RADIANS));
    }
}
