package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Shooter extends Subsystem {
    private PWMVictorSPX smbs = new PWMVictorSPX(RobotMap.backspinMotor);
    private PWMVictorSPX sms = new PWMVictorSPX(RobotMap.shooterMotor);
    private DoubleSolenoid kicker = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.kicker1, RobotMap.kicker2);
    private Encoder frontEncoder = new Encoder(6,7, false, Encoder.EncodingType.k4X);
    private Encoder backEncoder = new Encoder(4,5, false, Encoder.EncodingType.k4X);



    private boolean Shoot = false;
    private boolean kick = false;
    private boolean Spin = false;
    private double SMSpeed = 0.5;
    private double BSSpeed = 0.5;
    private double FRPS = 0.0;
    private double BRPS = 0.0;
    double Fdiameter = 6/12; // 6 inch wheels
	double Fdist =0.5*3.14/1024;  // ft per pulse
    double Bdiameter = 4/12;
    double Bdist = 0.33*3.14/1024;
    private static Shooter instance;

    public Shooter(){
        super();
        System.out.print("Shoot");
    }

    @Override
    public void initDefaultCommand(){
        //Set the default command for a subsystem here. 
        // setDefaultCommand(new MySpecialCommand());
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

    public void toggleWheel(){
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
