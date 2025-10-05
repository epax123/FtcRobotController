package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.machanisms.FGCRobotMotors;
@TeleOp
public class FGCRobotProg extends OpMode {
    FGCRobotMotors Motors = new FGCRobotMotors();
    double SpeedDeviders;
    double ServoPos;
    Integer Gear = 1;
    Integer Direction = 1;
    @Override
    public void init(){
        Motors.init(hardwareMap);

    }

    @Override
    public void loop() {

        double X = gamepad1.right_stick_x;
        double Y = gamepad1.left_stick_y;
        double DTL = ((Direction*Y) - X)/SpeedDeviders;
        double DTR = ((Direction*Y) + X)/SpeedDeviders ;
        boolean DPad1Up = gamepad1.dpad_up;
        boolean Dpad1Down = gamepad1.dpad_down;
        boolean LBump2 = gamepad2.left_bumper;
        boolean RBump2 = gamepad2.right_bumper;
        boolean Tri1 = gamepad1.triangle;
        boolean Cross2 = gamepad2.cross;
        boolean Cross1 = gamepad1.cross;
        boolean Lbump1 = gamepad1.left_bumper;
        boolean Rbump1 = gamepad1.right_bumper;
        boolean Up2 = gamepad2.dpad_up;
        boolean Down2 = gamepad2.dpad_down;

        Motors.setDTleftSpeed(DTL);
        Motors.setDTrightspeed(DTR);

        if (DPad1Up){
            Motors.setAscensionSpeed(1);
        } else if (Dpad1Down) {
            Motors.setAscensionSpeed(-1);
        }else {
            Motors.setAscensionSpeed(0);
        }

        if (LBump2){
            Motors.setIntake_wheelsSpeed(1);
        }else if (RBump2) {
            Motors.setIntake_wheelsSpeed(-1);
        }else{
            Motors.setIntake_wheelsSpeed(0);
        }

        if (Tri1){
            Motors.setAcceleratorSpeed(.5);
        } else if (Cross1) {
            Motors.setAcceleratorSpeed(-.5);
        }else {
            Motors.setAcceleratorSpeed(0);
        }

        if (gamepad1.right_trigger > .3){
            Direction = 1;
        } else if (gamepad1.left_trigger > .3) {
            Direction = -1;
        }

        if (Gear == 1){
            Gear = 1;
        } else if (Gear > 3) {
            Gear = 3;
        }

        if (gamepad1.rightBumperWasPressed()){
            Gear = Gear + 1;
        } else if (gamepad1.leftBumperWasReleased()) {
            Gear = Gear - 1;
        }
        if (Gear == 1){
            SpeedDeviders = 2.2;
        }else if (Gear == 3){
            SpeedDeviders =1.17;
        } else if (Gear == 2) {
            SpeedDeviders = 1.53;
        }

        if (Up2){
            ServoPos = 0;
        } else if (Down2) {
            ServoPos = 1;
        } else if (Cross2) {
            ServoPos = 0.6;
        }
        Motors.setServoLPos(ServoPos);
        Motors.setServoRPos(ServoPos);
        telemetry.addData("Gear", Gear);
        telemetry.addData("DTR", DTR);
        telemetry.addData("DTL", DTL);
        telemetry.addData("ServoPos",ServoPos);
        telemetry.update();
    }
}
