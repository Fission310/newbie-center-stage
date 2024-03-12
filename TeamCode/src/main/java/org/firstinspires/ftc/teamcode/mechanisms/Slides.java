package org.firstinspires.ftc.teamcode.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.stuyfission.fissionlib.input.GamepadStatic;
import com.stuyfission.fissionlib.util.Mechanism;

import org.firstinspires.ftc.teamcode.PIDController;

@Config
public class Slides extends Mechanism {

    public static double LOW_POS = 0;
    public static double MED_POS = 0;
    public static double HIGH_POS = 0;

    public static int ABIT = 140;

    public static double KP = 0.003;
    public static double KI = 0;
    public static double KD = 0;
    public static double MIN_POWER = -0.3;
    public static double target = 0;
    public static double power = 0;

    private final PIDController controller = new PIDController(KP, KI, KD);

    private final DcMotorEx[] motors = new DcMotorEx[2];

    public Slides(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    @Override
    public void init(HardwareMap hwMap) {
        motors[0] = hwMap.get(DcMotorEx.class, "slidesLeftMotor");
        motors[1] = hwMap.get(DcMotorEx.class, "slidesRightMotor");


        motors[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motors[0].setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motors[1].setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        motors[0].setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motors[1].setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        motors[0].setDirection(DcMotorEx.Direction.REVERSE);
        motors[1].setDirection(DcMotorEx.Direction.FORWARD);
    }

    public double getPosition() {
        return motors[0].getCurrentPosition();
    }
    public void setTarget(double target) {
        Slides.target = target;
    }
    public void lowPos() {
        setTarget(LOW_POS);
    }

    public void medPos() {
        setTarget(MED_POS);
    }

    public void highPos() {
        setTarget(HIGH_POS);
    }

    public void upABit() {
        setTarget(target + ABIT);
    }

    public void downABit() {
        setTarget(target - ABIT);
    }

    public void update() {
        controller.setTarget(target);
        power = controller.calculate(getPosition());
        if (power < MIN_POWER) {
            power = MIN_POWER;
        }
        motors[0].setPower(power);
        motors[1].setPower(power);
    }

    public void loop(Gamepad gamepad) {
        update();
        if (GamepadStatic.isButtonPressed(gamepad, Controls.LOW)) {
            lowPos();
        } else if (GamepadStatic.isButtonPressed(gamepad, Controls.MED)) {
            medPos();
        } else if (GamepadStatic.isButtonPressed(gamepad, Controls.HIGH)) {
            highPos();
        }
    }
}