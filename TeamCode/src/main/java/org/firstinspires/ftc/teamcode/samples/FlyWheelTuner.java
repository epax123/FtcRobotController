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

    public DcMotorEx FlyWheel1, FlyWheel2;

    public double highVelocity =1500, lowVelocity =900;
    public double curTargetVelocity = highVelocity;
    float F;
    float P;

    double[] stepSizes = {10.0, 1.0, 0.1, 0.01, 0.001};

    int stepIndex = 1;

    @Override
    public void init() {
        FlyWheel1 = hardwareMap.get(DcMotorEx.class, "shooter1");
        FlyWheel1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        FlyWheel1.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
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
        FlyWheel1.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        FlyWheel1.setVelocity(curTargetVelocity);

        double curVelocity = FlyWheel1.getVelocity();
        double error = curTargetVelocity - curVelocity;

        telemetry.addData("Target Velocity", curTargetVelocity);
        telemetry.addData("Current Velocity","%.2f",curVelocity);
        telemetry.addData("Error","%.2f", error);
        telemetry.addLine("---------------------------------");
        telemetry.addData("Tuning P", "%.4f (D-Pad U/D)", P);
        telemetry.addData("Tuning F", "%.4f (D-Pad L/R)", F);
        telemetry.addData("Step sizes","%.4f (B)", stepSizes);
    }
}
