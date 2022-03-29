package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class ShortShooter extends CommandBase {
    
    public ShortShooter(){
        addRequirements(Shooter.getInstance());
    }
    @Override
    public void initialize(){
        Robot.m_Shooter.ShortWheel();
    }

    @Override
    public void execute(){
        //Robot.m_Shooter.toggleSpin();
        
        
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted){
    }

    
}
