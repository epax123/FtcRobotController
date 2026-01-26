package org.firstinspires.ftc.teamcode.TeamCode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    private Telemetry telemetry;
    public DcMotorEx shooter1, shooter2;
    public DcMotor Intake;
    private Servo hood_Servo , ServoGate;
    public double highVelocity =1520, lowVelocity =900, P = 200, F = 13.298;
    double curVelocity;
    public double curTargetVelocity = 0;
    double[] hood = {3, 2, 1};
    int hoodIndx = 1;


    public void init(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        hood_Servo = hwMap.get(Servo.class, "hood_servo");
        shooter1 = hwMap.get(DcMotorEx.class, "shooter1");
        shooter2 = hwMap.get(DcMotorEx.class, "shooter2");
        Intake = hwMap.get(DcMotor.class,"intake");
        ServoGate = hwMap.get(Servo.class,"servo_gate");
        shooter1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooter2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooter1.setDirection(DcMotorSimple.Direction.REVERSE);
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        shooter1.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        shooter2.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);

        ServoGate.setPosition(1);
        hood_Servo.setPosition(0);
    }

    public void shooter(boolean sqr, boolean cross) {
        if (cross && curTargetVelocity == lowVelocity) {
            curTargetVelocity = 0;
            ServoGate.setPosition(1);
        } else if (sqr && curTargetVelocity == highVelocity) {
            curTargetVelocity = 0;
            ServoGate.setPosition(1);
        } else if (sqr) {
            curTargetVelocity = highVelocity;
            ServoGate.setPosition(0.5);
        } else if (cross) {
            curTargetVelocity = lowVelocity;
            ServoGate.setPosition(0.5);
        }

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);

        shooter1.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        shooter2.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidfCoefficients);
            shooter1.setVelocity(curTargetVelocity);
            shooter2.setVelocity(curTargetVelocity);
        curVelocity = shooter1.getVelocity();
        telemetry.addData("Target Speed", curTargetVelocity);
        telemetry.addData("FlyWheel Speed", curVelocity);
    }
    
    public void Hood(boolean cycle) {
    if (cycle){
        hoodIndx = (hoodIndx + 1) % hood.length;
    }
    if (hood[hoodIndx] == 1){
        hood_Servo.setPosition(.56);
    } else if (hood[hoodIndx] == 2) {
        hood_Servo.setPosition(0.8);
    } else if (hood[hoodIndx] == 3) {
        hood_Servo.setPosition(1);
    }
    telemetry.addData("Hood Angle",hood[hoodIndx]);
    }
}