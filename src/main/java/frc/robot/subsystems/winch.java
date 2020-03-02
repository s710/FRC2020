/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FX_Class;

public class winch extends SubsystemBase {
  /**
   * Creates a new winch.
   */
  private static boolean winchState;
  private static TalonFX winchMotor = new TalonFX(FX_Class.FX_WINCH_MOTOR_ID);

  public winch() {
    winchState = false;
  }

  public void toggleWinch() {
    if (winchState) {
      winchMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("Winch Speed", 0.8));
      winchState = false;
    }
    else{
      winchMotor.set(ControlMode.PercentOutput, 0);
      winchState = true;
    }
      
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
