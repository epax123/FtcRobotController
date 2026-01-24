package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class FlyWheelTuner extends OpMode {

    public DcMotorEx FlyWheel1, FlyWheel2;
    public DcMotor Intake;

    public double highVelocity =1500, lowVelocity =900, stepsize;
    public double curTargetVelocity = highVelocity;
    double F = 13.298;
    double P = 200;

    double[] stepSizes = {10.0, 1.0, 0.1, 0.01, 0.001};

    int stepIndex = 1;

    @Override
    public void init() {
        FlyWheel1 = hardwareMap.get(DcMotorEx.class, "shooter1");
        FlyWheel2 = hardwareMap.get(DcMotorEx.class, "shooter2");
        Intake = hardwareMap.get(DcMotor.class,"intake");
        FlyWheel1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FlyWheel2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FlyWheel1.setDirection(DcMotorSimple.Direction.REVERSE);
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        FlyWheel1.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        FlyWheel2.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
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
    if (gamepad1.right_bumper){
        Intake.setPower(1);
    } else if (gamepad1.left_bumper) {
        Intake.setPower(-1);
    }else {
        Intake.setPower(0);
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
        FlyWheel2.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        FlyWheel1.setVelocity(curTargetVelocity);
        FlyWheel2.setVelocity(curTargetVelocity);

        double curVelocity = FlyWheel1.getVelocity();
        double error = curTargetVelocity - curVelocity;
        stepsize = stepSizes[stepIndex];

        telemetry.addData("Target Velocity", curTargetVelocity);
        telemetry.addData("Current Velocity", curVelocity);
        telemetry.addData("Error", error);
        telemetry.addLine("---------------------------------");
        telemetry.addData("Tuning P", P);
        telemetry.addData("Tuning F", F);
        telemetry.addData("Step sizes", stepsize);
    }
}
