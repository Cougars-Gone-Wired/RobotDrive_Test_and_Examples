package Drive2018;

public class RobotDriveBase {

	// RobotDriveBase
	public static final double kDefaultDeadband = 0.02; // 18
	public static final double kDefaultMaxOutput = 1.0; // 19

	protected static double m_deadband = kDefaultDeadband; // 21
	protected static double m_maxOutput = kDefaultMaxOutput; // 22

	// 28-38
	public enum MotorType {
		kFrontLeft(0), kFrontRight(1), kRearLeft(2), kRearRight(3), kLeft(0), kRight(1), kBack(2);

		@SuppressWarnings("MemberName")
		public final int value;

		MotorType(int value) {
			this.value = value;
		}
	}

	// 102-110
	protected static double limit(double value) {
		if (value > 1.0) {
			return 1.0;
		}
		if (value < -1.0) {
			return -1.0;
		}
		return value;
	}

	// 119-129
	protected static double applyDeadband(double value, double deadband) {
		if (Math.abs(value) > deadband) {
			if (value > 0.0) {
				return (value - deadband) / (1.0 - deadband);
			} else {
				return (value + deadband) / (1.0 - deadband);
			}
		} else {
			return 0.0;
		}
	}

	// 134-147
	protected static void normalize(double[] wheelSpeeds) {
		double maxMagnitude = Math.abs(wheelSpeeds[0]);
		for (int i = 1; i < wheelSpeeds.length; i++) {
			double temp = Math.abs(wheelSpeeds[i]);
			if (maxMagnitude < temp) {
				maxMagnitude = temp;
			}
		}
		if (maxMagnitude > 1.0) {
			for (int i = 0; i < wheelSpeeds.length; i++) {
				wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
			}
		}
	}

	// DifferentialDrive
	public static final double kDefaultQuickStopThreshold = 0.2; // 94
	public static final double kDefaultQuickStopAlpha = 0.1; // 95

	protected static double m_leftMotor; // 99
	protected static double m_rightMotor; // 100

	protected static double m_quickStopThreshold = kDefaultQuickStopThreshold; // 102
	protected static double m_quickStopAlpha = kDefaultQuickStopAlpha; // 103
	protected static double m_quickStopAccumulator = 0.0; // 104

	// MecanumDrive
	protected static double m_frontLeftMotor; // 62
	protected static double m_rearLeftMotor; // 63
	protected static double m_frontRightMotor; // 64
	protected static double m_rearRightMotor; // 65

	// KilloughDrive
	public static final double kDefaultLeftMotorAngle = 60.0;
	public static final double kDefaultRightMotorAngle = 120.0;
	public static final double kDefaultBackMotorAngle = 270.0;
	
	static double leftMotorAngle = kDefaultLeftMotorAngle;
	static double rightMotorAngle = kDefaultRightMotorAngle;
    static double backMotorAngle = kDefaultBackMotorAngle;
	
	protected static double m_backMotor;

	protected static Vector2d m_leftVec;
	protected static Vector2d m_rightVec;
	protected static Vector2d m_backVec;

}
