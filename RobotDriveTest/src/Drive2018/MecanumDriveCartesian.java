package Drive2018;

public class MecanumDriveCartesian extends RobotDriveBase {

	public static void mecanum_driveCartesian(double ySpeed, double xSpeed, double zRotation) {
		mecanum_driveCartesian(ySpeed, xSpeed, zRotation, 0.0);
	}

	public static void mecanum_driveCartesian(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {

		ySpeed = limit(ySpeed);
		ySpeed = applyDeadband(ySpeed, m_deadband);

		xSpeed = limit(xSpeed);
		xSpeed = applyDeadband(xSpeed, m_deadband);

		// Compensate for gyro angle.
		Vector2d input = new Vector2d(ySpeed, xSpeed);
		input.rotate(-gyroAngle);

		double[] wheelSpeeds = new double[4];
		wheelSpeeds[MotorType.kFrontLeft.value] = input.x + input.y + zRotation;
		wheelSpeeds[MotorType.kFrontRight.value] = input.x - input.y + zRotation;
		wheelSpeeds[MotorType.kRearLeft.value] = -input.x + input.y + zRotation;
		wheelSpeeds[MotorType.kRearRight.value] = -input.x - input.y + zRotation;

		normalize(wheelSpeeds);

		m_frontLeftMotor = (wheelSpeeds[MotorType.kFrontLeft.value] * m_maxOutput);
		m_frontRightMotor = (wheelSpeeds[MotorType.kFrontRight.value] * m_maxOutput);
		m_rearLeftMotor = (wheelSpeeds[MotorType.kRearLeft.value] * m_maxOutput);
		m_rearRightMotor = (wheelSpeeds[MotorType.kRearRight.value] * m_maxOutput);
	}
}
