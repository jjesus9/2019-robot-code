/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  PWMVictorSPX frontleft = new PWMVictorSPX(RobotMap.frontleft);
  PWMVictorSPX rearleft = new PWMVictorSPX(RobotMap.rearleft);

  SpeedControllerGroup left = new SpeedControllerGroup(frontleft, rearleft);

  PWMVictorSPX frontright = new PWMVictorSPX(RobotMap.frontright);
  PWMVictorSPX rearright = new PWMVictorSPX(RobotMap.rearright);

  SpeedControllerGroup right = new SpeedControllerGroup(frontright, rearright);

  public DifferentialDrive drive = new DifferentialDrive(left, right);

  public void manualDrive(double move, double turn){
    
    //deadband the joystick

    //set a maxSpeed
    //if(move > RobotMap.maxSpeed) move = .5;

    drive.arcadeDrive(move, turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualDriveCommand());
  }
}
