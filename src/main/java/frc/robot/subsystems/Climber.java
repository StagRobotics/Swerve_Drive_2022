package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.CancelClimb;

public class Climber extends SubsystemBase {
    private PWMVictorSPX leftClimb = new PWMVictorSPX(RobotMap.climber1);
    private PWMVictorSPX rightClimb = new PWMVictorSPX(RobotMap.climber2);
    private DigitalInput Rlimiter = new DigitalInput(0);
    private DigitalInput Llimiter = new DigitalInput(1);
    private DoubleSolenoid grabber = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.grabber1, RobotMap.grabber2);

    private double motorSpeed = 1.0;
    private boolean grab = true;
    private static Climber instance;

    public Climber(){

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
        leftClimb.set(-motorSpeed);
        rightClimb.set(-motorSpeed);
        System.out.print("Climb down");
        /*
        while(1 == 1 && !(OI.secondaryJoystick.getRawButtonPressed(4))){
            if(Llimiter.get() == false || Rlimiter.get() == false){
                CancelClimb();
                break;
            }
        }
        */                                
    }
    public void CancelClimb(){
        leftClimb.set(0.0);
        rightClimb.set(0.0);
    }
    public void ToggleGrab(){
        if(grab == false){
            grabber.set(DoubleSolenoid.Value.kForward);
            grab = true;
            System.out.print(" grab on");
        }else if(grab = true){
            grabber.set(DoubleSolenoid.Value.kReverse);
            grab = false;
            System.out.print("grab off");
        }
    }
}

