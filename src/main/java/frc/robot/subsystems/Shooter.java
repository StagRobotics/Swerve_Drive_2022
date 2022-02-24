package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.RobotMap;

public class Shooter extends Subsystem {
    private PWMVictorSPX smbs = new PWMVictorSPX(RobotMap.backspinMotor);
    private PWMVictorSPX sms = new PWMVictorSPX(RobotMap.shooterMotor);
    private DoubleSolenoid kicker = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.kicker1, RobotMap.kicker2);
    


    private boolean Shoot = false;
    private boolean kick = false;
    private boolean Spin = false;
    private double SMSpeed = 0.5;
    private double BSSpeed = 0.5;
    private static Shooter instance;

    public Shooter(){
        super();
        System.out.print("Shoot");
    }

    @Override
    public void initDefaultCommand(){
        //Set the default command for a subsystem here. 
        // setDefaultCommand(new MySpecialCommand());
    }

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
    
        return instance;
    }

    public void toggleWheel(){
            System.out.println(Shoot);

            if (Shoot){
                SMOn();
                Shoot = false;
                System.out.println("n/Shoot = " + Shoot);
            }else{
                SMOff();
                Shoot = true;
                System.out.println("n/Shoot = " + Shoot);
            }
    }

    public void toggleSpin(){
        if(Spin){
            BSOn();
            Spin = false;
            System.out.print("n/Spin = " + Spin);
        }else{
            BSOff();
            Spin = true;
            System.out.print("n/Spin =" +Spin);
        }
    }

    public void BSOn(){
        smbs.set(-BSSpeed);
    }

    public void BSOff(){
        smbs.set(0.0);
    }

    public void SMOn(){
        sms.set(SMSpeed);
    }

    public void SMOff(){
        sms.set(0.0);
    }
    public void ToggleKicker(){

        //kicker.set(DoubleSolenoid.Value.kForward);
        //kicker.set(DoubleSolenoid.Value.kReverse);
      
       if(kick == false){
            kicker.set(DoubleSolenoid.Value.kForward);
            kick = true;
            System.out.print(kick);
        }else if (kick == true){
            kicker.set(DoubleSolenoid.Value.kReverse);
              kick = false;
            System.out.print(kick);
        }
    }
}
