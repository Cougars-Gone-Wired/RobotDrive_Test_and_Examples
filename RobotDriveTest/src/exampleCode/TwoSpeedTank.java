package exampleCode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class TwoSpeedTank {
	
	private Joystick mobilityStick;
	private int Laxis;
	private int Raxis;
	private int highButton;
	private int lowButton;
	
	private RobotDrive robotDrive;
	
	private Solenoid shifter;
	
	boolean highGearTrue;
	
	public void tankDrive() {
		robotDrive.tankDrive(mobilityStick.getRawAxis(Laxis), mobilityStick.getRawAxis(Raxis));
	}
	
	public void shift() {
		if (mobilityStick.getRawButton(highButton)) {
			highGearTrue = true;
		} else if (mobilityStick.getRawButton(lowButton)) {
			highGearTrue = false;
		}
		shifter.set(highGearTrue);
	}
}
