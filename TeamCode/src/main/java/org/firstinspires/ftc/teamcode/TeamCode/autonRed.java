package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.TeamCode.mechanisms.Shooter;

@Autonomous
public class autonRed extends LinearOpMode {
    public DcMotor frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;

    Shooter shoot = new Shooter();
    Intake intake = new Intake();

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeftMotor = hardwareMap.get(DcMotor.class, "front_left_drive");
        backLeftMotor = hardwareMap.get(DcMotor.class, "back_left_drive");
        frontRightMotor = hardwareMap.get(DcMotor.class, "front_right_drive");
        backRightMotor = hardwareMap.get(DcMotor.class, "back_right_drive");

        shoot.init(hardwareMap, telemetry);
        intake.init(hardwareMap);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
            BackWardsFor(750);
            shoot.shooter(true, false);
            sleep(150);
            intake.intake(true,false);//shoot first set
            sleep(300);
            intake.intake(false, true);
            sleep(1500);
            shoot.shooter(true,false);
            intake.intake(false,false);

            TurnRightFor(233.5);//prep to intake 2nd set
            BackWardsFor(300);
            StrafeRightFor(600);

            intake.intake(false,true);//shoot 2nd set
            ForwardFor(850);
            intake.intake(false,false);
            shoot.Hood(true);
            shoot.shooter(false,true);
            BackWardsFor(850);
            TurnLeftFor(233);
            intake.intake(true,false);
            sleep(100);
            intake.intake(false,true);
            sleep(2000);
            shoot.shooter(false,true);
            intake.intake(false,false);

            TurnRightFor(250);
            ForwardFor(950);



    }

    public  void ForwardFor(double mm){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double wheelDia = 128; //CM
        double wheelCircumference = wheelDia * Math.PI;
        double rot = mm/wheelCircumference;
        double ticksPerRevo = 28 * 15; //ticks on HD hex encoders multiplied by gearbox
        int ticks = (int) (rot * ticksPerRevo);

        frontLeftMotor.setPower(.3);
        backLeftMotor.setPower(.3);
        frontRightMotor.setPower(.3);
        backRightMotor.setPower(.3);

        frontLeftMotor.setTargetPosition(ticks);
        backLeftMotor.setTargetPosition(ticks);
        frontRightMotor.setTargetPosition(ticks);
        backRightMotor.setTargetPosition(ticks);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeftMotor.isBusy() || frontRightMotor.isBusy() ||
                backLeftMotor.isBusy() || backRightMotor.isBusy()){

        }

        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

    }

    public  void BackWardsFor(double mm){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double wheelDia = 128; //CM
        double wheelCircumference = wheelDia * Math.PI;
        double rot = mm/wheelCircumference;
        double ticksPerRevo = 28 * 15; //ticks on HD hex encoders multiplied by gearbox
        int ticks = (int) (rot * ticksPerRevo);

        frontLeftMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        frontRightMotor.setPower(.5);
        backRightMotor.setPower(.5);

        frontLeftMotor.setTargetPosition(-1*ticks);
        backLeftMotor.setTargetPosition(-1*ticks);
        frontRightMotor.setTargetPosition(-1*ticks);
        backRightMotor.setTargetPosition(-1*ticks);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeftMotor.isBusy() || frontRightMotor.isBusy() ||
                backLeftMotor.isBusy() || backRightMotor.isBusy()){

        }

        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

    }
    public  void TurnLeftFor(double mm){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double wheelDia = 128; //CM
        double wheelCircumference = wheelDia * Math.PI;
        double rot = mm/wheelCircumference;
        double ticksPerRevo = 28 * 15; //ticks on HD hex encoders multiplied by gearbox
        int ticks = (int) (rot * ticksPerRevo);

        frontLeftMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        frontRightMotor.setPower(.5);
        backRightMotor.setPower(.5);

        frontLeftMotor.setTargetPosition(1*ticks);
        backLeftMotor.setTargetPosition(1*ticks);
        frontRightMotor.setTargetPosition(-1*ticks);
        backRightMotor.setTargetPosition(-1*ticks);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeftMotor.isBusy() || frontRightMotor.isBusy() ||
                backLeftMotor.isBusy() || backRightMotor.isBusy()){

        }

        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

    }
    public  void TurnRightFor(double mm){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double wheelDia = 128; //CM
        double wheelCircumference = wheelDia * Math.PI;
        double rot = mm/wheelCircumference;
        double ticksPerRevo = 28 * 15; //ticks on HD hex encoders multiplied by gearbox
        int ticks = (int) (rot * ticksPerRevo);

        frontLeftMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        frontRightMotor.setPower(.5);
        backRightMotor.setPower(.5);

        frontLeftMotor.setTargetPosition(-1*ticks);
        backLeftMotor.setTargetPosition(-1*ticks);
        frontRightMotor.setTargetPosition(1*ticks);
        backRightMotor.setTargetPosition(1*ticks);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeftMotor.isBusy() || frontRightMotor.isBusy() ||
                backLeftMotor.isBusy() || backRightMotor.isBusy()){

        }

        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

    }

    public  void StrafeLeftFor(double mm){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double wheelDia = 128; //CM
        double wheelCircumference = wheelDia * Math.PI;
        double rot = mm/wheelCircumference;
        double ticksPerRevo = 28 * 15; //ticks on HD hex encoders multiplied by gearbox
        int ticks = (int) (rot * ticksPerRevo);

        frontLeftMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        frontRightMotor.setPower(.5);
        backRightMotor.setPower(.5);

        frontLeftMotor.setTargetPosition(1*ticks);
        backLeftMotor.setTargetPosition(-1*ticks);
        frontRightMotor.setTargetPosition(-1*ticks);
        backRightMotor.setTargetPosition(1*ticks);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeftMotor.isBusy() || frontRightMotor.isBusy() ||
                backLeftMotor.isBusy() || backRightMotor.isBusy()){

        }

        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

    }

    public  void StrafeRightFor(double mm){
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double wheelDia = 128; //CM
        double wheelCircumference = wheelDia * Math.PI;
        double rot = mm/wheelCircumference;
        double ticksPerRevo = 28 * 15; //ticks on HD hex encoders multiplied by gearbox
        int ticks = (int) (rot * ticksPerRevo);

        frontLeftMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        frontRightMotor.setPower(.5);
        backRightMotor.setPower(.5);

        frontLeftMotor.setTargetPosition(-1*ticks);
        backLeftMotor.setTargetPosition(1*ticks);
        frontRightMotor.setTargetPosition(1*ticks);
        backRightMotor.setTargetPosition(-1*ticks);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeftMotor.isBusy() || frontRightMotor.isBusy() ||
                backLeftMotor.isBusy() || backRightMotor.isBusy()){

        }

        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

    }
}
