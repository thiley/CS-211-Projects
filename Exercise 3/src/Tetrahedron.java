public class Tetrahedron {
	// fields
	private Face a;
	private Face b;
	private Face c;
	private Face d;
	
	// constructor
	public Tetrahedron(Face a, Face b, Face c, Face d) throws TetrahedronException {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		// check if faces are adjacent
//		if (!(a.adjacent(b) && a.adjacent(c) && a.adjacent(d) && b.adjacent(c) && b.adjacent(d) && c.adjacent(d))) {
//			throw new TetrahedronException("The four faces do not form a tetrahedron");
//		}
		// check that the faces are different and not the same face
		Face[] face = {a, b, c, d};
		for (int i = 0; i < face.length; i++) {
			for (int j = i + 1; j < face.length; j++) {
				if ((face[i].equals(face[j]))) {
					throw new TetrahedronException("The four faces do not form a tetrahedron");
				}
				if (!(face[i].adjacent(face[j]))) {
					throw new TetrahedronException("The four faces do not form a tetrahedron");
				}
			}
		}
		
	}
	
	public Tetrahedron(Point a, Point b, Point c, Point d) throws TetrahedronException {
		Point[] point = {a, b, c, d};
		for (int i = 0; i < point.length; i++) {
			for (int j = i + 1; j < point.length; j++) {
				if ((point[i] == point[j])) {
					throw new TetrahedronException("The four faces do not form a tetrahedron");
				}
				if ((point[i].distance(point[j]) != point[0].distance(point[1]))) {
					throw new TetrahedronException("The four faces do not form a tetrahedron");
				}
			}
		}
		Face face1 = new Face(a, b, c);
		Face face2 = new Face(b, c, a);
		Face face3 = new Face(c, a, b);
		Face face4 = new Face(d, a, b);
		this.a = face1;
		this.b = face2;
		this.c = face3;
		this.d = face4;
	}
	
	// other methods
	
	public double area() {
		return a.area() + b.area() + c.area() + d.area();
	}
	
	public double volume() {
		return (Math.pow(a.edge(), 3) / (6 * Math.sqrt(2)));
	}
}
