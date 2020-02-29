/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SRX_Class;
import edu.wpi.first.wpilibj.Joystick;

import java.security.cert.CRL;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClrWeel extends SubsystemBase {

private static VictorSPX clrWheelMotor = new VictorSPX(SRX_Class.SRX_CLR_WHEEL_MOTOR_ID);
private boolean currentState;
private double wheelMotorSpeed; 

  /**
   * Creates a new ColoWeel.
   */
  public ClrWeel() {
     wheelMotorSpeed = SmartDashboard.getNumber("Color Wheel Motor Speed", 0.3);
     
  }
//IF THIS BREAKS, FIX IS PROBABLY TO MOVE THE SMARTDASHBOARD CALL INTO THE SETMOTOR SPEED THING BELOW -Predicted by Sherwin Fernandes 2/26/2020 @4:28PM
  public void triggerWhenHeldSpin() {

    clrWheelMotor.set(ControlMode.PercentOutput, wheelMotorSpeed);

  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
