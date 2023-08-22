public class Point {
	// fields
	private double x;
	private double y;
	private double z;
	
	// constructor
	public Point(double x, double y, double z) {
		if (x < 0) {
			throw new ArithmeticException("Invalid value " + x + " for coordinate x");
		}
		if (y < 0) {
			throw new ArithmeticException("Invalid value " + y + " for coordinate y");
		}
		if (z < 0) {
			throw new ArithmeticException("Invalid value " + z + " for coordinate z");
		}
		else {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	@Override
	public String toString() {
		return "{" + this.x + "," + this.y + "," + this.z + "}";
	}
	
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object instanceof Point) {
			Point another = (Point)object;
			if (this.x == another.x && this.y == another.y && this.z == another.z) {
				result = true;
			}
		}
		else {
			result = false;
		}
		return result;
	}
	
	// calculates the distance between two points
	public double distance(Point other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2));
	}
}
