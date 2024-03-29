/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.inverseLauncher;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.launcher;
import frc.robot.commands.motorFeederintoShooter;
import frc.robot.commands.pushPullCollector;
import frc.robot.commands.retractHooker;
import frc.robot.commands.ClrWeelSpinner;
import frc.robot.commands.CommandGroupAutonomousTest;
import frc.robot.commands.RealHookerDeployCmd;
import frc.robot.commands.TestCommandForStuff;
import frc.robot.commands.belt;
import frc.robot.commands.killClrWheelSpinner;
import frc.robot.commands.winchCmd;
import frc.robot.commands.winchKill;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Joystick joy = new Joystick(0);




  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //logitechController.getRawAxis(leftYAxis);

    JoystickButton x = new JoystickButton(joy, 1);
    JoystickButton a = new JoystickButton(joy, 2);
    JoystickButton b = new JoystickButton(joy, 3);
    JoystickButton y = new JoystickButton(joy, 4);
    JoystickButton lb = new JoystickButton(joy, 5);
    JoystickButton rb = new JoystickButton(joy, 6);
    JoystickButton lt = new JoystickButton(joy, 7);
    JoystickButton rt = new JoystickButton(joy, 8);
    JoystickButton back = new JoystickButton(joy, 9);
    JoystickButton start = new JoystickButton(joy, 10);
    //JoystickButton r_dpad = new JoystickButton(joy, 11); 
      
    b.whenPressed(new launcher());
    // x.whenPressed(new inverseLauncher());
    y.whenPressed(new belt());
    a.whenPressed(new motorFeederintoShooter());
    
    // rt.whenHeld(new ClrWeelSpinner());
    // rt.whenReleased(new killClrWheelSpinner());
    
    // lt.whenHeld(new winchCmd());
    // lt.whenReleased(new winchKill());
    
    lt.whileHeld(new winchCmd());

    // lb.whenPressed(new runBallCollector());
    lb.whenPressed(new pushPullCollector());
    rt.whileHeld(new RealHookerDeployCmd());
    rb.whileHeld(new retractHooker());
    System.out.println("reached button assignment in robot container");

  }



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   *  the command to run in autonomous
   */
}
