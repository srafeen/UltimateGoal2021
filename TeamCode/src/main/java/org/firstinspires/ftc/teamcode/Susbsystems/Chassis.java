package org.firstinspires.ftc.teamcode.Susbsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Chassis {
    
    MyRobot robot;

    public Chassis() {
    }

    public Chassis(MyRobot myRobot) {
        
        robot = myRobot;
    }

    /**
     * Method to move chassis based on computed vector inputs from Gamepad Joystick inputs
     * @param targetAngle targetAngle = Math.atan2(leftStickY, leftStickX)
     * @param turn turn = rightStickX
     * @param power power = Math.hypot(leftStickX, leftStickY)
     */
    public void runChassis(double targetAngle, double turn, double power) {
        //Rotate angle by 45 degrees to align to diagonal angles on mecannum wheel setup
        double turnAngle = targetAngle - Math.PI / 4;

        //Distribute power to wheels a cos and sin of vector.
        // Add turn as input from right stick to add in radians
        robot.frontLeftWheel.setPower(power * Math.cos(turnAngle) + turn);
        robot.frontRightWheel.setPower(power * Math.sin(turnAngle) - turn);
        robot.backLeftWheel.setPower(power * Math.sin(turnAngle) + turn);
        robot.frontRightWheel.setPower(power * Math.cos(turnAngle) - turn);
        setZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * Function to set the behaviour of the motor on passing Zero power to the motor <BR>
     * @param zeroBehavior could be BRAKE or FLOAT. When not defined, it is set
     *                          to UNKNOWN state, which is not desired.
     */
    private void setZeroBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {

        robot.frontLeftWheel.setZeroPowerBehavior(zeroBehavior);
        robot.frontRightWheel.setZeroPowerBehavior(zeroBehavior);
        robot.backLeftWheel.setZeroPowerBehavior(zeroBehavior);
        robot.backRightWheel.setZeroPowerBehavior(zeroBehavior);
    }


}
