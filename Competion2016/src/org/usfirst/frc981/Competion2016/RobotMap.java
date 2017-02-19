// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc981.Competion2016;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogInput driveTrainSubSystemAnalogInputOfPresssureSensor;
    public static CANTalon driveTrainSubSystemCanTalon3;
    public static CANTalon driveTrainSubSystemCanTalon4;
    public static CANTalon driveTrainSubSystemCanTalon2;
    public static CANTalon driveTrainSubSystemCanTalon5;
    public static RobotDrive driveTrainSubSystemRobotDrive;
    public static SpeedController shooterSubsystemKickerController;
    public static CANTalon shooterSubsystemCanTalonForTilt;
    public static SpeedController shooterSubsystemLeftFlywheelController;
    public static SpeedController shooterSubsystemRightFlywheelController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainSubSystemAnalogInputOfPresssureSensor = new AnalogInput(0);
        LiveWindow.addSensor("DriveTrainSubSystem", "Analog Input Of Presssure Sensor", driveTrainSubSystemAnalogInputOfPresssureSensor);
        
        driveTrainSubSystemCanTalon3 = new CANTalon(3);
        LiveWindow.addActuator("DriveTrainSubSystem", "Can Talon 3", driveTrainSubSystemCanTalon3);
        
        driveTrainSubSystemCanTalon4 = new CANTalon(4);
        LiveWindow.addActuator("DriveTrainSubSystem", "Can Talon 4", driveTrainSubSystemCanTalon4);
        
        driveTrainSubSystemCanTalon2 = new CANTalon(2);
        LiveWindow.addActuator("DriveTrainSubSystem", "Can Talon 2", driveTrainSubSystemCanTalon2);
        
        driveTrainSubSystemCanTalon5 = new CANTalon(5);
        LiveWindow.addActuator("DriveTrainSubSystem", "Can Talon 5", driveTrainSubSystemCanTalon5);
        
        driveTrainSubSystemRobotDrive = new RobotDrive(driveTrainSubSystemCanTalon3, driveTrainSubSystemCanTalon4,
              driveTrainSubSystemCanTalon2, driveTrainSubSystemCanTalon5);
        
        driveTrainSubSystemRobotDrive.setSafetyEnabled(true);
        driveTrainSubSystemRobotDrive.setExpiration(0.1);
        driveTrainSubSystemRobotDrive.setSensitivity(0.5);
        driveTrainSubSystemRobotDrive.setMaxOutput(1.0);

        driveTrainSubSystemRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainSubSystemRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        shooterSubsystemKickerController = new TalonSRX(2);
        LiveWindow.addActuator("ShooterSubsystem", "KickerController", (TalonSRX) shooterSubsystemKickerController);
        
        shooterSubsystemCanTalonForTilt = new CANTalon(1);
        LiveWindow.addActuator("ShooterSubsystem", "Can Talon For Tilt", shooterSubsystemCanTalonForTilt);
        
        shooterSubsystemLeftFlywheelController = new Spark(0);
        LiveWindow.addActuator("ShooterSubsystem", "LeftFlywheelController", (Spark) shooterSubsystemLeftFlywheelController);
        
        shooterSubsystemRightFlywheelController = new Spark(1);
        LiveWindow.addActuator("ShooterSubsystem", "RightFlywheelController", (Spark) shooterSubsystemRightFlywheelController);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}