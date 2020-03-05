/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants.SRX_Class;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;


public class ballCollector extends SubsystemBase {
  /**
   * Creates a new ballCollector.
   */

  private static TalonSRX collectorMotor = new TalonSRX(Constants.SRX_Class.SRX_BALL_COLLECTOR_MOTOR_ID);
  private static TalonSRX motorCollectorNotDeployRetract = new TalonSRX(Constants.SRX_Class.SRX_COLLECTOR_NOT_DEPLPOY_RETRACT_ID);

  private boolean motorCollectorNotDeployRetractState;
  public boolean isRetracted;
  // private double timerThreshold;
  // private double whileLoopTime;
  // private double updatingCollectorTime;
  // private double starCollectorTime;
  // private double collectorTimeSnapshot;
  // private double deployUpdatingTime;



  public ballCollector() {

    motorCollectorNotDeployRetractState = false;
    isRetracted = true;
    motorCollectorNotDeployRetract.setInverted(true);


  }

  // public void collectorToggle(){
    
  //   if(motorCollectorNotDeployRetractState){
  //     motorCollectorNotDeployRetract.set(ControlMode.PercentOutput, SmartDashboard.getNumber("BallCollectorSpeedNotDeployRetract", 0.15));
  //     motorCollectorNotDeployRetractState = false;

  //   }
  //   else
  //   {
  //     motorCollectorNotDeployRetract.set(ControlMode.PercentOutput, 0);
  //     motorCollectorNotDeployRetractState = true;
  //   }
  // }

  public void motorKillDeploy(){
    collectorMotor.setNeutralMode(NeutralMode.Coast);

    motorCollectorNotDeployRetract.set(ControlMode.PercentOutput, SmartDashboard.getNumber("BallCollectorSpeedNotDeployRetract", 0.5));
    collectorMotor.set(ControlMode.PercentOutput, 0);
    isRetracted = false;
  }

  public void motorOnDeploy(){
    collectorMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("DeploySpeed", 0.15));
  }

  public void motorKillRetract(){
    collectorMotor.setNeutralMode(NeutralMode.Brake);
    collectorMotor.set(ControlMode.PercentOutput, 0);
    motorCollectorNotDeployRetract.set(ControlMode.PercentOutput, 0);
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
