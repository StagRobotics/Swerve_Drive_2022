package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DistanceSensor;

public class Zero_Auto extends SequentialCommandGroup {
    public Zero_Auto(){
        
        addCommands(
            new Drive_Vertical(1.0, "backward"),
            //}
            new WaitCommand(1.0),            
            new Brake(),
            new Drive_Vertical(1.0, "forward"),
            //}
            new WaitCommand(0.50),            
            new Brake(),
            new WaitCommand(1.0),
            new MediumShooter(),
            new WaitCommand(3.0),
            new Kicker(),
            new WaitCommand(0.5),
            new Kicker(),
            new WaitCommand(1.0),
            new MediumShooter(),
            //while(DistanceSensor.getDistance() < 84){
            new Drive_Vertical(1.0, "backward"),
            //}
            new WaitCommand(1.25),            
            new Brake()

        );
        
    
    }

}
