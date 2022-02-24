package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Clock;
import frc.robot.subsystems.Shooter;

public class Kicker extends Command {
    public Kicker(){
        requires(Shooter.getInstance());
        requires(Clock.getInstance());
    }
    
    @Override
    protected void initialize(){
        
    }
    
    @Override
    protected void execute(){
            Robot.m_Shooter.ToggleKicker();
            Robot.m_clock.wait(1.0);
            Robot.m_Shooter.ToggleKicker();

    }
    
    @Override
    protected boolean isFinished(){
            return true;
    }
    
    @Override
    protected void end(){
    }
    
    @Override
    protected void interrupted(){
         
    }
}
