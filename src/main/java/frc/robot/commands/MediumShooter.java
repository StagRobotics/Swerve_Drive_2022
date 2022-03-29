package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class MediumShooter extends InstantCommand {
    public MediumShooter(){
        addRequirements(Shooter.getInstance());
    }
    @Override
    public void initialize(){
        Robot.m_Shooter.MediumWheel();
    }

    
    

    

    
}
