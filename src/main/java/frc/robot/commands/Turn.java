package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class Turn extends Command {
    
    private double turn = 0.0;
    private double up = 0.0;
    private double side = 0.0;

    public Turn(double angle){

        requires(DrivetrainSubsystem.getInstance());
        turn = angle;
    }
    
    @Override
    protected void initialize(){
        
    }

    @Override
    protected void execute(){

        DrivetrainSubsystem.getInstance().drive(new Translation2d(up,side), turn, true);

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

