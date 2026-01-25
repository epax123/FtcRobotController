package org.firstinspires.ftc.teamcode.TeamCode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoGate {
    private Servo ServoGate;
    int open;

    public void init(HardwareMap hwMap){
        ServoGate = hwMap.get(Servo.class,"servo_gate");
        ServoGate.setPosition(0);
    }

    public void Open(Boolean L2){
        if(L2){
            open += .5;
        } else if(open >= 1){
            open = 0;
        }
        ServoGate.setPosition(open);
    }
}
