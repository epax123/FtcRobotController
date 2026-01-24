package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class FlyWheelTuner extends OpMode {

    public DcMotorEx FlyWheel;

    public double highVelocity =1500, lowVelocity =900;
    public double curTargetVelocity = highVelocity;
    double F = 0;
    double P = 0;

    double[] stepSizes = {10.0, 1.0, 0.1, 0.01, 0.001};

    int stepIndex = 1;

    @Override
    public void init() {
        FlyWheel = hardwareMap.get(DcMotorEx.class, "fly_wheel");
        FlyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        FlyWheel.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        telemetry.addLine("initComplete");
    }

    @Override
    public void loop() {
    if(gamepad1.triangleWasPressed()){
        if (curTargetVelocity == highVelocity){
            curTargetVelocity = lowVelocity;
        }else{
            curTargetVelocity = highVelocity;
        }
    }
    if (gamepad1.bWasPressed()){
        stepIndex = (stepIndex + 1) % stepSizes.length;
    }
    if (gamepad1.dpadLeftWasPressed()){
        F -=stepSizes[stepIndex];
    }
    if (gamepad1.dpadRightWasPressed()){
        F += stepSizes[stepIndex];
    }
    if (gamepad1 .dpadUpWasPressed()){
        P += stepSizes[stepIndex];
    }
    if (gamepad1.dpadDownWasPressed()){
        P -= stepSizes[stepIndex];
    }
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        FlyWheel.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        FlyWheel.setVelocity(curTargetVelocity);

        double curVelocity = FlyWheel.getVelocity();
        double error = curTargetVelocity - curVelocity;

        telemetry.addData("Target Velocity", curTargetVelocity);
        telemetry.addData("Current Velocity", curVelocity);
        telemetry.addData("Error", error);
        telemetry.addLine("---------------------------------");
        telemetry.addData("Tuning P", P);
        telemetry.addData("Tuning F", F);
        telemetry.addData("Step sizes", stepSizes);
    }
}
