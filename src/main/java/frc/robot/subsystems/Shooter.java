package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;

public class Shooter extends Subsystem {
    private PWMVictorSPX smbs = new PWMVictorSPX(RobotMap.backspinMotor);
    private PWMVictorSPX sms = new PWMVictorSPX(RobotMap.shooterMotor);
    private DoubleSolenoid kicker = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.kicker1, RobotMap.kicker2);
    private Encoder frontEncoder = new Encoder(6,7, false, Encoder.EncodingType.k4X);
    private Encoder backEncoder = new Encoder(4,5, false, Encoder.EncodingType.k4X);



    private boolean Shoot = true;
    private boolean kick = false;
    private boolean Spin = true;
    private double FastSpeed = .8;
    private double MediumSpeed = 0.45;
    private double BSSpeed = 0.4;
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

    public void FastWheel(){
            if (Shoot){
                sms.set(FastSpeed);
                //while(getFRPS() < 155.0 && OI.secondaryJoystick.getRawButtonPressed(4)){
                    //SMSpeed = SMSpeed + 0.01;
                    //sms.set(SMSpeed);
                    
                //}
                Shoot = false;
                
            }else{
                sms.set(0.0);
                Shoot = true;
                
            }
    }
    public void MediumWheel(){
        if (Shoot){
            sms.set(MediumSpeed);
            //while(getFRPS() < 155.0 && OI.secondaryJoystick.getRawButtonPressed(4)){
                //SMSpeed = SMSpeed + 0.01;
                //sms.set(SMSpeed);
                
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
