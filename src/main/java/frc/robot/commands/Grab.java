package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class Grab extends CommandBase{
    public Grab(){
        addRequirements(Climber.getInstance());
    }
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        Robot.m_climber.ToggleGrab();
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted){
    }

    
}
