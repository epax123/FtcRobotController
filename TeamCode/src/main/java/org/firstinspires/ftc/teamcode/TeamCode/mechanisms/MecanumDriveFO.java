package org.firstinspires.ftc.teamcode.TeamCode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDriveFO {

    private DcMotor frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;
    private IMU imu;

    double maxSpeed = .5;

    public void init(HardwareMap hwMap) {
        frontLeftMotor = hwMap.get(DcMotor.class, "front_left_drive");
        backLeftMotor = hwMap.get(DcMotor.class, "back_left_drive");
        frontRightMotor = hwMap.get(DcMotor.class, "front_right_drive");
        backRightMotor = hwMap.get(DcMotor.class, "back_right_drive");

        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        );

        imu.initialize(new IMU.Parameters(RevOrientation));
    }

    public void drive(double forwards, double strafe, double rotate) {
        double frontLeftPower = forwards + strafe + rotate;
        double backLeftPower = forwards - strafe + rotate;
        double frontRightPower = forwards - strafe - rotate;
        double backRightPower = forwards + strafe - rotate;

        double maxPower = 1;

        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));


        frontLeftMotor.setPower(maxSpeed * (frontLeftPower / maxPower));
        backLeftMotor.setPower(maxSpeed * (backLeftPower / maxPower));
        frontRightMotor.setPower(maxSpeed * (frontRightPower / maxPower));
        backRightMotor.setPower(maxSpeed * (backRightPower / maxPower));
    }

    public void driveFieldReltive(double forward, double strafe, double rotate) {
        double theta = Math.atan2(strafe, forward);
        double r = Math.hypot(forward, strafe);

        theta = (AngleUnit.normalizeRadians( theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS)));

        double newForward = r * Math.cos(theta);
        double newStrafe = r * Math.sin(theta);

        this.drive(newForward, newStrafe, rotate);
    }

    public void variableSpeed(double speed){
        if (speed == 1){
            maxSpeed = 0.5;
        } else if (speed <= 2) {
            maxSpeed = 1;
        }
    }
}
