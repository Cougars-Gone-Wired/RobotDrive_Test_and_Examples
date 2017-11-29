package exampleCode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Arcade {

	private Joystick mobilityStick;
	private int yaxis;
	private int xaxis;
	
	private RobotDrive robotDrive;
	
	public void arcadeDrive() {
		robotDrive.arcadeDrive(mobilityStick.getRawAxis(yaxis), mobilityStick.getRawAxis(xaxis));
	}
}
