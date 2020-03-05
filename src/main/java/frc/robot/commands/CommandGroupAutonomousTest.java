/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class CommandGroupAutonomousTest extends SequentialCommandGroup {
  /**
   * Creates a new CommandGroupAutonomousTest.
   */
  private boolean finished;
  public CommandGroupAutonomousTest() {
    // Use addRequirements() here to declare subsystem dependencies.
    
  
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    new DriveWhileAutoMode1();
    new GyroTurnAutoTest(90);
    new DriveWhileAutoMode1();
    new GyroTurnAutoTest(90);
    new DriveWhileAutoMode1();
    new GyroTurnAutoTest(90);
    new DriveWhileAutoMode1();
    new GyroTurnAutoTest(90);
    finished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
