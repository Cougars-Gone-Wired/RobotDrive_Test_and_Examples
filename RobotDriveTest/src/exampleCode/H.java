package exampleCode;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class H {
	
	private Joystick mobilityStick;
	private int Laxis;
	private int Raxis;
	private int Lbumper;
	private int Rbumper;
	private int downButton;
	private int upButton;
	
	private RobotDrive robotDrive;
	
	private CANTalon centerWheelMotor;
	private Solenoid hDrop;
	
	boolean downTrue;
	
	public void hDrive() {
		robotDrive.tankDrive(mobilityStick.getRawAxis(Laxis), mobilityStick.getRawAxis(Raxis));
		
		if (mobilityStick.getRawButton(Lbumper)) {
			centerWheelMotor.set(-1);
		} else if (mobilityStick.getRawButton(Rbumper)) {
			centerWheelMotor.set(1);
		} else {
			centerWheelMotor.set(0);
		}
	}
	
	public void hDropper() {
		if (mobilityStick.getRawButton(downButton)) {
			downTrue = true;
		} else if (mobilityStick.getRawButton(upButton)) {
			downTrue = false;
		}
		hDrop.set(downTrue);
	}
}
