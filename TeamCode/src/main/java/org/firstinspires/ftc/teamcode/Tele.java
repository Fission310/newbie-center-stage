package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.Arm;
import org.firstinspires.ftc.teamcode.mechanisms.Claw;
import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.mechanisms.Slides;

@TeleOp(name = "teleop")
public class Tele extends LinearOpMode  {
    public void runOpMode() throws InterruptedException {
        // initialize the stuff
        Arm arm = new Arm(this);
        Claw claw = new Claw(this);
        Drivetrain drivetrain = new Drivetrain(this);
        Slides slides = new Slides(this);
        arm.init(hardwareMap);
        claw.init(hardwareMap);
        drivetrain.init(hardwareMap);
        slides.init(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            // game loop
            // call the loop methods for mechanisms
            arm.loop(gamepad1);
            claw.loop(gamepad1);
            drivetrain.loop(gamepad1);
            slides.loop(gamepad1);
        }
    }
}
