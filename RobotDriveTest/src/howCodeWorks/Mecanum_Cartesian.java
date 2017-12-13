package howCodeWorks;

public class Mecanum_Cartesian {

	// 459-491
	public static void mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle) {
		
		double xIn = x;
		double yIn = y;
		//yIn = -yIn;

		double[] rotated = RobotDrive.rotateVector(xIn, yIn, gyroAngle);
		xIn = rotated[0];
		yIn = rotated[1];

		double[] wheelSpeeds = new double[RobotDrive.kMaxNumberOfMotors];
		wheelSpeeds[0] = xIn + yIn + rotation;
	    wheelSpeeds[1] = -xIn + yIn - rotation;
	    wheelSpeeds[2] = -xIn + yIn + rotation;
	    wheelSpeeds[3] = xIn + yIn - rotation;

		RobotDrive.normalize(wheelSpeeds);
		RobotDrive.m_frontLeftMotor = (wheelSpeeds[0] * RobotDrive.m_maxOutput);
		RobotDrive.m_frontRightMotor = (wheelSpeeds[1] * RobotDrive.m_maxOutput);
		RobotDrive.m_rearLeftMotor = (wheelSpeeds[2] * RobotDrive.m_maxOutput);
		RobotDrive.m_rearRightMotor = (wheelSpeeds[3] * RobotDrive.m_maxOutput);

	}
}
