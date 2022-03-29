package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DistanceSensor;

public class One_Auto extends SequentialCommandGroup{
    public One_Auto(){
        addCommands(
            new MediumShooter(),
            new WaitCommand(2.0),
            new Kicker(),
            new WaitCommand(1.0),
            new FastShooter()
            //while(DistanceSensor.getDistance() < 84){
                //new Drive_Vertical(1.0, "backward"),
            //}
        );
    }

}
