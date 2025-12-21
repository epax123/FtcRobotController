package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.machanisms.Intake;
import org.firstinspires.ftc.teamcode.machanisms.MecanumDriveFO;

@TeleOp
public class MecanumFO extends OpMode {

    MecanumDriveFO driveFO = new MecanumDriveFO();
    Intake intake = new Intake();
    double forward, strafe, rotate, intakePower;
    boolean L1, L2;

    @Override
    public void init() {
        driveFO.init(hardwareMap);
        intake.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y/2;
        strafe = gamepad1.left_stick_x/2;
        rotate = gamepad1.right_stick_x/2;

        L1 = gamepad1.left_bumper;
        L2 = gamepad1.left_trigger > 0.3;

        if (L1){
            intakePower = 1;
        } else if (L2) {
            intakePower = -1;
        } else {
            intakePower = 0;
        }

        driveFO.driveFieldReltive(forward, strafe, rotate);
        intake.intake(intakePower);
}
}
