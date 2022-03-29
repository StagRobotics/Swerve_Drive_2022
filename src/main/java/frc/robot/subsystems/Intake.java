package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
    private boolean onIntake = false;
  private boolean extend = false;
  private DoubleSolenoid extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.extender1, RobotMap.extender2);
  private Spark intakeMotor = new Spark(RobotMap.intakeMotor);
    private static Intake instance;

  public Intake(){
    super();
    System.out.print("Intake");
  }
  

  public static Intake getInstance() {
    if (instance == null) {
        instance = new Intake();
    }

    return instance;
}

  public void toggleIntake(double speed){
    if (onIntake == false){
      intakeForward();
      onIntake = true;
    }else{
      intakeOff();
      onIntake = false;
    }
  }
  
  
  public void ToggleExtend(){
    if (extend == false){
      extender.set(DoubleSolenoid.Value.kReverse);
      extend = true;
    }else if(extend = true){
      extender.set(DoubleSolenoid.Value.kForward);
      extend = false;
    }
  }
    
  public void intakeForward() {
    intakeMotor.set(0.5);
  }
    
  public void intakeBackward() {
    intakeMotor.set(-0.5);
  }
        
  public void intakeOff(){
    intakeMotor.set(0.0);
  }
}
