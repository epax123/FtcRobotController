package org.firstinspires.ftc.teamcode.samples.ExampleMechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TestBenchColor {
    NormalizedColorSensor colorSensor;

    public enum DetectedColor {
        RED,
        GREEN,
        BLUE,
        UNKNOWN
    }


    public void init(HardwareMap hwMap){
    colorSensor = hwMap.get(NormalizedColorSensor.class, "left_color_sensor");
    colorSensor.setGain(10);
    }

    public DetectedColor getDetectedColor(Telemetry telemetry){
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normGreen = colors.green / colors.alpha;
        normBlue = colors.blue / colors.alpha;

        telemetry.addData("Red",normRed);
        telemetry.addData("Green",normGreen);
        telemetry.addData("Blue",normBlue);

        /*
        Red, Green, Blue
        Red =
        Green =
        Blue =
         */

        return DetectedColor.UNKNOWN;
    }

}
