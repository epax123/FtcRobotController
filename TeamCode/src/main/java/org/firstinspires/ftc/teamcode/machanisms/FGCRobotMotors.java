package org.firstinspires.ftc.teamcode.machanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FGCRobotMotors {
    private DcMotor DTleft;
    private DcMotor DTright;
    private DcMotor ascension;
    private DcMotor intake_wheel;
    private DcMotor back_door;
    private DcMotor intake_door;

    public void init(HardwareMap hwMap) {
    DTleft = hwMap.get(DcMotor.class, "DTleft");
    DTright = hwMap.get(DcMotor.class, "DTright");
    ascension = hwMap.get(DcMotor.class, "ascension");
    intake_wheel = hwMap.get(DcMotor.class, "intake_wheel");
    back_door = hwMap.get(DcMotor.class, "back_door");
    intake_door = hwMap.get(DcMotor.class,"intake_door");

    DTleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    DTright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    ascension.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    intake_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    back_door.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    intake_door.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    DTleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    DTright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    ascension.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    DTright.setDirection(DcMotorSimple.Direction.REVERSE);
    back_door.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setAscensionSpeed(double ascensionspeed){
        ascension.setPower(ascensionspeed);
    }

    public void setDTleftSpeed(double DTleftspeed) {
        DTleft.setPower(DTleftspeed);
    }
    public void  setDTrightspeed(double DTrightspeed){
        DTright.setPower(DTrightspeed);
    }
    public void setIntake_wheelsSpeed(double Intake_wheelsspeed){
        intake_wheel.setPower(Intake_wheelsspeed);
    }
    public void setBack_doorSpeed(double back_doorspeed){
        back_door.setPower(back_doorspeed);
    }

    public void setIntake_doorSpeed(double intake_doorspeed) {
        intake_door.setPower(intake_doorspeed);
    }
}
