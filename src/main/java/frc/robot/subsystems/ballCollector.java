/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants.VICTOR_CLASS;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;


public class ballCollector extends SubsystemBase {
  /**
   * Creates a new ballCollector.
   */

  private static VictorSPX collectorMotor = new VictorSPX(VICTOR_CLASS.VICTOR_BALL_COLLECTOR_MOTOR_ID);

  private boolean collectorState;
  public boolean isRetracted;
  // private double timerThreshold;
  // private double whileLoopTime;
  // private double updatingCollectorTime;
  // private double starCollectorTime;
  // private double collectorTimeSnapshot;
  // private double deployUpdatingTime;



  public ballCollector() {

    collectorState = false;
    isRetracted = true;



  }

  public void collectorToggle(){
    
    if(collectorState){
      collectorMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("BallCollectorSpeed", 0.15));
      collectorState = false;

    }
    else
    {
      collectorMotor.set(ControlMode.PercentOutput, 0);
      collectorState = true;
    }
  }

  public void motorKillDeploy(){
    collectorMotor.set(ControlMode.PercentOutput, 0);
    isRetracted = false;
  }

  public void motorOnDeploy(){
    collectorMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("DeploySpeed", 0.15));
  }

  public void motorKillRetract(){
    collectorMotor.set(ControlMode.PercentOutput, 0);
    isRetracted = true;
  }

  public void motorOnRectract(){
    collectorMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("RetractSpeed", -0.15));
  }


  // public void motorTimer(double secondsDeploy){

  //   if((updatingCollectorTime - Timer.getFPGATimestamp()) <= secondsDeploy && isRetracted){
  //     collectorMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("DeploySpeed", 0.15));
     

  //   }
  //   else{
  //     collectorMotor.set(ControlMode.PercentOutput, 0);
  //     isRetracted = false;
  //   }

  // }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
