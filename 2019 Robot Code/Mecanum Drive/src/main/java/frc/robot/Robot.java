/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * This is a demo program showing how to use Mecanum control with the RobotDrive
 * class.
 */
public class Robot extends IterativeRobot {
  private static final int kFrontLeftChannel = 3;
  private static final int kRearLeftChannel = 2;
  private static final int kFrontRightChannel = 0;
  private static final int kRearRightChannel = 1;

  private static final int kJoystickChannel = 0;

  private MecanumDrive m_robotDrive;
  private Joystick m_stick;

  PWMVictorSPX frontLeft = new PWMVictorSPX(kFrontLeftChannel);
  PWMVictorSPX rearLeft = new PWMVictorSPX(kRearLeftChannel);
  PWMVictorSPX frontRight = new PWMVictorSPX(kFrontRightChannel);
  PWMVictorSPX rearRight = new PWMVictorSPX(kRearRightChannel);

  @Override
  public void robotInit() {

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    m_stick = new Joystick(kJoystickChannel);

  }

  @Override
  public void teleopPeriodic() {
    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    double x,y,z;
    y = m_stick.getRawAxis(0);
    x = -m_stick.getRawAxis(1);
    z = m_stick.getRawAxis(3);

    m_robotDrive.driveCartesian(y, x, z);

    //if the throttle is need to adjust
    /**double axisZ;
    axisZ = m_stick.getThrottle();

    m_stick.getRawAxis(2);*/

  }
}
