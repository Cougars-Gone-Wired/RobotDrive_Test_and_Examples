package Drive2018;

public class MecanumDrivePolar {

	public static void mecanum_drivePolar(double magnitude, double angle, double zRotation) {
	    MecanumDriveCartesian.mecanum_driveCartesian(magnitude * Math.sin(angle * (Math.PI / 180.0)),
	                   magnitude * Math.cos(angle * (Math.PI / 180.0)), zRotation, 0.0);
	  }
}
