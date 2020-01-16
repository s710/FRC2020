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

  
/*  When i initially added the phoenix vendor library no errors were 
 *  showing, but once i commited and pushed, the errors went back.
 *  This might have something to do with me fetching the library from
 *  online, but I really don't understand why this is happening.
 */
  
 public DriveTrain() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
} 