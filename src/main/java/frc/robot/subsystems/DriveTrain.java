
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.FX_Class;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends SubsystemBase {


  private static WPI_TalonFX frontRightMotor = new WPI_TalonFX(FX_Class.FX_FRONT_RIGHT_MOTOR_ID);
  //private static WPI_TalonFX midRightMotor = new WPI_TalonFX(FX_Class.FX_MID_RIGHT_MOTOR_ID);
  private static WPI_TalonFX backRightMotor = new WPI_TalonFX(FX_Class.FX_BACK_RIGHT_MOTOR_ID);
  
  private static WPI_TalonFX frontLeftMotor = new WPI_TalonFX(FX_Class.FX_FRONT_LEFT_MOTOR_ID);
  private static WPI_TalonFX backLeftMotor = new WPI_TalonFX(FX_Class.FX_BACK_LEFT_MOTOR_ID);
  //private static WPI_TalonFX midLeftMotor = new WPI_TalonFX(FX_Class.FX_MID_LEFT_MOTOR_ID);
  
  private static SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRightMotor, backRightMotor);
  private static SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
  private static DifferentialDrive differentialDriveTrain = new DifferentialDrive(leftMotors, rightMotors);

 public DriveTrain() {

  //midLeftMotor.follow(frontLeftMotor, FollowerType.PercentOutput);
  //backLeftMotor.follow(frontLeftMotor, FollowerType.PercentOutput);
  
  //midRightMotor.follow(frontRightMotor, FollowerType.PercentOutput);
  //backRightMotor.follow(frontRightMotor, FollowerType.PercentOutput);

}


public void autoMode1MotorSet(double speedMode1){
  rightMotors.set(speedMode1);
  leftMotors.set(-speedMode1);
}

public void turnToAngle(double turningSpeed){
  rightMotors.set(turningSpeed);
  leftMotors.set(turningSpeed);
}

public void testFunction(){
  System.out.println("test worked");
}




public void motorTelemetryLog(){
  System.out.println("___________________DRIVE TRAIN___________________");
  System.out.println("SensorVelocityLeftMotors:  " + frontLeftMotor.getSelectedSensorVelocity(0));
  System.out.println("SensorPositionLeftMotors:  " + frontLeftMotor.getSelectedSensorPosition(0));
  System.out.println("SensorVelocityRightMotors:  " + frontRightMotor.getSelectedSensorVelocity(0));
  System.out.println("SensorPositionRightMotors:  " + frontRightMotor.getSelectedSensorPosition(0));
  System.out.println("_________________________________________________");

  SmartDashboard.putNumber("SensorVelocityLeftMotor", frontLeftMotor.getSelectedSensorVelocity(0));
  SmartDashboard.putNumber("SensorPositionLeftMotors", frontLeftMotor.getSelectedSensorPosition(0));
  SmartDashboard.putNumber("SensorVelocityRightMotors", frontRightMotor.getSelectedSensorVelocity(0));
  SmartDashboard.putNumber("SensorPositionRightMotors", frontRightMotor.getSelectedSensorPosition(0));
}


  public void driveTank(Joystick joy){
    // This is the thing that is printing out all of the stuff
    //System.out.println(joy.getY() + " " + joy.getThrottle());
    differentialDriveTrain.tankDrive(-joy.getY(), -joy.getThrottle());
  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //get controlle
  }
}
