package Drive2018;

public class KilloughDriveCartesian extends RobotDriveBase {

	public static void killough_driveCartesian(double ySpeed, double xSpeed, double zRotation) {
		killough_driveCartesian(ySpeed, xSpeed, zRotation, 0.0);
	}

	public static void killough_driveCartesian(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {

		m_leftVec = new Vector2d(Math.cos(leftMotorAngle * (Math.PI / 180.0)),
				Math.sin(leftMotorAngle * (Math.PI / 180.0)));
		m_rightVec = new Vector2d(Math.cos(rightMotorAngle * (Math.PI / 180.0)),
				Math.sin(rightMotorAngle * (Math.PI / 180.0)));
		m_backVec = new Vector2d(Math.cos(backMotorAngle * (Math.PI / 180.0)),
				Math.sin(backMotorAngle * (Math.PI / 180.0)));

		ySpeed = limit(ySpeed);
		ySpeed = applyDeadband(ySpeed, m_deadband);

		xSpeed = limit(xSpeed);
		xSpeed = applyDeadband(xSpeed, m_deadband);

		// Compensate for gyro angle.
		Vector2d input = new Vector2d(ySpeed, xSpeed);
		input.rotate(-gyroAngle);

		double[] wheelSpeeds = new double[3];
		wheelSpeeds[MotorType.kLeft.value] = input.scalarProject(m_leftVec) + zRotation;
		wheelSpeeds[MotorType.kRight.value] = input.scalarProject(m_rightVec) + zRotation;
		wheelSpeeds[MotorType.kBack.value] = input.scalarProject(m_backVec) + zRotation;

		normalize(wheelSpeeds);

		m_leftMotor = (wheelSpeeds[MotorType.kLeft.value] * m_maxOutput);
		m_rightMotor = (wheelSpeeds[MotorType.kRight.value] * m_maxOutput);
		m_backMotor = (wheelSpeeds[MotorType.kBack.value] * m_maxOutput);
	}
}
