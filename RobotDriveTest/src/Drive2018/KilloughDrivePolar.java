package Drive2018;

public class KilloughDrivePolar {

	public static void killough_drivePolar(double magnitude, double angle, double zRotation) {
		KilloughDriveCartesian.killough_driveCartesian(magnitude * Math.sin(angle * (Math.PI / 180.0)),
				magnitude * Math.cos(angle * (Math.PI / 180.0)), zRotation, 0.0);
	}
}
