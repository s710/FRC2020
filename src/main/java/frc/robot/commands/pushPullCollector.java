/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class pushPullCollector extends CommandBase {
  /**
   * Creates a new pushPullCollector.
   */
  private double startTime;
  private double currentTime;
  private double timeDeploy;
  private double timeRetract;
  private boolean isFinished;

  public pushPullCollector() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    timeDeploy = SmartDashboard.getNumber("CollectorDeployTime", 1);
    timeRetract = SmartDashboard.getNumber("CollectorRetractTime", 1);
    isFinished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    currentTime = Timer.getFPGATimestamp();
    
    //check limit switch

  if(Robot.m_ballCollector.isRetracted) {
    if((currentTime - startTime) < timeDeploy){
     
      Robot.m_ballCollector.motorOnDeploy(); 
    
    }
    else{
      Robot.m_ballCollector.motorKillDeploy();
      isFinished = true;
    }
  }
  else if(!Robot.m_ballCollector.isRetracted){
    if((currentTime - startTime) < timeRetract){
     
      Robot.m_ballCollector.motorOnRectract(); 
    
    }
    else{
      Robot.m_ballCollector.motorKillRetract();
      isFinished = true;
    }
  }
    
  

      // MOVE TO THE SUBSYSTEM BECAuSE LoGIC CAn ONLY BE in THE SUbSYTeM!1


    }
    
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    //we are done turn off motors
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
