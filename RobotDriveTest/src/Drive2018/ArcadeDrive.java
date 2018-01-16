package Drive2018;

public class ArcadeDrive extends RobotDriveBase {

	 public static void arcadeDrive(double xSpeed, double zRotation) {
	    arcadeDrive(xSpeed, zRotation, true);
	  }

	  public static void arcadeDrive(double xSpeed, double zRotation, boolean squaredInputs) {

	    xSpeed = limit(xSpeed);
	    xSpeed = applyDeadband(xSpeed, m_deadband);

	    zRotation = limit(zRotation);
	    zRotation = applyDeadband(zRotation, m_deadband);

	    // Square the inputs (while preserving the sign) to increase fine control
	    // while permitting full power.
	    if (squaredInputs) {
	      xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
	      zRotation = Math.copySign(zRotation * zRotation, zRotation);
	    }

	    double leftMotorOutput;
	    double rightMotorOutput;

	    double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);

	    if (xSpeed >= 0.0) {
	      // First quadrant, else second quadrant
	      if (zRotation >= 0.0) {
	        leftMotorOutput = maxInput;
	        rightMotorOutput = xSpeed - zRotation;
	      } else {
	        leftMotorOutput = xSpeed + zRotation;
	        rightMotorOutput = maxInput;
	      }
	    } else {
	      // Third quadrant, else fourth quadrant
	      if (zRotation >= 0.0) {
	        leftMotorOutput = xSpeed + zRotation;
	        rightMotorOutput = maxInput;
	      } else {
	        leftMotorOutput = maxInput;
	        rightMotorOutput = xSpeed - zRotation;
	      }
	    }

	    m_leftMotor = (limit(leftMotorOutput) * m_maxOutput);
	    m_rightMotor = (-limit(rightMotorOutput) * m_maxOutput);
	  }

}
