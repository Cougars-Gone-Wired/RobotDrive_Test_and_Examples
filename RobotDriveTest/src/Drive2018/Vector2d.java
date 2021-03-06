package Drive2018;

public class Vector2d {
  public double x = 0.0;
  public double y = 0.0;

  public Vector2d() {}

  public Vector2d(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public void rotate(double angle) {
    double cosA = Math.cos(angle * (Math.PI / 180.0));
    double sinA = Math.sin(angle * (Math.PI / 180.0));
    double[] out = new double[2];
    out[0] = x * cosA - y * sinA;
    out[1] = x * sinA + y * cosA;
    x = out[0];
    y = out[1];
  }

  public double dot(Vector2d vec) {
    return x * vec.x + y * vec.y;
  }

  public double magnitude() {
    return Math.sqrt(x * x + y * y);
  }

  public double scalarProject(Vector2d vec) {
    return dot(vec) / vec.magnitude();
  }
}
