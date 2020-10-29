package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Susbsystems.MyGamePad;
import org.firstinspires.ftc.teamcode.Susbsystems.MyRobot;

/**
 *
 */
@TeleOp(name = "MyTeleop", group = "Teleop")
public class MyTeleop extends LinearOpMode {


    MyRobot eustace2;
    MyGamePad myGamePad;

    @Override
    public void runOpMode()  {


        eustace2 = new MyRobot(hardwareMap);
        myGamePad = new MyGamePad(gamepad1);

        eustace2.initRobot();

        waitForStart();

        while (opModeIsActive()){

            myGamePad.executeGamePad(eustace2);
        }

    }
}
