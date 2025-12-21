package org.firstinspires.ftc.teamcode.machanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotor Intake;

    public void init(HardwareMap hwMap){
        Intake = hwMap.get(DcMotor.class, "intake");
        Intake.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void intake(double intakePower) {
        Intake.setPower(intakePower);
    }
}
