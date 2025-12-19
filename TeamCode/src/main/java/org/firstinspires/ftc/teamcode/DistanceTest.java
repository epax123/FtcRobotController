package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.machanisms.SensorDistanceTest;
@Disabled
@TeleOp
public class DistanceTest extends OpMode {
    SensorDistanceTest distanceSensor = new SensorDistanceTest();
    double distance;

    @Override
    public void init(){
        distanceSensor.init(hardwareMap);
    }

    @Override
    public void loop(){
        distance = distanceSensor.getDistance();
        if (distance<10){
            telemetry.addData("Too","Close!");
        }
        telemetry.addData("Distance", distanceSensor.getDistance());
        telemetry.update();
    }

}
