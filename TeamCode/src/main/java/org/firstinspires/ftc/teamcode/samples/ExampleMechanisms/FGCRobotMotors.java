package org.firstinspires.ftc.teamcode.samples.ExampleMechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class FGCRobotMotors {
    private DcMotor DTleft;
    private DcMotor DTright;
    private DcMotor ascension;
    private DcMotor intake_wheel;
    private DcMotor Accelerator;
    private Servo servoLPos;
    private Servo servoRPos;


    public void init(HardwareMap hwMap) {
    DTleft = hwMap.get(DcMotor.class, "DTleft");
    DTright = hwMap.get(DcMotor.class, "DTright");
    ascension = hwMap.get(DcMotor.class, "ascension");
    intake_wheel = hwMap.get(DcMotor.class, "intake_wheel");
    Accelerator = hwMap.get(DcMotor.class,"Accelerator");
    servoLPos = hwMap.get(Servo.class,"ServoL");
    servoRPos = hwMap.get(Servo.class,"ServoR");

    DTleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    DTright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    ascension.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    intake_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    Accelerator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    DTleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    DTright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    ascension.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    DTleft.setDirection(DcMotorSimple.Direction.REVERSE);
    servoRPos.setDirection(Servo.Direction.REVERSE);
    }

    public void setAscensionSpeed(double Ascensionspeed){
        ascension.setPower(Ascensionspeed);
    }

    public void setDTleftSpeed(double DTleftspeed) {
        DTleft.setPower(DTleftspeed);
    }

    public void  setDTrightspeed(double DTrightspeed){
        DTright.setPower(DTrightspeed);
    }

    public void setIntake_wheelsSpeed(double Intake_wheelsspeed){
        intake_wheel.setPower(Intake_wheelsspeed);
    }

    public void setAcceleratorSpeed(double AcceleratorSpeed) {
        Accelerator.setPower(AcceleratorSpeed);
    }

    public void setServoLPos(double angle){
        servoLPos.setPosition(angle);
    }

    public void  setServoRPos(double angle){
        servoRPos.setPosition(angle);
    }
}
