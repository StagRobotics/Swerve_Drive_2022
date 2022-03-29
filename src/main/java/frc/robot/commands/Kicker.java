package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Clock;
import frc.robot.subsystems.Shooter;

public class Kicker extends CommandBase {
    public Kicker(){
        addRequirements(Shooter.getInstance(),Clock.getInstance());
    }
    
    @Override
    public void initialize(){
        Robot.m_Shooter.ToggleKicker();
        //Robot.m_clock.wait(0.5);
        //Robot.m_Shooter.ToggleKicker();
    }
    
    @Override
    public void execute(){
            

    }
    
    @Override
    public boolean isFinished(){
            return true;
    }
    
    @Override
    public void end(boolean interrupted){
    }
    
    
}
