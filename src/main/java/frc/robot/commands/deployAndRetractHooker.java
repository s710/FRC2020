/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class deployAndRetractHooker extends CommandBase {
  /**
   * Creates a new deployAndRetractHooker.
   */
  private double startTime;
  private boolean finished;
  private double HookerFromBarTime;
  private double HookerToBarTime;
  private double currentTime;

  public deployAndRetractHooker() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    HookerToBarTime = SmartDashboard.getNumber("HookerToBarTime", 0.5);
    HookerFromBarTime = SmartDashboard.getNumber("HookerFromBarTime", 0.5);
    finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentTime = Timer.getFPGATimestamp();

    if(Robot.m_winchHooker.hookerBarState){
      if(currentTime - startTime <= HookerFromBarTime){
        Robot.m_winchHooker.turnHookerFromBar();
      }
      else{
        Robot.m_winchHooker.hookerFromBarComplete();
        finished = true;
      }
    }
    else if(!Robot.m_winchHooker.hookerBarState){
      if(currentTime - startTime <= HookerToBarTime){
        Robot.m_winchHooker.turnHookerToBar();
      }
      else{
        Robot.m_winchHooker.hookerToBarComplete();
        finished = true;
      }
    }


    
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
