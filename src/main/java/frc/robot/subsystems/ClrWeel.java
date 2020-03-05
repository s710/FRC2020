/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SRX_Class;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClrWeel extends SubsystemBase {

private static TalonSRX clrWheelMotor = new TalonSRX(SRX_Class.SRX_CLR_WHEEL_MOTOR_ID);

  /**
   * Creates a new ColoWeel.
   */
  public ClrWeel() {

  }
//IF THIS BREAKS, FIX IS PROBABLY TO MOVE THE SMARTDASHBOARD CALL INTO THE SETMOTOR SPEED THING BELOW -Predicted by Sherwin Fernandes 2/26/2020 @4:28PM - REPLY - Your thing was broken but not because of your predicted error. You can't just set the speed and expect the motor to toggle when you give it two of the same input. I did do what you said might be an error because it was verbose to create the variable and then move it in, but in no way, shape, or form would that cause an error. Just verbosity. -Written by Lorenzo Saracen 3/3/2020 @6:23PM
  public void triggerWhenHeldSpin() {
      clrWheelMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("ColorWheelMotorSpeed", 0.2));
  }
  
  public void killClrWheel(){
    clrWheelMotor.set(ControlMode.PercentOutput, 0);
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
