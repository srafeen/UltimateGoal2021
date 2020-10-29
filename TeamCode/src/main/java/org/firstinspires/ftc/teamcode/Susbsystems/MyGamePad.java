package org.firstinspires.ftc.teamcode.Susbsystems;

import com.qualcomm.robotcore.hardware.Gamepad;

public class MyGamePad {

    Gamepad gamepadHandle;
    MyRobot robot;

    public MyGamePad(Gamepad gamepadObj ) {

        gamepadHandle = gamepadObj;
    }

    public MyGamePad(Gamepad gamepadObj , MyRobot myRobot) {

        robot = myRobot;
        gamepadHandle = gamepadObj;
    }
    public void executeGamePadJoyStick(MyRobot robot){

        double leftStickX = turboMode(getLeftStickX());
        double leftStickY = turboMode(getLeftStickY());
        double rightStickX = turboMode(getRightStickX());
        double power = Math.hypot(leftStickX, leftStickY);
        double targetAngle = Math.atan2(leftStickY, leftStickX);
        double turn = rightStickX;

            robot.robotChassis.runChassis(power, targetAngle, turn);

    }

    /**
     *
     */
    public void executeGamePadButtonControls(){

        //Launches Ring
        if(getLeftTrigger()>0.5) {

        }

        //Dynamic Turbo
        if (getLeftBumperPress()) {

        }

        //Grip Arm Servos
        if (getRightBumperPress()) {

        }

        //Power Shot 1
        if (getButtonXPress()) {

        }

        //Power Shot 2
        if (getButtonBPress()) {

        }

        //Power Shot 3
        if (getButtonAPress()) {

        }

        //Power level goal; either High, Middle, Low Goal
        if (getButtonYPress()) {

        }

        //Reverse or Stop Intake
        if (getDpad_upPress()) {

        }

        //Ring Pushes out of Intake
        if (getDpad_downPress()) {

        }

    }

    /**
     * Method to implement turbo speed mode - from reduced speed of 25% of cubic factor to
     * 100% speed, but controlled by acceleration of the force of pressing the Right Tigger.
     *
     * @param stickInput input value of button stick vector
     * @return modified value of button stick vector
     */
    public double turboMode(double stickInput) {

        double acceleration_factor;
        double rightTriggerValue;

        double turboFactor;

        rightTriggerValue = getRightTrigger();
        acceleration_factor = 1.0 + 3.0 * rightTriggerValue;
        turboFactor = limitStick(stickInput) * acceleration_factor;
        return turboFactor;
    }

    /**
     * Method to convert linear map from gamepad1 stick input to a cubic map
     *
     * @param stickInput input value of button stick vector
     * @return Cube of the stick input reduced to 25% speed
     */
    public double limitStick(double stickInput) {
        return (stickInput * stickInput * stickInput * 0.25);
    }

    /**
     * Methods to get the value of gamepad Right Trigger for turbo mode (max speed).
     * This is the method to apply any modifiers to match to action of turbo mode for each driver preference.
     * For Hazmat Skystone Right Trigger pressed means turbo mode on.
     *
     * @return gpGamepad1.right_trigger
     */
    private double getRightTrigger() {
        return gamepadHandle.right_trigger;
    }

    /**
     * Methods to get the value of gamepad Left Trigger for <TO-BE-UPDATED>
     *
     * @return gpGamepad1.right_trigger
     */
    private double getLeftTrigger() {
        return gamepadHandle.left_trigger;
    }

    /**
     * Methods to get the value of gamepad Left stick X for Pan motion X direction.
     * This is the method to apply any directional modifiers to match to the X plane of robot.
     * No modifier needed for Hazmat Skystone Robot.
     *
     * @return gpGamepad1.left_stick_x
     */
    private double getLeftStickX() {
        return gamepadHandle.left_stick_x;
    }

    /**
     * Methods to get the value of gamepad Left stick Y for Pan motion Y direction.
     * This is the method to apply any directional modifiers to match to the Y plane of robot.
     * For Hazmat Skystone Robot, Y direction needs to be inverted.
     *
     * @return gpGamepad1.left_stick_y * (-1)
     */
    private double getLeftStickY() {

        return gamepadHandle.left_stick_y * (-1);
        //return gamepadHandle.left_stick_y;
    }

    /**
     * Methods to get the value of gamepad Right stick X to keep turning.
     * This is the method to apply any directional modifiers to match to the turn direction robot.
     * No modifier needed for Hazmat Skystone Robot.
     *
     * @return gpGamepad1.right_stick_x
     */
    private double getRightStickX() {
        return gamepadHandle.right_stick_x;
    }




    private boolean getDpad_downPress() {

        return true;
    }

    private boolean getDpad_upPress() {

        return true;
    }

    private boolean getButtonYPress() {

        return  true;
    }

    private boolean getButtonAPress() {

        return true;
    }

    private boolean getButtonBPress() {

        return true;
    }

    private boolean getButtonXPress() {

        boolean buttonXPressedFlag = false;

        return buttonXPressedFlag;
    }

    private boolean getRightBumperPress() {

        boolean rightBumperPresedFlag = false;

        return rightBumperPresedFlag;
    }

    private boolean getLeftBumperPress() {

        boolean leftBumperPressedFlag = false;

        return leftBumperPressedFlag;
    }


    public void executeGamePad(MyRobot eustace2) {

        executeGamePadJoyStick(eustace2);
        executeGamePadButtonControls();
    }
}
