/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.driver.CommandDriver;
import frc.robot.subsystems.SubsystemDriver;

public class RobotContainer {

  private static SubsystemDriver driver;
  private static XboxController xboxController;
  private static CommandDriver runDriver;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  private void configureSubsystems() {
    driver = new SubsystemDriver(
            ConstantsDriver.MOTOR_LEFT_FRONT_ID,
            ConstantsDriver.MOTOR_LEFT_REAR_ID,
            ConstantsDriver.MOTOR_RIGHT_FRONT_ID,
            ConstantsDriver.MOTOR_RIGHT_REAR_ID,
            ConstantsDriver.ENCODER_LEFT_CHANNEL_A_ID,
            ConstantsDriver.ENCODER_LEFT_CHANNEL_B_ID,
            ConstantsDriver.ENCODER_RIGHT_CHANNEL_A_ID,
            ConstantsDriver.ENCODER_RIGHT_CHANNEL_B_ID,
            ConstantsDriver.ENCODERS_MAX_PERIOD,
            ConstantsDriver.ENCODERS_MIN_RATE,
            ConstantsDriver.ENCODERS_DISTANCE_PER_PULSE,
            Constants.DEADBAND_VALUE,
            ConstantsDriver.ENCODER_LEFT_INVERTED,
            ConstantsDriver.ENCODER_RIGHT_INVERTED);
  }

  private void configureCommands() {
    runDriver = new CommandDriver(driver);
  }
  private void configureJoysticks() {
    xboxController = new XboxController(Constants.XBOX_ID);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  /*
    public Command getAutonomousCommand() {
      // An ExampleCommand will run in autonomous
      return m_autoCommand;
    }
  */
  
  public static SubsystemDriver subsDriver() {
    return driver;
  }
  
  public static XboxController xboxController(){
    return xboxController;
  }
  
  // Obtém o valor referente ao eixo LY do controle de XBOX
  public static double axis_LY(){
    return ConstantsDriver.LIMITER_LINEAR * xboxController.getRawAxis(1);
  }
  
    // Obtém o valor referente ao eixo RX do controle de XBOX invertido
  public static double axis_RX(){
    return ConstantsDriver.LIMITER_ROTATION * xboxController.getRawAxis(4);
  }
  
  public static CommandDriver commDriver(){
    return runDriver;
  }
}