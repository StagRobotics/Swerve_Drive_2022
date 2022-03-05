package frc.robot;

import frc.robot.commands.One_Auto;
import frc.robot.commands.Two_Auto;
import frc.robot.commands.Zero_Auto;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Clock;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    SendableChooser<String> autoChooser = new SendableChooser<>();
    private static OI m_oi;
    public static Intake m_Intake;
    public static Shooter m_Shooter;
    public static DrivetrainSubsystem m_drivetrain;
    public static Climber m_climber;
    public static Clock m_clock;
    public static String AutoCommand = "";
    public static Command command;
    

    @Override
    public void robotInit() {
        m_oi = new OI();
        m_drivetrain = DrivetrainSubsystem.getInstance();
        m_Intake = Intake.getInstance();
        m_Shooter = Shooter.getInstance();
        m_climber = Climber.getInstance();
        m_clock = Clock.getInstance();

        autoChooser.setDefaultOption("Do Nothing", "N");
        autoChooser.addOption("0 Ball Auto", "0");
        autoChooser.addOption("1 Ball Auto", "1");
        autoChooser.addOption("2 Ball Auto", "2");

        SmartDashboard.putData("Chooser", autoChooser);
    }
    public static OI getOi() {
        return m_oi;
    }
    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }
    @Override
    public void autonomousInit(){
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

    }
    public void teleopInit(){

    }
}