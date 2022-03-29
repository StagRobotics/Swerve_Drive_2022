package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Utilities;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.geometry.Translation2d;


public class Drive_Horizontal extends CommandBase{

    private double displacement = 0.0;
    private double forward = 0.0;
    private double rotation = 0.0;

    public Drive_Horizontal(double distance, String direction){
        
        addRequirements(DrivetrainSubsystem.getInstance());
        if(direction.equals("left")){
            displacement = -.30;
        }
        else if(direction.equals("right")){
            displacement = .30;
        }
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        double strafe = -displacement;
        strafe = Utilities.deadband(strafe);
        // Square the strafe stick
        strafe = Math.copySign(Math.pow(strafe, 2.0), strafe);

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
