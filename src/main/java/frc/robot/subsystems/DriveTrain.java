
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
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class DriveTrain extends SubsystemBase {
  
  private static WPI_TalonFX frontRightMotor = new WPI_TalonFX(FX_Class.FX_FRONT_RIGHT_MOTOR_ID);
  private static WPI_TalonFX midRightMotor = new WPI_TalonFX(FX_Class.FX_MID_RIGHT_MOTOR_ID);
  private static WPI_TalonFX backRightMotor = new WPI_TalonFX(FX_Class.FX_BACK_RIGHT_MOTOR_ID);
  
  private static WPI_TalonFX frontLeftMotor = new WPI_TalonFX(FX_Class.FX_FRONT_LEFT_MOTOR_ID);
  private static WPI_TalonFX backLeftMotor = new WPI_TalonFX(FX_Class.FX_BACK_LEFT_MOTOR_ID);
  private static WPI_TalonFX midLeftMotor = new WPI_TalonFX(FX_Class.FX_MID_LEFT_MOTOR_ID);

 private static SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeftMotor, midLeftMotor, backLeftMotor);
 private static SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRightMotor, midRightMotor, backRightMotor);





  
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
