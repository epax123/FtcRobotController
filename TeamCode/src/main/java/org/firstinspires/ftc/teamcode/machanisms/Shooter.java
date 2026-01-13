package org.firstinspires.ftc.teamcode.machanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {
    private DcMotor shooter1, shooter2;
    private Servo hood_Servo;

    public void init(HardwareMap hwMap){
        shooter1 = hwMap.get(DcMotor.class, "shooter1");
        shooter2 = hwMap.get(DcMotor.class, "shooter2");
        hood_Servo = hwMap.get(Servo.class, "hood_servo");

        shooter1.setDirection(DcMotorSimple.Direction.REVERSE);

        shooter1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooter2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        shooter1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        hood_Servo.setPosition(1);
    }

    public void shooter (boolean R1) {
        if (R1){
            shooter1.setPower(1);
            shooter2.setPower(1);
        }else {
            shooter1.setPower(0);
            shooter2.setPower(0);
        }
    }

    public void Hood (double hood) {
        if (hood <= 1){
            hood_Servo.setPosition(1);
        } else if (hood < 2) {
            hood_Servo.setPosition(0.5);
        } else if (hood <= 3) {
            hood_Servo.setPosition(0);
        }
    }
}
