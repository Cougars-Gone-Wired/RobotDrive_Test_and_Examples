package exampleCode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Tank {
	
	private Joystick mobilityStick;
	private int Laxis;
	private int Raxis;
	
	private RobotDrive robotDrive;
	
	public void tankDrive() {
		robotDrive.tankDrive(mobilityStick.getRawAxis(Laxis), mobilityStick.getRawAxis(Raxis));
	}
}
