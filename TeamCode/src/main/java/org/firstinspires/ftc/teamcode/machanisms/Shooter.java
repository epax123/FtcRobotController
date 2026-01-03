package org.firstinspires.ftc.teamcode.machanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private DcMotor shooter1, shooter2;

    public void init(HardwareMap hwMap){
        shooter1 = hwMap.get(DcMotor.class, "shooter1");
        shooter2 = hwMap.get(DcMotor.class, "shooter2");

        shooter1.setDirection(DcMotorSimple.Direction.REVERSE);

        shooter1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooter2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        shooter1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
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
}
