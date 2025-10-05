package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.machanisms.FGCRobotMotors;
@TeleOp
public class FGCRobotProg extends OpMode {
    FGCRobotMotors Motors = new FGCRobotMotors();

    @Override
    public void init() {

        Motors.init(hardwareMap);

    }

    @Override
    public void loop() {

        double X = gamepad1.right_stick_x;
        double Y = gamepad1.left_stick_y;
        double DTL = (Y - X)/2;
        double DTR = (Y + X)/2;
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
        double SpeedDeviders = 1;

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

        if (SpeedDeviders > 2.5){
            SpeedDeviders = 2.5;
        }else if (SpeedDeviders < 1){
            SpeedDeviders = 1;
        }else {

        }

        if (gamepad1.left_bumper){
            SpeedDeviders = SpeedDeviders + .1;
        } else if (gamepad1.right_bumper) {
            SpeedDeviders = SpeedDeviders - .1;
        }else {

        }

        if (Up2){
            Motors.setServoRPos(1);
            Motors.setServoLPos(1);
        } else if (Down2) {
            Motors.setServoRPos(0);
            Motors.setServoLPos(0);
        } else if (Cross2) {
            Motors.setServoRPos(0.4);
            Motors.setServoLPos(0.4);
        }
    }
}
