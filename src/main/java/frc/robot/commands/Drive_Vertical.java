package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Utilities;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.geometry.Translation2d;

public class Drive_Vertical extends CommandBase {

    private double displacement;
    private double strafe = 0.0;
    private double rotation = 0.0;

    public Drive_Vertical(double distance, String direction){

        addRequirements(DrivetrainSubsystem.getInstance());
        if(direction.equals("forward")){
            displacement = -.50;
        }
        else if(direction.equals("backward")){
            displacement = .50;
        }
    }
    
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        double forward = -displacement;
        forward = Utilities.deadband(forward);
        // Square the forward stick
        forward = Math.copySign(Math.pow(forward, 2.0), forward);

        DrivetrainSubsystem.getInstance().drive(new Translation2d(forward, strafe), rotation, true);

    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted){
    }

    
}
