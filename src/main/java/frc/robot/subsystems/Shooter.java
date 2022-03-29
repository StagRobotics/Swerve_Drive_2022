package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
    private PWMVictorSPX smbs = new PWMVictorSPX(RobotMap.backspinMotor);
    private PWMVictorSPX sms = new PWMVictorSPX(RobotMap.shooterMotor);
    private DoubleSolenoid kicker = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.kicker1, RobotMap.kicker2);
    private Encoder frontEncoder = new Encoder(6,7, false, Encoder.EncodingType.k4X);
    private Encoder backEncoder = new Encoder(4,5, false, Encoder.EncodingType.k4X);



    private boolean Shoot = true;
    private boolean kick = false;
    private boolean Spin = true;
    private double FastSpeed = .6;
    private double MediumSpeed = .65;
    private double ShortSpeed = 0.42;
    private double BSSpeed = 0.4;
    double Fdiameter = 6/12; // 6 inch wheels
	double Fdist =0.5*3.14/1024;  // ft per pulse
    double Bdiameter = 4/12;
    double Bdist = 0.33*3.14/1024;
    private static Shooter instance;

    public Shooter(){
        super();
        System.out.print("Shoot");
        frontEncoder.setDistancePerPulse(Fdist);
        backEncoder.setDistancePerPulse(Bdist);
    }

    

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
    
        return instance;
    }

    public double getFRPS(){
        return frontEncoder.getRate();
    }

    public double getBRPS(){
        return backEncoder.getRate();
    }
    /*
    public void FastWheel(){
            if (Shoot){
                sms.set(FastSpeed);
                while((getFRPS()*(-1) )< 310.0 && FastSpeed <= .85){
                    FastSpeed = FastSpeed + 0.01;
                    sms.set(FastSpeed);
                    Clock.wait(0.5);
                    
                }
                Shoot = false;
                
            }else{
                sms.set(0.0);
                Shoot = true;
                
            }
    }
    */
    public void MediumWheel(){
        if (Shoot){
            sms.set(MediumSpeed);
            //while((getFRPS()*(-1)) < 220.0&& MediumSpeed <= .85){
                //MediumSpeed = MediumSpeed + 0.01;
                //sms.set(MediumSpeed);
                //Clock.wait(0.1);
                
            //}
            Shoot = false;
            
        }else{
            sms.set(0.0);
            Shoot = true;
            
        }
    }
    public void ShortWheel(){
        if (Shoot){
            sms.set(ShortSpeed);
            //while((getFRPS()*(-1)) < 155.0 && ShortSpeed <= .85){
                //ShortSpeed = ShortSpeed + 0.01;
                //sms.set(ShortSpeed);
                //Clock.wait(0.05);
            //}
            Shoot = false;
        }else{
            sms.set(0.0);
            Shoot = true;
            
        }
    }

    public void toggleSpin(){
        if(Spin){
            smbs.set(BSSpeed);
            while(getBRPS() < 90.0 && OI.secondaryJoystick.getRawButtonPressed(4)){
                BSSpeed = BSSpeed + 0.01;
                smbs.set(BSSpeed);
                Clock.wait(0.05);

            }
            Spin = false;
        }else{
            smbs.set(0.0);
            Spin = true;
        }
    }

    
    public void ToggleKicker(){
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
    
    public void periodic() {
        SmartDashboard.putNumber("Front RPS", getFRPS());
        SmartDashboard.putNumber("Back RPS", getBRPS());
    }
}
