/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.motorFeederintoShooter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static frc.robot.Constants.SRX_Class;

public class feeder extends SubsystemBase {
  /**
   * Creates a new feeder.
   */

  private static VictorSPX feederBeltMotor = new VictorSPX(SRX_Class.SRX_BELT_MOTOR_ID);
  private static VictorSPX motorFeederIntoShooterMotor = new VictorSPX(SRX_Class.SRX_MOTOR_FEEDER_INTO_SHOOTER_MOTOR_ID);

  private boolean motorFeederintoShooterState;
  private boolean beltState;

  public double getMotorFeederIntoShooterSpeed() {
    return SmartDashboard.getNumber("Motor_Feeder_Into_Shooter_Speed_Value", 0.25);
 }

 public double getBeltSpeed() {
  return SmartDashboard.getNumber("Belt_Speed_Value", 0.25);
}
  
  public feeder() {
    
    motorFeederintoShooterState = false;
    beltState = false;
    SmartDashboard.putNumber("Motor_Feeder_Into_Shooter_Speed_Value", 1.0);
    SmartDashboard.putNumber("Belt_Speed_Value", 1.0);

  }
  public void beltToggle(){
    if(beltState){
      beltState = false;
      feederBeltMotor.set(ControlMode.PercentOutput, getBeltSpeed());
      System.out.println("is correctly getting speed for belt");

    }
    else{
      beltState = true;
      System.out.println("is correctly toggling off for belt");

    }
  }

  public void motorFeederintoShooterToggle(){
    if(motorFeederintoShooterState){
      motorFeederintoShooterState = false;
      System.out.println("got to the speed for motorFeederIntoShooterToggle");
      motorFeederIntoShooterMotor.set(ControlMode.PercentOutput, getMotorFeederIntoShooterSpeed());
    }
    else{
    motorFeederintoShooterState = true;
    System.out.println("is correctly toggling off for motorFeederIntoShooterToggle");
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
