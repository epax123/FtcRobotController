package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Spindexer {
    private Servo spindexer, kicker;
    Integer slot, kick;

    public void init(HardwareMap hwMap){
        spindexer = hwMap.get(Servo.class, "indexer");
        kicker = hwMap.get(Servo.class,"kicker");

    }

    public void Spindex(Integer Slot, Integer kick) {
        spindexer.setPosition(Slot);
        kicker.setPosition(kick);
    }

    public void Input(Boolean left, Boolean right, Boolean sqr) {
        if (left){
            slot += 1;
        } else if (right) {
            slot -= 1;
        } else if (slot > 1) {
            slot = 1;
        } else if (slot < -1) {
            slot = -1;
        }

        if (sqr){
            kick = 1;
        } else {
            kick = 0;
        }

        this.Spindex(slot, kick);
    }
}
