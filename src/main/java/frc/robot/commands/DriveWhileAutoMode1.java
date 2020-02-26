/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;


public class DriveWhileAutoMode1 extends CommandBase {
  /**
   * Creates a new DriveWhileAutoMode1.
   */
  private double startTime;
  private double currentTime;

  public DriveWhileAutoMode1() {
    // Use addRequirements() here to declare subsystem dependencies. Type racer is a boring game jk it is fun it is a greeat eilsfnesibglkangfoieslhgkndskglejgsmmeionsa d trehteandsofijeslmeons i sond tknoefsliekmsunhrldsfmiehslmdgfosndf lmreonsa re the coolest thingflneing int ehw orlda dnalennisa dont lknoiwobgwyhn tnwsauehfLIez ohjuwaehfie klMFEIANSDA RBDNA THGEKJAnguHUDJA OIGKJA NS
    
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentTime = Timer.getFPGATimestamp();

    if ((currentTime - startTime) >= SmartDashboard.getNumber("AutoMode1SecondsTime", 1)){
      Robot.m_driveTrain.autoMode1MotorSet(0);
    }
    else{
      Robot.m_driveTrain.autoMode1MotorSet(SmartDashboard.getNumber("AutoMode1Speed", 0.8));
    }
  }

  // public void autoMode1Toggle() {

  //   if (autoMode1ToggleState){
  //     autoMode1ToggleState = false;
    
  //     leftMotors.set(SmartDashboard.getNumber("autoMode1MotorSpeed", 0.8));
  //     rightMotors.set(SmartDashboard.getNumber("autoMode1MotorSpeed", 0.8));
  
  //   }
  //   else{
  //     autoMode1ToggleState = true;
  //     leftMotors.set(0);
  //     rightMotors.set(0);
  //}
    
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
