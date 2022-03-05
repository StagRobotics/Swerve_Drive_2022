package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Zero_Auto extends CommandGroup {
    public Zero_Auto(){
        
        addSequential(new ToggleShooter());
        addSequential(new wait(2.0));
        addSequential(new Kicker());
        addSequential(new wait(1.0));
        addSequential(new ToggleShooter());
        addSequential(new Drive_Vertical(1.0, "backward"));
        addSequential(new wait(2.0));
    }

}
