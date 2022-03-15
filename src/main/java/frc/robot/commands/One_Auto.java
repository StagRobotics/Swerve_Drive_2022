package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class One_Auto extends CommandGroup{
    public One_Auto(){
        addSequential(new ToggleIntake());
        addSequential(new Drive_Vertical(1.0, "forward"));
        addSequential(new wait(0.5));
        addSequential(new ToggleIntake());
        addSequential(new FastShooter());
        addSequential(new wait(1.0));
        addSequential(new Kicker());
        addSequential(new wait(1.0));
        addSequential(new Kicker());
        addSequential(new wait(0.5));
        addSequential(new FastShooter());
    }
}
