package frc.robot;

public class RobotMap {
    //Front Left Wheel
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_MOTOR = 6; // CAN Angle
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_ENCODER = 2; // Analog
    public static final int DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR = 5; // CAN Drive

    //Front Right Wheel
    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_MOTOR = 2; // CAN Angle
    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_ENCODER = 0; // Analog
    public static final int DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR = 1; // CAN Drive

    //Back Left Wheel
    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_MOTOR = 8; // CAN Angle
    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_ENCODER = 3; // Analog
    public static final int DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR = 7; // CAN Drive

    //Back Right Wheel
    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_MOTOR = 4; // CAN Angle
    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_ENCODER = 1; // Analog
    public static final int DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR = 3; // CAN Drive

    //Motors
    public static final int intakeMotor = 0;
    public static final int backspinMotor = 2; //CAN ID
    public static final int shooterMotor = 1; //CAN ID
    public static final int climber1 = 3;
    public static final int climber2 = 4;

    //Solenoids
    public static final int extender1 = 1;
    public static final int extender2 = 6;
    public static final int kicker1 = 2;
    public static final int kicker2 = 5;
    public static final int grabber1 = 0;
    public static final int grabber2 = 7;
}