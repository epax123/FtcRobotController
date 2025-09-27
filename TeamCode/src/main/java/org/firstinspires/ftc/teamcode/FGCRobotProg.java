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
        double DTL = -Y + X;
        double DTR = -Y - X;
        boolean DPad1Up = gamepad1.dpad_up;
        boolean Dpad1Down = gamepad1.dpad_down;
        boolean Dpad2Up = gamepad2.dpad_up;
        boolean Dpad2Down = gamepad2.dpad_down;
        boolean LBump2 = gamepad2.left_bumper;
        boolean RBump2 = gamepad2.right_bumper;
        boolean Tri2 = gamepad2.triangle;
        boolean Cross2 = gamepad2.cross;

        Motors.setDTleftSpeed(DTL);
        Motors.setDTrightspeed(DTR);

        telemetry.addData("triangle",Tri2);
        telemetry.addData("Cross",Cross2);

        if (DPad1Up){
            Motors.setAscensionSpeed(1);
        } else if (Dpad1Down) {
            Motors.setAscensionSpeed(-1);
        }else {
            Motors.setAscensionSpeed(0);
        }

        if (Dpad2Up){
            Motors.setBack_doorSpeed(1);
        } else if (Dpad2Down) {
            Motors.setBack_doorSpeed(-1);
        }else {
            Motors.setBack_doorSpeed(0);
        }

        if (LBump2){
            Motors.setIntake_wheelsSpeed(1);
        }else if (RBump2) {
            Motors.setIntake_wheelsSpeed(-1);
        }else{
            Motors.setIntake_wheelsSpeed(0);
        }

        if (Tri2){
            Motors.setIntake_doorSpeed(1);
        }else if (Cross2){
            Motors.setIntake_doorSpeed(-1);
        }else {
            Motors.setIntake_doorSpeed(0);
        }
    }
}
