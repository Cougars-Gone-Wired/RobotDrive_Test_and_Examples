package Drive2018;

public class Caller extends RobotDriveBase{

	public static void main(String[] args) {
		
		double arcade_LS_Y_Axis = 1;
		double arcade_RS_X_Axis = 0;
		
		double curvatureDrive_speed = 1;
		double curvatureDrive_turn = 0;
		boolean curvatureDrive_QuickTurn = false;
		
		double tank_LS_Y_Axis = 1;
		double tank_RS_Y_Axis = 1;
		
		double mecanum_cartesian_LS_Y_Axis = 1;
		double mecanum_cartesian_LS_X_Axis = 0;
		double mecanum_cartesian_RS_X_Axis = 0;
		
		double mecanum_polar_speed = 1;
		double mecanum_polar_direction = 0; // in degrees (-180, 180)
		double mecanum_polar_turn = 0;
		
		double killough_cartesian_LS_Y_Axis = 0;
		double killough_cartesian_LS_X_Axis = 0;
		double killough_cartesian_RS_X_Axis = 1;
		
		double killough_polar_speed = 1;
		double killough_polar_direction = 0; // in degrees (-180, 180)
		double killough_polar_turn = 0;
		
		ArcadeDrive.arcadeDrive(arcade_LS_Y_Axis, arcade_RS_X_Axis);
		System.out.println("Arcade Drive:");
		System.out.println(m_leftMotor + "  " + m_rightMotor);
		System.out.println(m_leftMotor + "  " + m_rightMotor + "\n");
		
		CurvatureDrive.curvatureDrive(curvatureDrive_speed, curvatureDrive_turn, curvatureDrive_QuickTurn);
		System.out.println("Curvature Drive:");
		System.out.println(m_leftMotor + "  " + m_rightMotor);
		System.out.println(m_leftMotor + "  " + m_rightMotor + "\n");
		
		TankDrive.tankDrive(tank_LS_Y_Axis, tank_RS_Y_Axis);
		System.out.println("Tank Drive:");
		System.out.println(m_leftMotor + "  " + m_rightMotor);
		System.out.println(m_leftMotor + "  " + m_rightMotor + "\n");
		
		MecanumDriveCartesian.mecanum_driveCartesian(mecanum_cartesian_LS_X_Axis, mecanum_cartesian_LS_Y_Axis, mecanum_cartesian_RS_X_Axis);
		System.out.println("Mecanum Cartesian Drive:");
		System.out.println(m_frontLeftMotor + "  " + m_frontRightMotor);
		System.out.println(m_rearLeftMotor + "  " + m_rearRightMotor + "\n");
		
		MecanumDrivePolar.mecanum_drivePolar(mecanum_polar_speed, mecanum_polar_direction, mecanum_polar_turn);
		System.out.println("Mecanum Polar Drive:");
		System.out.println(m_frontLeftMotor + "  " + m_frontRightMotor);
		System.out.println(m_rearLeftMotor + "  " + m_rearRightMotor + "\n");
		
		KilloughDriveCartesian.killough_driveCartesian(killough_cartesian_LS_Y_Axis, killough_cartesian_LS_X_Axis, killough_cartesian_RS_X_Axis);
		System.out.println("Killough Cartesian Drive:");
		System.out.println(m_leftMotor + "  " + m_rightMotor);
		System.out.println("   " + m_backMotor + "\n");
		
		KilloughDrivePolar.killough_drivePolar(killough_polar_speed, killough_polar_direction, killough_polar_turn);
		System.out.println("Killough Polar Drive:");
		System.out.println(m_leftMotor + "  " + m_rightMotor);
		System.out.println("   " + m_backMotor);
	}
}
