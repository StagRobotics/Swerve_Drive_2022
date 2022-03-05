package frc.robot;

import frc.robot.commands.CancelClimb;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.Grab;
import frc.robot.commands.Kicker;
import frc.robot.commands.One_Auto;
import frc.robot.commands.ToggleIntake;
import frc.robot.commands.ToggleShooter;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class OI {
    /*
       Add your joysticks and buttons here
     */
    private Joystick primaryJoystick = new Joystick(0);
    private Joystick secondaryJoystick = new Joystick(1);

    public OI() {
        // Back button zeroes the drivetrain
        new JoystickButton(primaryJoystick, 7).whenPressed(
                new InstantCommand(() -> DrivetrainSubsystem.getInstance().resetGyroscope())
        );
        new JoystickButton(primaryJoystick, 1).whenPressed(
            new ToggleIntake()
        );
        new JoystickButton(secondaryJoystick, 3).whenPressed(new ToggleShooter());
        new JoystickButton(secondaryJoystick, 2).whenPressed(new Grab());
        new JoystickButton(secondaryJoystick, 4).whenPressed(new CancelClimb());
        new JoystickButton(secondaryJoystick, 5).whenPressed(new ClimbUp());
        new JoystickButton(secondaryJoystick, 6).whenPressed(new ClimbDown());
        new JoystickButton(secondaryJoystick, 1).whenPressed(new Kicker());
        new JoystickButton(primaryJoystick, 4).whenPressed(new One_Auto());
    }

    public Joystick getPrimaryJoystick() {
        return primaryJoystick;
    }
    public Joystick getSecondaryJoystick() {
            return secondaryJoystick;
        
    }
}