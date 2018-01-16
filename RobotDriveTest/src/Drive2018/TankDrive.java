package Drive2018;

public class TankDrive extends RobotDriveBase {

	public static void tankDrive(double leftSpeed, double rightSpeed) {
		tankDrive(leftSpeed, rightSpeed, true);
	}

	public static void tankDrive(double leftSpeed, double rightSpeed, boolean squaredInputs) {

		leftSpeed = limit(leftSpeed);
		leftSpeed = applyDeadband(leftSpeed, m_deadband);

		rightSpeed = limit(rightSpeed);
		rightSpeed = applyDeadband(rightSpeed, m_deadband);

		// Square the inputs (while preserving the sign) to increase fine control
		// while permitting full power.
		if (squaredInputs) {
			leftSpeed = Math.copySign(leftSpeed * leftSpeed, leftSpeed);
			rightSpeed = Math.copySign(rightSpeed * rightSpeed, rightSpeed);
		}

		m_leftMotor = (leftSpeed * m_maxOutput);
		m_rightMotor = (-rightSpeed * m_maxOutput);

	}
}
