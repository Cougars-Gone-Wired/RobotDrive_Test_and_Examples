package howCodeWorks;

public class Mecanum_polar {
	
	// 506-535
	public static void mecanumDrive_Polar(double magnitude, double direction, double rotation) {

	    magnitude = RobotDrive.limit(magnitude) * Math.sqrt(2.0);
	    
	    double dirInRad = (direction + 45.0) * 3.14159 / 180.0;
	    double cosD = Math.cos(dirInRad);
	    double sinD = Math.sin(dirInRad);

	    double[] wheelSpeeds = new double[RobotDrive.kMaxNumberOfMotors];
	    wheelSpeeds[0] = (sinD * magnitude + rotation);
	    wheelSpeeds[1] = (cosD * magnitude - rotation);
	    wheelSpeeds[2] = (cosD * magnitude + rotation);
	    wheelSpeeds[3] = (sinD * magnitude - rotation);

	    RobotDrive.normalize(wheelSpeeds);

	    RobotDrive.m_frontLeftMotor = (wheelSpeeds[0] * RobotDrive.m_maxOutput);
	    RobotDrive.m_frontRightMotor = (wheelSpeeds[1] * RobotDrive.m_maxOutput);
	    RobotDrive.m_rearLeftMotor = (wheelSpeeds[2] * RobotDrive.m_maxOutput);
	    RobotDrive.m_rearRightMotor = (wheelSpeeds[3] * RobotDrive.m_maxOutput);

	  }
}
