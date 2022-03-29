package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends CommandBase {
    double ball = 0.4;

    public ToggleIntake(){
        addRequirements(Intake.getInstance());
    }
    
    @Override
    public void initialize(){
        
    }
    
    @Override
    public void execute(){
            Robot.m_Intake.toggleIntake(ball);
            Robot.m_Intake.ToggleExtend();
    }
    
    @Override
    public boolean isFinished(){
            return true;
    }
    
    @Override
    public void end(boolean interrupted){
    }
    
    
}
