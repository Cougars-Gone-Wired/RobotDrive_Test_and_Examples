package howCodeWorks;

public class Arcade {
	
	// 380-428
	public static void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {

		double leftMotorSpeed;
		double rightMotorSpeed;

		moveValue = RobotDrive.limit(moveValue);
		rotateValue = RobotDrive.limit(rotateValue);

		if (squaredInputs) {
			if (moveValue >= 0.0) {
				moveValue = moveValue * moveValue;
			} else {
				moveValue = -(moveValue * moveValue);
			}
			if (rotateValue >= 0.0) {
				rotateValue = rotateValue * rotateValue;
			} else {
				rotateValue = -(rotateValue * rotateValue);
			}
		}

		if (moveValue > 0.0) {
			if (rotateValue > 0.0) {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} else {
			if (rotateValue > 0.0) {
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} else {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}

		RobotDrive.setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
	}

	// 437-439
	public static void arcadeDrive(double moveValue, double rotateValue) {
		arcadeDrive(moveValue, rotateValue, true);
	}
}
