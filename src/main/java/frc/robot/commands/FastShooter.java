package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class FastShooter extends Command {
    public FastShooter(){
        requires(Shooter.getInstance());
    }
    @Override
    protected void initialize(){
        
    }

    @Override
    protected void execute(){
        //Robot.m_Shooter.toggleSpin();
        Robot.m_Shooter.FastWheel();
        
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
