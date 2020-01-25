
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.FX_Class;

public class DriveTrain extends SubsystemBase {
  
  private static TalonFX frontRightMotor = new TalonFX(FX_Class.FX_FRONT_RIGHT_MOTOR_ID);
  private static TalonFX frontLeftMotor = new TalonFX(FX_Class.FX_FRONT_LEFT_MOTOR_ID);
  private static TalonFX midRightMotor = new TalonFX(FX_Class.FX_MID_RIGHT_MOTOR_ID);
  private static TalonFX midLeftMotor = new TalonFX(FX_Class.FX_MID_LEFT_MOTOR_ID);
  private static TalonFX backRightMotor = new TalonFX(FX_Class.FX_BACK_RIGHT_MOTOR_ID);
  private static TalonFX backLeftMotor = new TalonFX(FX_Class.FX_BACK_LEFT_MOTOR_ID);
  
 



  
/*  When i initially added the phoenix vendor library no errors were 
 *  showing, but once i commited and pushed, the errors went back.
 *  This might have something to do with me fetching the library from
 *  online, but I really don't understand why this is happening.
 * 
 * EDIT: They are working now again and I am confused.
 */

 public DriveTrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
} 
