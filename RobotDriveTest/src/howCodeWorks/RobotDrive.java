package howCodeWorks;

public class RobotDrive {

	// 44-45
	public static final double m_maxOutput = 1.0;
	protected static final int kMaxNumberOfMotors = 4;
	
	// 48-51
	static double m_frontLeftMotor;
	static double m_rearLeftMotor;
	static double m_frontRightMotor;
	static double m_rearRightMotor;

	private static double m_frontLeftMotorInvert;
	private static double m_rearLeftMotorInvert;
	private static double m_frontRightMotorInvert;
	private static double m_rearRightMotorInvert;

	// 560-578
	public static void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
		invert(false, false, true, true);

		// so that we don't end up with -0
		if (leftOutput == 0) {
			leftOutput = Math.abs(leftOutput);
		}
		if (rightOutput == 0) {
			rightOutput = Math.abs(rightOutput);
		}

		m_frontLeftMotor = (limit(leftOutput) * m_maxOutput) * m_frontLeftMotorInvert;
		m_rearLeftMotor = (limit(leftOutput) * m_maxOutput) * m_rearLeftMotorInvert;
		m_frontRightMotor = (-limit(rightOutput) * m_maxOutput) * m_frontRightMotorInvert;
		m_rearRightMotor = (-limit(rightOutput) * m_maxOutput) * m_rearRightMotorInvert;

	}

	// 583-591
	protected static double limit(double num) {
		if (num > 1.0) {
			return 1.0;
		}
		if (num < -1.0) {
			return -1.0;
		}
		return num;
	}

	// 596-609
	protected static void normalize(double[] wheelSpeeds) {
		double maxMagnitude = Math.abs(wheelSpeeds[0]);
		for (int i = 1; i < kMaxNumberOfMotors; i++) {
			double temp = Math.abs(wheelSpeeds[i]);
			if (maxMagnitude < temp) {
				maxMagnitude = temp;
			}
		}
		if (maxMagnitude > 1.0) {
			for (int i = 0; i < kMaxNumberOfMotors; i++) {
				wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
			}
		}
	}

	// 614-622
	protected static double[] rotateVector(double x, double y, double angle) {
		double cosA = Math.cos(angle * (3.14159 / 180.0));
		double sinA = Math.sin(angle * (3.14159 / 180.0));
		double[] out = new double[2];
		out[0] = x * cosA - y * sinA;
		out[1] = x * sinA + y * cosA;
		return out;
	}

	public static void invert(boolean m_frontLeftMotor, boolean m_rearLeftMotor, boolean m_frontRightMotor, boolean m_rearRightMotor) {
		if (m_frontLeftMotor) {
			m_frontLeftMotorInvert = -1;
		} else {
			m_frontLeftMotorInvert = 1;
		}
		if (m_rearLeftMotor) {
			m_rearLeftMotorInvert = -1;
		} else {
			m_rearLeftMotorInvert = 1;
		}
		if (m_frontRightMotor) {
			m_frontRightMotorInvert = -1;
		} else {
			m_frontRightMotorInvert = 1;
		}
		if (m_rearRightMotor) {
			m_rearRightMotorInvert = -1;
		} else {
			m_rearRightMotorInvert = 1;
		}
	}

}
