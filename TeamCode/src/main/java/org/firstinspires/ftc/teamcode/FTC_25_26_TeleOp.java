package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.machanisms.Intake;
import org.firstinspires.ftc.teamcode.machanisms.MecanumDriveFO;
import org.firstinspires.ftc.teamcode.machanisms.Shooter;

@TeleOp
public class FTC_25_26_TeleOp extends OpMode {

    MecanumDriveFO driveFO = new MecanumDriveFO();
    Intake intake = new Intake();
    Shooter shooter = new Shooter();

    double forward, strafe, rotate, intakePower;
    boolean dpadUp, dpadDown;
    boolean L1, L2, R1;

    @Override
    public void init() {
        driveFO.init(hardwareMap);
        intake.init(hardwareMap);
        shooter.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y/2;
        strafe = gamepad1.left_stick_x/2;
        rotate = gamepad1.right_stick_x/2;
        L1 = gamepad1.left_bumper;
        L2 = gamepad1.left_trigger > 0.3;
        R1 = gamepad1.right_bumper;

        dpadUp = gamepad1.dpad_up;
        dpadDown = gamepad1.dpad_down;

        if (L1){
            intakePower = 1;
        } else if (L2) {
            intakePower = -1;
        } else {
            intakePower = 0;
        }

        driveFO.driveFieldReltive(forward, strafe, rotate);
        intake.intake(intakePower);
        driveFO.variableSpeed(dpadDown, dpadUp);
        shooter.shooter(R1);
}
}
