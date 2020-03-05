/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.NavigableMap;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.TestSystemForStuff;
import frc.robot.subsystems.WinchHooker;
import frc.robot.subsystems.ballCollector;
import frc.robot.subsystems.feeder;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.winch;
import frc.utilities.Navigation;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClrWeel;
import frc.robot.commands.CommandGroupAutonomousTest;
import frc.robot.commands.DriveWhileAutoMode1;
import frc.robot.commands.runBallCollector;
import frc.robot.commands.winchCmd;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.WinchHooker;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static shooter m_shooter;
  private RobotContainer m_robotContainer;
  public static DriveTrain m_driveTrain;
  public static CommandGroupAutonomousTest m_commandGroupAutonomousTest;
  public static Navigation m_navigation;
  public static feeder m_feeder;
  public static ClrWeel m_ClrWeel;
  public static DriveWhileAutoMode1 m_driveWhileAutoMode1;
  public static ballCollector m_ballCollector;
  public static winch m_winch;
  public static TestSystemForStuff m_testSystemForStuff;
  public static WinchHooker m_winchHooker;

  public double startGlobalTime;
  public double updatingGlobalTime;


  private NetworkTableInstance inst;
  private NetworkTable table;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  
  Command m_CommandGroupAu;
  SendableChooser<Command> chooser;



  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_shooter = new shooter();
    m_driveTrain = new DriveTrain();
    m_feeder = new feeder();
    m_navigation = new Navigation();
    m_ClrWeel = new ClrWeel();
    m_commandGroupAutonomousTest = new CommandGroupAutonomousTest();
    m_driveWhileAutoMode1 = new DriveWhileAutoMode1();
    m_ballCollector = new ballCollector();
    m_winch = new winch();
    m_testSystemForStuff = new TestSystemForStuff();
    m_winchHooker = new WinchHooker();


    startGlobalTime = Timer.getFPGATimestamp();

    SmartDashboard.putNumber("AutoMode1SecondsTime", 1);
    SmartDashboard.putNumber("AutoMode1Speed", 0.8);
    SmartDashboard.putNumber("TurnToAngleSpeed", 0.8);
    SmartDashboard.putNumber("ColorWheelMotorSpeed", 0.2);
    SmartDashboard.putBoolean("GreenTrue", false);
    SmartDashboard.putBoolean("YellowTrue", false);
    SmartDashboard.putBoolean("BlueTrue", false);
    SmartDashboard.putBoolean("RedTrue", false);  
    SmartDashboard.putNumber("BallCollectorSpeedNotDeployRetract", 0.5);
    SmartDashboard.putNumber("CollectorDeployTime", 1);
    SmartDashboard.putNumber("CollectorRetractTime", 1);
    SmartDashboard.putBoolean("isCollectorExtended", false);
    SmartDashboard.putNumber("DeploySpeed", 0.25);
    SmartDashboard.putNumber("RetractSpeed", -0.5);
    SmartDashboard.putNumber("Winch Speed", 0.8);
    SmartDashboard.putBoolean("HasThisTestForEnzoBeenReached?", false);
    SmartDashboard.putNumber("HookerSpeed", 0.1);
    SmartDashboard.putNumber("HookerToBarTime", 0.5);
    SmartDashboard.putNumber("HookerFromBarTime", 0.5);
    SmartDashboard.putNumber("Launcher_Motor_Speed", 1.0);

    
  

    chooser = new SendableChooser<Command>();

    chooser.setDefaultOption("SquareMode", m_commandGroupAutonomousTest);
    chooser.addOption("DriveOffTheLine", m_driveWhileAutoMode1);
    // chooser.setDefaultOption("SquareMode",m_commandGroupAutonomousTest);
    // chooser.addOption("DriveOffTheLine", m_driveWhileAutoMode1);
    // //chooser.addOption("TesterMode", m_testChooserAuto);

    SmartDashboard.putData("AutoModeSelect", chooser);

    // try{
    //   inst.getDefault();
    //   inst.getTable("limelight");
    //   //inst.getEntry("<variablename>");
    // }
    // catch(Exception exception){
    //   System.out.println(exception);
    // }


   //inst.setNumber(0);
  
    
    

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    SmartDashboard.putNumber("JoyStickLeftValue (Throttle)", m_robotContainer.joy.getThrottle());
    SmartDashboard.putNumber("JoyStickRightValue (Y-axis)", m_robotContainer.joy.getY());

    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    
    SmartDashboard.putNumber("Gyro Angle" , m_navigation.getAngle());

    //SmartDashboard.putNumber("Gyro Angle" , m_navigation.getAngle());

    updatingGlobalTime = Timer.getFPGATimestamp();
    
    CommandScheduler.getInstance().run();
    m_driveTrain.driveTank(m_robotContainer.joy);

  
  }


  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
  

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

    new CommandGroupAutonomousTest();

  }
  

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
          SmartDashboard.putBoolean("BlueTrue", true);
          SmartDashboard.putBoolean("YellowTrue", false);
          SmartDashboard.putBoolean("GreenTrue", false);
          SmartDashboard.putBoolean("RedTrue", false);
          break;
        case 'G' :
          SmartDashboard.putBoolean("BlueTrue", false);
          SmartDashboard.putBoolean("YellowTrue", false);
          SmartDashboard.putBoolean("GreenTrue", true);
          SmartDashboard.putBoolean("RedTrue", false);
          break;
        case 'R' :
          SmartDashboard.putBoolean("BlueTrue", false);
          SmartDashboard.putBoolean("YellowTrue", false);
          SmartDashboard.putBoolean("GreenTrue", false);
          SmartDashboard.putBoolean("RedTrue", true);
          break;
        case 'Y' :
          SmartDashboard.putBoolean("BlueTrue", false);
          SmartDashboard.putBoolean("YellowTrue", true);
          SmartDashboard.putBoolean("GreenTrue", false);
          SmartDashboard.putBoolean("RedTrue", false);
        default :
      
          break;
      }
    } else {
      //Code for no data received yet
    }

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
