package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Clock extends SubsystemBase {
    private static Clock instance;
    public Clock(){
        super();
        System.out.print("Time");
    }


    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
    
        return instance;
    }

    double waitTime = 0.0;
    static Timer timer = new Timer();
    public static boolean wait(double time){
        final double waitTime = time;
        timer.reset();
        timer.start();
        while(timer.get() < waitTime){
            System.out.print("Wait");
        }
        return true;
    }


}
