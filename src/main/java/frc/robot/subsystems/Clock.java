package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Clock extends Subsystem {
    private static Clock instance;
    public Clock(){
        super();
        System.out.print("Time");
    }

    @Override
    public void initDefaultCommand(){
        //Set the default command for a subsystem here. 
        // setDefaultCommand(new MySpecialCommand());
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
