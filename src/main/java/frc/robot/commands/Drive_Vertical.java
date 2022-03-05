package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Utilities;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.geometry.Translation2d;

public class Drive_Vertical extends Command {

    private double displacement;
    private double strafe = 0.0;
    private double rotation = 0.0;

    public Drive_Vertical(double distance, String direction){

        requires(DrivetrainSubsystem.getInstance());
        if(direction.equals("forward")){
            displacement = -.50;
        }
        else if(direction.equals("backward")){
            displacement = .50;
        }
    }
    
    @Override
    protected void initialize(){
        
    }

    @Override
    protected void execute(){
        double forward = -displacement;
        forward = Utilities.deadband(forward);
        // Square the forward stick
        forward = Math.copySign(Math.pow(forward, 2.0), forward);

        DrivetrainSubsystem.getInstance().drive(new Translation2d(forward, strafe), rotation, true);

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
