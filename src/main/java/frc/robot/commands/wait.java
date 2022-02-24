package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class wait extends Command {
    double waitTime = 0.0;
    Timer timer = new Timer();
    public wait(double time){
        requires(DrivetrainSubsystem.getInstance());
        waitTime = time;
    }

    @Override
    protected void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    protected void execute(){

    }

    @Override
    protected boolean isFinished(){
        return timer.get() >= waitTime;
    }

    @Override
    protected void end(){
    }

    @Override
    protected void interrupted(){
    }
}
