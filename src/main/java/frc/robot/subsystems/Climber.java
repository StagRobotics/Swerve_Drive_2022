package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.RobotMap;

public class Climber extends Subsystem {
    private PWMVictorSPX leftClimb = new PWMVictorSPX(RobotMap.climber1);
    private PWMVictorSPX rightClimb = new PWMVictorSPX(RobotMap.climber2);
    ///private DigitalInput limiter = new DigitalInput(RobotMap.climbLimit);
    private DoubleSolenoid grabber = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.grabber1, RobotMap.grabber2);

    private double motorSpeed = 1.0;
    private boolean grab = false;
    private static Climber instance;

    public Climber(){

    }

    @Override
    public void initDefaultCommand(){

    }

    public static Climber getInstance() {
        if (instance == null) {
            instance = new Climber();
        }
    
        return instance;
    }

    public void ClimbUp(){
        leftClimb.set(motorSpeed);
        rightClimb.set(motorSpeed);
        System.out.print("Climb Up");
    }
    public void ClimbDown(){
        //if (limiter.get() == true){
            leftClimb.set(-motorSpeed);
            rightClimb.set(-motorSpeed);
            System.out.print("Climb Down");
        //}
    }
    public void CancelClimb(){
        leftClimb.set(0.0);
        rightClimb.set(0.0);
    }
    public void ToggleGrab(){
        if(grab == false){
            grabber.set(DoubleSolenoid.Value.kForward);
            grab = true;
        }else if(grab = true){
            grabber.set(DoubleSolenoid.Value.kReverse);
            grab = false;
        }
    }
}

