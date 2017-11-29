package howCodeWorks;
public class Tank {

	// 271-296
	public static void tankDrive(double leftValue, double rightValue, boolean squaredInputs) {

		leftValue = RobotDrive.limit(leftValue);
		rightValue = RobotDrive.limit(rightValue);
		if (squaredInputs) {
			if (leftValue >= 0.0) {
				leftValue = leftValue * leftValue;
			} else {
				leftValue = -(leftValue * leftValue);
			}
			if (rightValue >= 0.0) {
				rightValue = rightValue * rightValue;
			} else {
				rightValue = -(rightValue * rightValue);
			}
		}
		RobotDrive.setLeftRightMotorOutputs(leftValue, rightValue);
	}

	// 305-307
	public static void tankDrive(double leftValue, double rightValue) {
		tankDrive(leftValue, rightValue, true);
	}
}
