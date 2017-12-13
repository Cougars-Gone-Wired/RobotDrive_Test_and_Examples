package howCodeWorks;

public class Caller {

	private static double arcade_Y_Axis_Invert = 1;
	private static double arcade_X_Axis_Invert = -1;

	public static void main(String[] args) {

		double drive_speed = 1;
		double drive_turn = 1;
		
		double mecanum_polar_speed = 1;
		double mecanum_polar_direction = 90; // in degrees
		double mecanum_polar_turn = 0;
		
		double arcade_LS_Y_Axis = 0;
		double arcade_RS_X_Axis = 0;
		
		double tank_LS_Y_Axis = 0;
		double tank_RS_Y_Axis = 0;
		
		double mecanum_LS_Y_Axis = 0;
		double mecanum_LS_X_Axis = 0;
		double mecanum_RS_X_Axis = 0;
		
		Drive.drive(drive_speed, drive_turn);
		System.out.println("Drive:");
		System.out.println(RobotDrive.m_frontLeftMotor + "  " + RobotDrive.m_frontRightMotor);
		System.out.println(RobotDrive.m_rearLeftMotor + "  " + RobotDrive.m_rearRightMotor + "\n");
		
		Mecanum_polar.mecanumDrive_Polar(mecanum_polar_speed, mecanum_polar_direction, mecanum_polar_turn);
		System.out.println("Macanum Polar Drive:");
		System.out.println(RobotDrive.m_frontLeftMotor + "  " + RobotDrive.m_frontRightMotor);
		System.out.println(RobotDrive.m_rearLeftMotor + "  " + RobotDrive.m_rearRightMotor + "\n");
		
		Arcade.arcadeDrive(arcade_Y_Axis_Invert * (arcade_LS_Y_Axis), arcade_X_Axis_Invert * (arcade_RS_X_Axis));
		System.out.println("Arcade Drive:");
		System.out.println(RobotDrive.m_frontLeftMotor + "  " + RobotDrive.m_frontRightMotor);
		System.out.println(RobotDrive.m_rearLeftMotor + "  " + RobotDrive.m_rearRightMotor + "\n");
		
		Tank.tankDrive(tank_LS_Y_Axis, tank_RS_Y_Axis);
		System.out.println("Tank Drive:");
		System.out.println(RobotDrive.m_frontLeftMotor + "  " + RobotDrive.m_frontRightMotor);
		System.out.println(RobotDrive.m_rearLeftMotor + "  " + RobotDrive.m_rearRightMotor + "\n");

		Mecanum_Cartesian.mecanumDrive_Cartesian(mecanum_LS_X_Axis, mecanum_LS_Y_Axis, mecanum_RS_X_Axis, 0.0);
		System.out.println("Mecanum Drive:");
		System.out.println(RobotDrive.m_frontLeftMotor + "  " + RobotDrive.m_frontRightMotor);
		System.out.println(RobotDrive.m_rearLeftMotor + "  " + RobotDrive.m_rearRightMotor + "\n");
	}

}
