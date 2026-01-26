package org.firstinspires.ftc.teamcode.TeamCode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotor Intake;

    public void init(HardwareMap hwMap){
        Intake = hwMap.get(DcMotor.class, "intake");
        Intake.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void intake(boolean L1, boolean L2){
        if (L1){
            Intake.setPower(.6);
        } else if (L2) {
            Intake.setPower(-.8);
        }else{
            Intake.setPower(0);
        }
    }
}
