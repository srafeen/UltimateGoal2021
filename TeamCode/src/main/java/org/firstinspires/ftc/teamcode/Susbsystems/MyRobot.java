package org.firstinspires.ftc.teamcode.Susbsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class MyRobot {

    HardwareMap myhardWareMap;

    //4 wheel motors;
    DcMotor frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel;

    //IntakeMotor
    DcMotor intakeMotor;

    //ArmMotor;
    DcMotor armMotor;

    //Arm grip servo
    Servo armGrips;

    //MagazineServo
    CRServo magazineServo;

    //Subsystems
    Chassis robotChassis;
    Arm robotArm;
    Intake robotIntake;
    Magazine robotMagazine;
    Launcher robotLauncher;



    public MyRobot(HardwareMap hardwareMap) {

        myhardWareMap = hardwareMap;

    }

    public void initRobot(){

        //wheels
        frontLeftWheel = myhardWareMap.dcMotor.get("front_left_motor");
        frontRightWheel = myhardWareMap.dcMotor.get("front_right_wheel");
        backLeftWheel = myhardWareMap.dcMotor.get("back_left_motor");
        backRightWheel = myhardWareMap.dcMotor.get("back_right_motor");

        //intake
        intakeMotor = myhardWareMap.dcMotor.get("intake_motor");

        //Arm
        armMotor = myhardWareMap.dcMotor.get("arm_motor");

        //Arm grips
        armGrips = myhardWareMap.servo.get("armgrip_servo");

        //Magazine
        magazineServo = myhardWareMap.crservo.get("magazine_crservo");


    }

    public void initSubsystems(){

        robotChassis = new Chassis();
        robotArm = new Arm();
        robotIntake = new Intake();
        robotMagazine = new Magazine();
        robotLauncher = new Launcher();
    }


}
