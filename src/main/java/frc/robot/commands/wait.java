package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class wait extends CommandBase {
    double waitTime = 0.0;
    Timer timer = new Timer();
    public wait(double time){
        addRequirements(DrivetrainSubsystem.getInstance());
        waitTime = time;
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){

    }

    @Override
    public boolean isFinished(){
        return timer.get() >= waitTime;
    }

    @Override
    public void end(boolean interrupted){
    }

    
}
