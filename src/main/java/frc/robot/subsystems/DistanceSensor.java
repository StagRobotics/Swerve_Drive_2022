package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceSensor extends Subsystem {
    protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	public static DistanceSensor instance;
	public static DistanceSensor getInstance() {
        if (instance == null) {
            instance = new DistanceSensor();
        }
    
        return instance;
    }
	
	  // A MB1013 distance sensor - http://www.maxbotix.com/documents/HRLV-MaxSonar-EZ_Datasheet.pdf
	  // (pins 3, 6 and 7 from sensor to analog input 0)
	private static final AnalogInput mb1013 = new AnalogInput(4);
	  
	  // TODO - You will need to determine how to convert voltage to distance
	  // (use information from the data sheet, or your own measurements)
	private static final double VOLTS_TO_DIST = (100/2.4);

	public static double getVoltage() {
	    return mb1013.getVoltage();
	}
	  
	public static double getDistance() {
	    return getVoltage() * VOLTS_TO_DIST;
	}
	  
	public void periodic() {
	    SmartDashboard.putNumber("Distance (volts)", getVoltage());
	    SmartDashboard.putNumber("Distance (real)", getDistance());
	}

	
}
