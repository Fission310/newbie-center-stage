package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.stuyfission.fissionlib.input.GamepadStatic;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.stuyfission.fissionlib.util.Mechanism;
import com.acmerobotics.dashboard.config.Config;

@Config
public class Claw extends Mechanism {
    private Servo clawservo;

    public static double openPos = 0;
    public static double closePos = 0;

    public Claw(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    @Override
    public void init(HardwareMap hwMap) {
        clawservo = hwMap.get(Servo.class, "clawservo");
        clawservo.setDirection(Servo.Direction.REVERSE);
        open();
    }

    public void open() {
        clawservo.setPosition(openPos);
    }

    public void close() {
        clawservo.setPosition(closePos);
    }

    @Override
    public void loop(Gamepad gamepad) {
        if (GamepadStatic.isButtonPressed(gamepad, Controls.CLAW_SCORE)) {
            open();
        }

        if (GamepadStatic.isButtonPressed(gamepad, Controls.CLAW_GRAB)) {
            close();
        }
    }
}
