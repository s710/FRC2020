/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.utilities;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Navigation extends SubsystemBase {
  /**
   * Creates a new Navigation.
   */
  private AHRS gyro;
  public Navigation() {
    super();
    try {
      /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
      /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
      /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
      gyro = new AHRS(SerialPort.Port.kUSB1);
      gyro.reset();
    } catch (RuntimeException ex ) {
      System.out.print("Failed Gyro. You dun goofed.");
    }

  }

  public void resetGyro() {
    gyro.reset();
  }
  public double getAngle(){
    return gyro.getAngle();
  }

  public double getPitch(){
    return gyro.getPitch();  //Pitch is angle about the x-axis, i.e. how much tilt forward or backward
  }

  public double getRoll() {
    return gyro.getRoll();   //Roll is angle about the y-axis, i.e. how much tilt left or right, like it is rolling side to side
  }

  public double getUpAccel() {
    return gyro.getRawAccelZ();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
