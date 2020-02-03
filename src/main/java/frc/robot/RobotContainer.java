/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.intake.CommandAngulationDown;
import frc.robot.commands.intake.CommandAngulationUp;
import frc.robot.subsystems.SubsystemIntake;

public class RobotContainer {

  private static SubsystemIntake intake;
  private static CommandAngulationUp commandAngulationUp;
  private static CommandAngulationDown commandAngulationDown;
  private static Joystick joystick;
  private static JoystickButton j_Three;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    j_Three = new JoystickButton(joystick, Constants.J_THREE_NUMBER);
    j_Three.whenPressed(new ConditionalCommand(commandAngulationUp, commandAngulationDown, intake::getLSDown));
    
  }

  private void configureSubsystems() {
    intake = new SubsystemIntake(ConstantsIntake.MOTOR_ANGULATION_ID, ConstantsIntake.MOTOR_TO_TAKE_ID,
        ConstantsIntake.LIMITSWITCH_UP_ID, ConstantsIntake.LIMITSWITCH_DOWN_ID);
  }

  private void configureCommands() {
    commandAngulationUp = new CommandAngulationUp(intake, ConstantsIntake.SPEED_ANGULATION_UP);
    commandAngulationDown = new CommandAngulationDown (intake, ConstantsIntake.SPEED_ANGULATION_DOWN);
  }

  private void configureJoysticks() {
    joystick = new Joystick(Constants.JOYSTICK_ID);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  /*
   * public Command getAutonomousCommand() { // An ExampleCommand will run in
   * autonomous return m_autoCommand; }
   */

  public static SubsystemIntake subsIntake() {
    return intake;
  }

  public static JoystickButton j_Three(){
    return j_Three;
  } 
}