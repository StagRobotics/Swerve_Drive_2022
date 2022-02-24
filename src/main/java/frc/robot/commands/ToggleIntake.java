package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends Command {
    double ball = 0.4;

    public ToggleIntake(){
        requires(Intake.getInstance());
    }
    
    @Override
    protected void initialize(){
        
    }
    
    @Override
    protected void execute(){
            Robot.m_Intake.toggleIntake(ball);
            Robot.m_Intake.ToggleExtend();
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
