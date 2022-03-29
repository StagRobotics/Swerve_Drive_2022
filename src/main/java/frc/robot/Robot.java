package frc.robot;

import frc.robot.commands.DriveCommand;
import frc.robot.commands.One_Auto;
import frc.robot.commands.Zero_Auto;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Clock;
import frc.robot.subsystems.DistanceSensor;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    SendableChooser<CommandBase> autoChooser = new SendableChooser<>();
    private static OI m_oi;
    public static Intake m_Intake;
    public static Shooter m_Shooter;
    public static DrivetrainSubsystem m_drivetrain;
    public static Climber m_climber;
    public static Clock m_clock;
    public static String AutoCommand = "";
    public static Command command;
    public static DistanceSensor m_sonar;
    public static UsbCamera camera1;
    

    @Override
    public void robotInit() {
        m_oi = new OI();
        m_drivetrain = DrivetrainSubsystem.getInstance();
        m_drivetrain.setDefaultCommand(new DriveCommand());
        m_Intake = Intake.getInstance();
        m_Shooter = Shooter.getInstance();
        m_climber = Climber.getInstance();
        m_clock = Clock.getInstance();
        m_sonar = DistanceSensor.getInstance();

        autoChooser.setDefaultOption("Low Auto", new Zero_Auto());
        autoChooser.addOption("High Auto", new One_Auto());

        SmartDashboard.putData("Chooser", autoChooser);
        camera1 = CameraServer.startAutomaticCapture(0);

        
    }
    public static OI getOi() {
        return m_oi;
    }
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
    @Override
    public void autonomousInit(){
        autoChooser.getSelected().schedule();
        /*
        AutoCommand = autoChooser.getSelected();
        switch(AutoCommand){
            default:
                System.out.print("Nothing");
                break;
            case "0":
                command = new Zero_Auto();
                break;
            case "1":
                command = new One_Auto();
                break;
            case "2":
                command = new Two_Auto();
                break;
        }
        command.start();
    */
        

    }
    public void teleopInit(){

    }
}