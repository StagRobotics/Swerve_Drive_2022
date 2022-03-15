package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.CancelClimb;

public class Climber extends Subsystem {
    private PWMVictorSPX leftClimb = new PWMVictorSPX(RobotMap.climber1);
    private PWMVictorSPX rightClimb = new PWMVictorSPX(RobotMap.climber2);
    private DigitalInput Rlimiter = new DigitalInput(0);
    private DigitalInput Llimiter = new DigitalInput(1);
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
        Clock.wait(0.5);
        System.out.print("Climb Up");
        while(1 == 1 && !(OI.secondaryJoystick.getRawButtonPressed(4))){
            
            if(Llimiter.get() == false || Rlimiter.get() == false){
                CancelClimb();
                break;
            }
        }
        
    }
    public void ClimbDown(){
        leftClimb.set(-motorSpeed);
        rightClimb.set(-motorSpeed);
        Clock.wait(0.3);
        System.out.print("Climb down");
        while(1 == 1 && !(OI.secondaryJoystick.getRawButtonPressed(4))){
            
            if(Llimiter.get() == false || Rlimiter.get() == false){
                CancelClimb();
                break;
            }
        }
        
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

