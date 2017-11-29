package exampleCode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Holonomic {
	private Joystick mobilityStick;
	private int xaxis;
	private int yaxis;
	private int turn_axis;

	private RobotDrive robotDrive;

	public void holonomicDrive() {
		robotDrive.mecanumDrive_Cartesian(mobilityStick.getRawAxis(xaxis), mobilityStick.getRawAxis(yaxis),
				mobilityStick.getRawAxis(turn_axis), 0);
	}
}
