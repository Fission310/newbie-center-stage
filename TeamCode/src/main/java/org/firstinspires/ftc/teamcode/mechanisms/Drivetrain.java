package org.firstinspires.ftc.teamcode.mechanisms;

import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.PoseVelocity2d; 
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.stuyfission.fissionlib.util.Mechanism;

import org.firstinspires.ftc.teamcode.MecanumDrive;

public class Drivetrain extends Mechanism {

    MecanumDrive rrDrive;

    public Drivetrain(LinearOpMode opMode) { this.opMode = opMode; } 

    @Override
    public void init(HardwareMap hwMap) {
        rrDrive = new MecanumDrive(hwMap);
    }
    @Override
    public void loop(Gamepad gamepad) {
        rrDrive.setDrivePowers(

                new PoseVelocity2d(
                  new Vector2d (
                        -gamepad.left_stick_y,
                        -gamepad.left_stick_x,
                            ),
                  -gamepad.right.right_stick_x
                  )
                    );
        rrDrive.update();
    }
}
