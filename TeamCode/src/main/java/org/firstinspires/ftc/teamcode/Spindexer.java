package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Spindexer {
    private Servo spindexer, kicker;
    double slot, kick;

    public void init(HardwareMap hwMap){
        spindexer = hwMap.get(Servo.class, "indexer");
        kicker = hwMap.get(Servo.class,"kicker");

        kicker.setDirection(Servo.Direction.REVERSE);
        slot = 0;

    }

    public void Spindex(double Slot, double kick, boolean sqr) {
    if (slot <= 1){
        spindexer.setPosition(1);
    } else if (slot <= 2) {
        spindexer.setPosition(0.5);
    } else if (slot > 2) {
        spindexer.setPosition(0);
    }

    if (sqr && slot == 3){
        slot = 0;
    } else if (sqr) {
        slot += 1;
    }

        kicker.setPosition(kick);
    }

    public void Input(Boolean left, Boolean right, Boolean sqr) {
        if (left){
            slot += .05;
        } else if (right) {
            slot -= .05;
        } else if (slot > 3) {
            slot = 3;
        } else if (slot < 0) {
            slot = 0;
        }

        if (sqr){
            kick = 1;
        } else {
            kick = .5;
        }

        this.Spindex(slot, kick, sqr);
    }
}


