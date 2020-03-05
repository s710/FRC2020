/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TestSystemForStuff extends SubsystemBase {
  /**
   * Creates a new TestSystemForStuff.
   */
  public TestSystemForStuff() {

  }

  public void functionForPrintingTestDataToDashboard(){
    SmartDashboard.putBoolean("HasThisTestForEnzoBeenReached?", true);
    System.out.println("Test worked in console :)");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
