package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.stuyfission.fissionlib.input.GamepadStatic;


public class Arm {
    private LinearOpMode opMode;

    private Servo leftServo;
    private Servo rightServo;

    public static final double SCORE_POS = 0;
    public static final double GRAB_POS = 0;

    public Arm(LinearOpMode opMode){
        this.opMode = opMode;
    }

    public void init(HardwareMap hwMap){
        leftServo = hwMap.get(Servo.class, "armLeftServo");
        rightServo = hwMap.get(Servo.class, "armRightServo");

        leftServo.setPosition(GRAB_POS);
        rightServo.setPosition(GRAB_POS);
    }

    public void score(){
        leftServo.setPosition(SCORE_POS);
        rightServo.setPosition(SCORE_POS);
    }

    public void loop(Gamepad gamepad) {
        if (GamepadStatic.isButtonPressed(gamepad, Controls.ARM)) {
            score();
        }
    }

}
