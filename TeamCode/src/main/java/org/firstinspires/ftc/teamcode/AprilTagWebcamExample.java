package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.machanisms.AprilTagLogitech;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@Autonomous

public class AprilTagWebcamExample extends OpMode {
    AprilTagLogitech aprilTagLogitech = new AprilTagLogitech();

    @Override
    public void init() {
    aprilTagLogitech.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        // update vision portal
        aprilTagLogitech.update();
        AprilTagDetection id20 = aprilTagLogitech.getTagBySpecificID(20);
        aprilTagLogitech.displayDetectionTelemetry(id20);
    }
}
