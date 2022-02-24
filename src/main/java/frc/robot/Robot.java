package frc.robot;

import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Clock;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
    private static OI m_oi;
    public static Intake m_Intake;
    public static Shooter m_Shooter;
    public static DrivetrainSubsystem m_drivetrain;
    public static Climber m_climber;
    public static Clock m_clock;
    

    @Override
    public void robotInit() {
        m_oi = new OI();
        m_drivetrain = DrivetrainSubsystem.getInstance();
        m_Intake = Intake.getInstance();
        m_Shooter = Shooter.getInstance();
        m_climber = Climber.getInstance();
        m_clock = Clock.getInstance();
    }
    public static OI getOi() {
        return m_oi;
    }
    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }
}