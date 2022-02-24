package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class CancelClimb extends Command {
    public CancelClimb(){
        requires(Climber.getInstance());
    }
    @Override
    protected void initialize(){
        
    }

    @Override
    protected void execute(){
        Robot.m_climber.CancelClimb();
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
