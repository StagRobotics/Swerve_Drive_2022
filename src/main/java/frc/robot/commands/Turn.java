package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class Turn extends CommandBase {
    
    private double turn = 0.0;
    private double up = 0.0;
    private double side = 0.0;

    public Turn(double angle){

        addRequirements(DrivetrainSubsystem.getInstance());
        turn = angle;
    }
    
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){

        DrivetrainSubsystem.getInstance().drive(new Translation2d(up,side), turn, true);

    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean iterrupted){
    }

   
}

