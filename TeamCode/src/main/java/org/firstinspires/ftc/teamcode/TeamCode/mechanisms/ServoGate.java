package org.firstinspires.ftc.teamcode.TeamCode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoGate {
    private Servo ServoGate;

    public void init(HardwareMap hwMap){
        ServoGate = hwMap.get(Servo.class,"ServoGate");
        ServoGate.setPosition(0);
    }

    public void Open(Boolean R2){
        if(R2){
            ServoGate.setPosition(1);
        } else{
            ServoGate.setPosition(0);
        }
    }
}
