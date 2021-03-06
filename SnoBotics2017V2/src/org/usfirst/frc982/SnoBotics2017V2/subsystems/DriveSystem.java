// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc982.SnoBotics2017V2.subsystems;

import org.usfirst.frc982.SnoBotics2017V2.Robot;
import org.usfirst.frc982.SnoBotics2017V2.RobotMap;
import org.usfirst.frc982.SnoBotics2017V2.commands.*;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
// not used: import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveSystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon cANTalon1 = RobotMap.driveSystemCANTalon1;
    private final CANTalon cANTalon2 = RobotMap.driveSystemCANTalon2;
    private final CANTalon cANTalon4 = RobotMap.driveSystemCANTalon4;
    private final CANTalon cANTalon5 = RobotMap.driveSystemCANTalon5;
    private final RobotDrive robotDrive4 = RobotMap.driveSystemRobotDrive4;
    private final CANTalon cANTalon3 = RobotMap.driveSystemCANTalon3;
    private final CANTalon cANTalon6 = RobotMap.driveSystemCANTalon6;
    private final DoubleSolenoid shiftSolenoid = RobotMap.driveSystemShiftSolenoid;
    private final Encoder leftQuadratureEncoder = RobotMap.driveSystemLeftQuadratureEncoder;
    private final Encoder rightQuadratureEncoder = RobotMap.driveSystemRightQuadratureEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    /**
     *  The logic for setting up Talons 3 and 6 to following 1 and 3
     *  lives in the RobotMap class.
     */
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveWithJoysticks());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void shiftToHigh () {
    	shiftSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftToLow () {
    	shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean shiftedHigh () {
    	return (shiftSolenoid.get() == DoubleSolenoid.Value.kForward);
    }
    
    public boolean shiftedLow () {
    	return (shiftSolenoid.get() == DoubleSolenoid.Value.kReverse);
    }
    
    /**
     *  Following the example from the RobotBuilder document will create a function
     *  for taking the joy stick inputs and driving the motors for the drive system.
     *  Note the logic for setting up the talons 3 and 6 to follow 1 and 4 lives
     *  in the RobotMap class. Maybe next year they will have a robotDrive6 class.
     */
    
    public void useJoystickInputs () {
    	//robotDrive4.tankDrive(Robot.oi.leftJoystick, Robot.oi.rightJoystick);
    	double leftValue = -Robot.oi.leftJoystick.getY();
    	double rightValue = Robot.oi.rightJoystick.getY();
    	robotDrive4.tankDrive(leftValue, rightValue);
    }
    
    public void stop () {
    	robotDrive4.drive (0.0, 0.0);
    }
    
    public void driveLeft () {
    	robotDrive4.tankDrive(0.25, 0.0, false);
    }
    public void driveRight() {
    	robotDrive4.tankDrive(0.0,  0.25, false);
    }
    
    public double getLeftEncoderCount () {
    	return leftQuadratureEncoder.get();
    }
    
    public double getRightEncoderCount () {
    	return rightQuadratureEncoder.get();
    }
    
    public void autoDrive (double speedLeft, double speedRight) { // should be deprecated
    	// may need to change signs to get thing moving in the 'correct' direction
    	// note how I have a negative sign for the leftValue in the useJoystickInput function
    	robotDrive4.tankDrive(speedLeft, -speedRight);
    }
    
    public void autoDriveReverse (double speed) {
    	// may need to change signs to get thing moving in the 'correct' direction
    	// note how I have a negative sign for the leftValue in the useJoystickInput function
    	robotDrive4.tankDrive(speed, -speed);
    }
    
    public void autoDriveForward (double speed) {
    	// may need to change signs to get thing moving in the 'correct' direction
    	// note how I have a negative sign for the leftValue in the useJoystickInput function
    	robotDrive4.tankDrive(-speed, +speed);
    }
    
    public void autoDriveTurnLeft (double speed) {
    	robotDrive4.tankDrive(speed, speed);
    }
    
    public void autoDriveTurnRight (double speed) {
    	robotDrive4.tankDrive(-speed, -speed);
    }
}

