/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.utilities.Navigation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

public class GyroTurnAutoTest extends CommandBase {
  /*
   * Creates a new GyroTurnAutoTest.
   */

   private double gyroAngleInitial;
   private double gyroCurrentAngle;
   private double turnAngleSpeed;
   private double angleToTurn;

  public GyroTurnAutoTest(double angleAmountTurned) {
    // Use addRequirements() here to declare subsystem dependencies.

    angleToTurn = angleAmountTurned;
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    try{
      gyroAngleInitial = Robot.m_navigation.getAngle();
    }

    catch(Exception exception){
      System.out.println("gyro initialization error" + exception);
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    try{
      turnAngleSpeed = SmartDashboard.getNumber("TurnToAngleSpeed", 0.8);

      gyroCurrentAngle = Robot.m_navigation.getAngle();
    
      if((gyroCurrentAngle - gyroAngleInitial) >= angleToTurn){
        Robot.m_driveTrain.turnToAngle(0);
      }

      else{
        Robot.m_driveTrain.turnToAngle(turnAngleSpeed); }
    
      }
    catch (Exception exception){
      System.out.println("gyro turn mechanism error" + exception);
       
    }
  
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
