package exampleCode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Arcade {

	private Joystick mobilityStick;
	private int yaxis;
	private int xaxis;
	
	private DifferentialDrive robotDrive;
	
	public void arcadeDrive() {
		robotDrive.arcadeDrive(mobilityStick.getRawAxis(yaxis), mobilityStick.getRawAxis(xaxis));
	}
}
