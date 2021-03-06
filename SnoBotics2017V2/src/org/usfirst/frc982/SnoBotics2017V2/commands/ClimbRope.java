// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc982.SnoBotics2017V2.commands;
import edu.wpi.first.wpilibj.Relay;
// not used: import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc982.SnoBotics2017V2.Robot;
import org.usfirst.frc982.SnoBotics2017V2.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */
public class ClimbRope extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ClimbRope() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.ropeClimber);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    
    double startTime;
    double timeCommandHasBeenActive;
    
    /**
     *  As of 2/22/17 I'm setting the talons to voltage (percentVbus) mode.
     *  I'd like to experiment with current mode at some point.
     */
    protected void initialize() {
    	Robot.ropeClimber.setMode(TalonControlMode.PercentVbus); // or Current Mode
    	startTime = Timer.getFPGATimestamp();
    	// Robot.ropeClimber.turnCompressorOff();
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     *  Each time the execute method is called it will check to see if button
     *  4 is being pressed, if it is it will control the motor to climb
     *  the rope in response to the co-pilot's joystick. If this button is
     *  not being pressed the command voltage of the ropeClimber will
     *  be set to 0.
     *  
     *  Note that the definition of this joystick button is done in oi.java.
     *  As of this writing that has been defined as button 6.
     *  
     *  I would like to add checks for the current being used as well
     *  and display this value.
     *  
     *  I'm not sure how efficient this is, but I'll declare the variables used
     *  outside of the procedure.
     *  
     */
    
    boolean buttonState = false;
    double axisValue    = 0;
    
    protected void execute() {
    	/**
    	 *  Once the button state become false, by releasing the button the rope climber
    	 *  is stopped by setting the voltage to 0.
    	 */
    	buttonState = Robot.oi.buttonToConfirmRopeClimber.get();
    	if (buttonState) {
    		axisValue = Robot.oi.coPilotJoystick.getY();
    		if (axisValue < 0) {
    			Robot.ropeClimber.setMotorVoltage(axisValue);
    			Robot.ropeClimber.turnCompressorOff();
    			RobotMap.driveSystemSpikeForLights.set(Relay.Value.kReverse);
    		} else {
    		    Robot.ropeClimber.setMotorVoltage(0);
    		}
    	} else {
    		Robot.ropeClimber.setMotorVoltage(0);
    		Robot.ropeClimber.turnCompressorOn();
    		RobotMap.driveSystemSpikeForLights.set(Relay.Value.kForward);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     *   Don't check for the current draw until the command has been run for
     *   at least 1 second. The hard wired max is set to 38 Amps.
     *   
     *   The other more interesting stopping point will be when the robot
     *   has tripped the sensor at the top of the rope.
     */
    protected boolean isFinished() {
    	timeCommandHasBeenActive = Timer.getFPGATimestamp() - startTime;
    	boolean timeToQuit = false;
    	if (timeCommandHasBeenActive > 1.0) {
    		if (Robot.ropeClimber.getMotorCurrent() > 38) {
    			timeToQuit = true;
    		}
    	}
    	return timeToQuit;
    }


    // Called once after isFinished returns true
    protected void end() {
    	Robot.ropeClimber.setMotorVoltage(0.0);
    	Robot.ropeClimber.turnCompressorOn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ropeClimber.setMotorVoltage(0);
    	Robot.ropeClimber.turnCompressorOn();
    }
}
