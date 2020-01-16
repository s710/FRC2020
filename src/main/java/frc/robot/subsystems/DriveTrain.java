package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.SRX_Class;

public class DriveTrain extends SubsystemBase {
  
  private static TalonSRX frontRightMotor = new TalonSRX(SRX_Class.SRX_FRONT_RIGHT_MOTOR_ID);
  private static TalonSRX frontLeftMotor = new TalonSRX(SRX_Class.SRX_FRONT_LEFT_MOTOR_ID);
  private static TalonSRX midRightMotor = new TalonSRX(SRX_Class.SRX_MID_RIGHT_MOTOR_ID);
  private static TalonSRX midLeftMotor = new TalonSRX(SRX_Class.SRX_MID_LEFT_MOTOR_ID);
  private static TalonSRX backRightMotor = new TalonSRX(SRX_Class.SRX_BACK_RIGHT_MOTOR_ID);
  private static TalonSRX backLeftMotor = new TalonSRX(SRX_Class.SRX_BACK_LEFT_MOTOR_ID);


  public DriveTrain() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
} 