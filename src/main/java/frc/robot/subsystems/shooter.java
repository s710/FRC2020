/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.RobotContainer;
import frc.robot.subsystems.shooter;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import frc.robot.Constants.FX_Class;


public class shooter extends SubsystemBase {
  /**
   * Creates a new launcher.
   */
  private boolean currentState;
  private boolean inverseState;

  private static TalonFX shooterLeftMotor = new TalonFX(FX_Class.FX_SHOOTER_RIGHT_MOTOR_ID);
  private static TalonFX shooterRightMotor = new TalonFX(FX_Class.FX_SHOOTER_LEFT_MOTOR_ID);

 public double getLauncherSpeed() {
    return SmartDashboard.getNumber("Launcher_Motor_Speed", 0.25);
 }
  
  public shooter() {

    currentState = false;
    inverseState = false;

    shooterLeftMotor.setInverted(true);
      shooterRightMotor.setInverted(false);

    SmartDashboard.putNumber("Launcher_Motor_Speed", 1.0);



  }

  public void toggle() {

    if (currentState){
      currentState = false;
    
      shooterLeftMotor.set(TalonFXControlMode.PercentOutput, 0);
      shooterRightMotor.set(TalonFXControlMode.PercentOutput, 0);

    }
    else{
      currentState = true;
      shooterLeftMotor.set(TalonFXControlMode.PercentOutput, getLauncherSpeed());
      shooterRightMotor.set(TalonFXControlMode.PercentOutput, getLauncherSpeed());
    }

  }

  public void inverseToggle() {
    if(inverseState) {
      shooterLeftMotor.setInverted(true);
      shooterRightMotor.setInverted(false);
      inverseState = false;
    }
  
    else {
      shooterLeftMotor.setInverted(false);
      shooterRightMotor.setInverted(true);
      inverseState = true;
    }
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
