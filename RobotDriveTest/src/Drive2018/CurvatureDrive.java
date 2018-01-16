package Drive2018;

public class CurvatureDrive extends RobotDriveBase {

	public static void curvatureDrive(double xSpeed, double zRotation, boolean isQuickTurn) {

		xSpeed = limit(xSpeed);
		xSpeed = applyDeadband(xSpeed, m_deadband);

		zRotation = limit(zRotation);
		zRotation = applyDeadband(zRotation, m_deadband);

		double angularPower;
		boolean overPower;

		if (isQuickTurn) {
			if (Math.abs(xSpeed) < m_quickStopThreshold) {
				m_quickStopAccumulator = (1 - m_quickStopAlpha) * m_quickStopAccumulator
						+ m_quickStopAlpha * limit(zRotation) * 2;
			}
			overPower = true;
			angularPower = zRotation;
		} else {
			overPower = false;
			angularPower = Math.abs(xSpeed) * zRotation - m_quickStopAccumulator;

			if (m_quickStopAccumulator > 1) {
				m_quickStopAccumulator -= 1;
			} else if (m_quickStopAccumulator < -1) {
				m_quickStopAccumulator += 1;
			} else {
				m_quickStopAccumulator = 0.0;
			}
		}

		double leftMotorOutput = xSpeed + angularPower;
		double rightMotorOutput = xSpeed - angularPower;

		// If rotation is overpowered, reduce both outputs to within acceptable range
		if (overPower) {
			if (leftMotorOutput > 1.0) {
				rightMotorOutput -= leftMotorOutput - 1.0;
				leftMotorOutput = 1.0;
			} else if (rightMotorOutput > 1.0) {
				leftMotorOutput -= rightMotorOutput - 1.0;
				rightMotorOutput = 1.0;
			} else if (leftMotorOutput < -1.0) {
				rightMotorOutput -= leftMotorOutput + 1.0;
				leftMotorOutput = -1.0;
			} else if (rightMotorOutput < -1.0) {
				leftMotorOutput -= rightMotorOutput + 1.0;
				rightMotorOutput = -1.0;
			}
		}

		m_leftMotor = (leftMotorOutput * m_maxOutput);
		m_rightMotor = (-rightMotorOutput * m_maxOutput);
	}

}
