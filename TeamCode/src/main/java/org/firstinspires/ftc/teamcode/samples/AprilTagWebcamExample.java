package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.samples.ExampleMechanisms.AprilTagLogitech;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@Autonomous

public class AprilTagWebcamExample extends OpMode {
    AprilTagLogitech aprilTagLogitechTest = new AprilTagLogitech();

    @Override
    public void init() {
    aprilTagLogitechTest.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        // update vision portal
        aprilTagLogitechTest.update();
        AprilTagDetection id20 = aprilTagLogitechTest.getTagBySpecificID(20);
        aprilTagLogitechTest.displayDetectionTelemetry(id20);
    }
}
