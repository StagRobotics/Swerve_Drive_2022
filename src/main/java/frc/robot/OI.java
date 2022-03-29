package frc.robot;

import frc.robot.commands.CancelClimb;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.Grab;
import frc.robot.commands.Kicker;
import frc.robot.commands.MediumShooter;
import frc.robot.commands.ShortShooter;
import frc.robot.commands.ToggleIntake;
import frc.robot.commands.FastShooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {
    /*
       Add your joysticks and buttons here
     */
    public static Joystick primaryJoystick = new Joystick(0);
    public static Joystick secondaryJoystick = new Joystick(1);

    public OI() {
        // Back button zeroes the drivetrain
        new JoystickButton(primaryJoystick, 1).whenPressed(
            new ToggleIntake()
        );
        new JoystickButton(secondaryJoystick, 3).whenPressed(new ShortShooter());
        new JoystickButton(secondaryJoystick, 7).whenPressed(new FastShooter());
        new JoystickButton(secondaryJoystick, 8).whenPressed(new MediumShooter());
        new JoystickButton(primaryJoystick, 3).whenPressed(new Grab());
        new JoystickButton(secondaryJoystick, 4).whenPressed(new CancelClimb());
        new JoystickButton(secondaryJoystick, 5).whenPressed(new ClimbUp());
        new JoystickButton(secondaryJoystick, 6).whenPressed(new ClimbDown());
        new JoystickButton(secondaryJoystick, 1).whenPressed(new Kicker());
        
    }

    public Joystick getPrimaryJoystick() {
        return primaryJoystick;
    }
    public Joystick getSecondaryJoystick() {
            return secondaryJoystick;
        
    }
}