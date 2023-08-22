
public class Face {
	// fields
	private Point a;
	private Point b;
	private Point c;
	
	// constructor
	public Face(Point a, Point b, Point c) throws FaceException {
		this.a = a;
		this.b = b;
		this.c = c;
		
		// if all the points are the same, then all the face is not triangle creating no area
		if (area() == 0) {
			throw new FaceException("A face can't have a zero area");
		}
		// if all the distances btwn the points are not equal, it is not an equilateral triangle
		if (!(a.distance(b) == b.distance(c) ||  b.distance(c) == c.distance(a))) {
			throw new FaceException("Points must be equidistant");
		}
	}
	
	@Override
	public String toString() {
		return "[" + a.toString() + "-" + b.toString() + "-" + c.toString() + "]";
	}
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object instanceof Face && object != null) {
			int numFaceCounter = 0;
			Face another = (Face)object;
			Point[] point = {this.a, this.b, this.c};
			Point[] anotherPoint = {another.a, another.b, another.c};
			for (int i = 0; i < point.length; i++) {
				for (int j = 0; j < anotherPoint.length; j++) {
					if (point[i].equals(anotherPoint[j]) && (anotherPoint[j] != null)) {
						numFaceCounter++;
						anotherPoint[j] = null;
						break;
					}
				}
			}
			if (numFaceCounter == 3) {
				result = true;
			}
		}
		else {
			result = false;
		}
		return result;
	}
	
	public boolean adjacent(Face other) {
		int numSamePoints = 0;
		boolean adjacent = false;
		if (this.a.equals(other.a) || this.a.equals(other.b) || this.a.equals(other.c)) {
			numSamePoints++;
		}
		if (this.b.equals(other.a) || this.b.equals(other.b) || this.b.equals(other.c)) {
			numSamePoints++;
		}
		if (this.c.equals(other.a) || this.c.equals(other.b) || this.c.equals(other.c)) {
			numSamePoints++;
		}
		// numSamePoint will increase every time the points of two triangles match
		// so numSamePoints should equal 2 if the triangles share a same side, as two points will match
		if (numSamePoints == 2) {
			adjacent = true;
		}
		return adjacent;
	}
	
	public double edge() {
		return a.distance(b);
	}
	
	public double area() {
		double area = (Math.sqrt(3) / 4) * (Math.pow(edge(), 2));
		return area;
	}
}
