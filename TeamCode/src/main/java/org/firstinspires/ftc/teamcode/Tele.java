package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "teleop")
public class Tele extends LinearOpMode  {
    public void runOpMode() throws InterruptedException {
        // initialize the stuff
        
        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            // game loop
            
            // call the loop methods for mechanisms
        }
    }
}
