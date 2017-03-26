// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc982.SnoBotics2017V2;

import org.usfirst.frc982.SnoBotics2017V2.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
// not used: import org.usfirst.frc982.SnoBotics2017V2.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton joystickTriggerShiftToLow;
    public JoystickButton joystickButtonDriveLeftMotors;
    public Joystick leftJoystick;
    public JoystickButton joystickTriggerShiftToHigh;
    public JoystickButton joystickButtonDriveRightMotors;
    public Joystick rightJoystick;
    public JoystickButton buttontoCloseGearPaddles;
    public JoystickButton buttonToOpenGearPaddles;
    public JoystickButton buttonToDumpFuelContainer;
    public JoystickButton buttontoReturnFuelContainer;
    public Joystick coPilotJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * After the end of the autogenerated code I'm adding a new joystick button
     * for the confirmation button for raising the rope climber.
     * For lifting the rope climber button 4 on the co-pilot joystick must
     * be pressed. To have complete control of the forward and reverse directions
     * all 3 button #4 must be pressed at the same time.
     */
    
    public JoystickButton buttonToConfirmRopeClimber;
    public JoystickButton button1ToConfirmReverseRopeClimber;
    public JoystickButton button2ToConfirmReverseRopeClimber;
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        coPilotJoystick = new Joystick(2);
        
        buttontoReturnFuelContainer = new JoystickButton(coPilotJoystick, 5);
        buttontoReturnFuelContainer.whenPressed(new ReturnFuelDumper());
        buttonToDumpFuelContainer = new JoystickButton(coPilotJoystick, 3);
        buttonToDumpFuelContainer.whenPressed(new DumpFuel());
        buttonToOpenGearPaddles = new JoystickButton(coPilotJoystick, 2);
        buttonToOpenGearPaddles.whileHeld(new OpenGearPaddles());
        buttontoCloseGearPaddles = new JoystickButton(coPilotJoystick, 6);
        buttontoCloseGearPaddles.whileHeld(new CloseGearPaddles());
        rightJoystick = new Joystick(1);
        
        joystickButtonDriveRightMotors = new JoystickButton(rightJoystick, 2);
        joystickButtonDriveRightMotors.whileHeld(new DriveRightMotors());
        joystickTriggerShiftToHigh = new JoystickButton(rightJoystick, 1);
        joystickTriggerShiftToHigh.whenPressed(new ShiftToHigh());
        leftJoystick = new Joystick(0);
        
        joystickButtonDriveLeftMotors = new JoystickButton(leftJoystick, 2);
        joystickButtonDriveLeftMotors.whileHeld(new DriveLeftMotors());
        joystickTriggerShiftToLow = new JoystickButton(leftJoystick, 1);
        joystickTriggerShiftToLow.whenPressed(new ShiftToLow());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
     SmartDashboard.putData("Dump Fuel", new DumpFuel());
     SmartDashboard.putData("Return Fuel Dumper", new ReturnFuelDumper());
     SmartDashboard.putData("Climb Rope", new ClimbRope());
     SmartDashboard.putData("Close Gear Paddles", new CloseGearPaddles());
     SmartDashboard.putData("Open Gear Paddles", new OpenGearPaddles());
     SmartDashboard.putData("Drive Left Motors", new DriveLeftMotors());
     SmartDashboard.putData("Drive Right Motors", new DriveRightMotors());
     // *** SmartDashboard.putData("Monitor Health", new MonitorHealth());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        /**
         * After the end of the auto-generated code I'm adding a new set of
         * joystick buttons for the confirmation button for raising the rope climber.
         */
        
        buttonToConfirmRopeClimber = new JoystickButton(coPilotJoystick, 4);
        button1ToConfirmReverseRopeClimber = new JoystickButton(leftJoystick, 4);
        button2ToConfirmReverseRopeClimber = new JoystickButton(rightJoystick, 4);
        
        /**
         *  While button 4 of the left joystick is pressed the command ReverseRopeClimber
         *  will be run. The command will only allow the motor of the rope climber
         *  to be activated if the other two buttons above are pressed.
         */
        
        button1ToConfirmReverseRopeClimber.whileHeld(new ReverseRopeClimber());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getCoPilotJoystick() {
        return coPilotJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

