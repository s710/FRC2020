/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WinchHooker extends SubsystemBase {
  /**
   * Creates a new WinchHooker.
   */
  public boolean hookerBarState;
  public double hookerSpeed = SmartDashboard.getNumber("HookerSpeed", 0.1);

  private static TalonSRX winchHookerMotor = new TalonSRX(Constants.SRX_Class.SRX_WINCH_HOOKER_ID);
  public WinchHooker() {
    hookerBarState = false;

  }

  public void killHooker(){
    winchHookerMotor.set(ControlMode.PercentOutput, 0);
  }

  public void turnHookerToBar(){
    winchHookerMotor.set(ControlMode.PercentOutput, hookerSpeed);
  }
  
  public void turnHookerFromBar(){
    winchHookerMotor.set(ControlMode.PercentOutput, -hookerSpeed);
  
  }
  public void hookerFromBarComplete(){
    winchHookerMotor.set(ControlMode.PercentOutput, 0);
    hookerBarState = false;
  }
  public void hookerToBarComplete(){
    winchHookerMotor.set(ControlMode.PercentOutput, 0);
    hookerBarState = true;
  }




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
