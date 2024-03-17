package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.stuyfission.fissionlib.input.GamepadStatic;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.stuyfission.fissionlib.util.Mechanism;
import com.acmerobotics.dashboard.config.Config;
@Config
public class Claw extends Mechanism{
    private boolean ServoOpen = true;

    private Servo clawservo;

    public static double Open_Pos = 0;
    public static double Close_Pos = 0;

    public Claw(LinearOpMode opMode) {this.opMode = opMode;}

    @Override
    public void init(HardwareMap hwMap) {
        clawservo = hwMap.get(Servo.class, "clawservo");
        clawservo.setDirection(Servo.Direction.REVERSE);
        ServoOpen();
    }

    public void ServoOpen() {
        clawservo.setPosition(Open_Pos);
        ServoOpen = true;
    }

    public void close() {
        clawservo.setPosition(Close_Pos);
        ServoOpen = false;
    }
    @Override
    public void loop(Gamepad gamepad) {
        if (GamepadStatic.isButtonPressed(gamepad, Controls.CLAW_SCORE))
        {ServoOpen();}

        if (GamepadStatic.isButtonPressed(gamepad, Controls.CLAW_GRAB))
        {close();}}


    }
