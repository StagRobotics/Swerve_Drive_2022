package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Utilities;

public class DriveCommand extends CommandBase {

    public DriveCommand() {
        addRequirements(DrivetrainSubsystem.getInstance());
    }

    @Override
    public void execute() {
        double forward = (-Robot.getOi().getPrimaryJoystick().getRawAxis(1)*.85);
        forward = Utilities.deadband(forward);
        // Square the forward stick
        forward = Math.copySign(Math.pow(forward, 3.0), forward);

        double strafe = (-Robot.getOi().getPrimaryJoystick().getRawAxis(0) * .85);
        strafe = Utilities.deadband(strafe);
        // Square the strafe stick
        strafe = Math.copySign(Math.pow(strafe, 3.0), strafe);

        double rotation = -Robot.getOi().getPrimaryJoystick().getRawAxis(4)* .85;
        rotation = Utilities.deadband(rotation);
        // Square the rotation stick
        rotation = Math.copySign(Math.pow(rotation, 3.0), rotation);

        DrivetrainSubsystem.getInstance().drive(new Translation2d(forward, strafe), rotation, true);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}