/**
 * On Mac/Linux:
 * javac -cp .:junit-cs211.jar *.java         # compile everything
 * java -cp .:junit-cs211.jar E3Tester        # run tester
 * <p>
 * On windows replace colons with semicolons: (: with ;)
 * javac -cp .;junit-cs211.jar *.java         # compile everything
 * java -cp .;junit-cs211.jar E3Tester        # run tester
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class SivaleeE3Tester {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("SivaleeE3Tester");
    }

    /**
        This is a helper method, not an actual test

        Notice that:
        - the @Test annotation is missing
        - the visibility is private
    */
    private boolean someHelp(String someParameter) {
        return true;
    }

//    /**
//        This is an empty test; it's always a pass
//        Not a useful test!
//    */
//    @Test
//    public void test_Point_01() {
//    }
//
//    /**
//        This test always fails
//        Not a useful test either!
//    */
//    @Test
//    public void test_Point_02() {
//        fail();
//    }

    // add your own tests here

	/**
	 * check Point.constructor (PASSES)
	*/
	@Test
	public void test_Point_01() {
		try {
			Point point = new Point(1, 2, 3);
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Point.constructor with negative x coordinate (FAILS)
	 */
	@Test
	public void test_Point_02() {
		try {
			Point point = new Point(-1, 2, 3);
		}
		catch (ArithmeticException e) {
			assertEquals("Invalid value -1.0 for coordinate x", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Point.constructor with negative y coordinate (FAILS)
	 */
	@Test
	public void test_Point_03() {
		try {
			Point point = new Point(1, -2, 3);
		}
		catch (ArithmeticException e) {
			assertEquals("Invalid value -2.0 for coordinate y", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Point.constructor with negative z coordinate (FAILS)
	 */
	@Test
	public void test_Point_04() {
		try {
			Point point = new Point(1, 2, -3);
		}
		catch (ArithmeticException e) {
			assertEquals("Invalid value -3.0 for coordinate z", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Point.toString
	*/
	@Test
	public void test_Point_toString() {
		try {
			Point point = new Point(1.4, 7.91, 123.07);
			assertEquals("{1.4,7.91,123.07}", point.toString());
		}
		catch (Exception e) {
			fail();
		}
	}

	/**
	 * check Point.equals with equal points (TRUE)
	*/
	@Test
	public void test_Point_equals_01() {
		try {
			Point point1 = new Point(1.4, 7.91, 123.07);
			Point point2 = new Point(1.4, 7.91, 123.07);
			assertTrue(point1.equals(point1));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Point.equals with unequal points (FALSE)
	*/
	@Test
	public void test_Point_equals_02() {
		try {
			Point point1 = new Point(1.4, 7.91, 123.07);
			Point point2 = new Point(3.91, 8.4, 621.2);
			assertFalse(point1.equals(point2));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Point.equals with incorrect object type (FALSE)
	 */
	@Test
	public void test_Point_equals_03() {
		try {
			Point point = new Point(1.4, 7.91, 123.07);
			assertFalse(point.equals("hello world!"));
		}
		catch (Exception e) {
			fail();
		}
	}

	/**
	 * check Point.distance with equal points
	*/
	@Test
	public void test_Point_distance_01() {
		try {
			Point point1 = new Point(1.4, 7.91, 123.07);
			Point point2 = new Point(1.4, 7.91, 123.07);
			assertTrue(0 == point1.distance(point2));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Point.distance with different points
	 */
	@Test
	public void test_Point_distance_02() {
		try {
			Point point1 = new Point(3, 4, 0);
			Point point2 = new Point(3, 4, 16);
			assertTrue(16 == point1.distance(point2));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Point.distance with different points (PASSES)
	 */
//	@Test
//	public void test_Point_distance_03() {
//		try {
//			Point point1 = new Point(24, 32, 52);
//			Point point2 = new Point(24, 8, 48);
//			assertTrue(64 == point1.distance(point2));
//		}
//		catch (Exception e) {
//			fail();
//		}
//	}
	
	/**
	 * check Face.constructor (PASSES)
	 */
	@Test
	public void test_Face_01() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face = new Face(point1, point2, point3);
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.constructor with an area of zero (FAILS)
	 */
	@Test
	public void test_Face_02() {
		try {
			Point point1 = new Point(0, 0, 0);
			Point point2 = new Point(0, 0, 0);
			Point point3 = new Point(0, 0, 0);
			Face face = new Face(point1, point2, point3); // fails
		}
		catch (FaceException e) {
			assertEquals("A face can't have a zero area", e.getMessage()); // passes
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.constructor with non equidistant points (FAILS)
	 */
	@Test
	public void test_Face_03() {
		try {
			Point point1 = new Point(1, 2, 3);
			Point point2 = new Point(3, 2, 1);
			Point point3 = new Point(2, 1, 3);
			Face face = new Face(point1, point2, point3); // fails
		}
		catch (FaceException e) {
			assertEquals("Points must be equidistant", e.getMessage()); // passes
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.toString
	 */
	@Test
	public void test_Face_toString() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face = new Face(point1, point2, point3);
			assertEquals("[{2.0,2.0,2.0}-{2.0,1.0,1.0}-{3.0,1.0,2.0}]", face.toString());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.equals with equal faces (TRUE)
	 */
	@Test
	public void test_Face_equals_01() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face1 = new Face(point1, point2, point3);
			Point point4 = new Point(2, 2, 2);
			Point point5 = new Point(2, 1, 1);
			Point point6 = new Point(3, 1, 2);
			Face face2 = new Face(point1, point2, point3);
			assertTrue(face1.equals(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.equals with unequal faces (FALSE)
	 */
	@Test
	public void test_Face_equals_02() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face1 = new Face(point1, point2, point3);
			Point point4 = new Point(2, 1, 1);
			Point point5 = new Point(3, 1, 2);
			Point point6 = new Point(3, 2, 1);
			Face face2 = new Face(point4, point5, point6);
			assertFalse(face1.equals(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.equals with incorrect object type (FALSE)
	 */
	public void test_Face_equals_03() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face = new Face(point1, point2, point3);
			assertFalse(face.equals("hello world"));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.adjacent (TRUE)
	 */
	@Test
	public void test_Face_adjacent_01() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face1 = new Face(point1, point2, point3);
			Point point4 = new Point(2, 1, 1);
			Point point5 = new Point(3, 1, 2);
			Point point6 = new Point(3, 2, 1);
			Face face2 = new Face(point4, point5, point6);
			assertTrue(face1.adjacent(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.adjacent with non adjacent face (FALSE)
	 */
	@Test
	public void test_Face_adjacent_02() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face1 = new Face(point1, point2, point3);
			Point point4 = new Point(1, 1, 1);
			Point point5 = new Point(1, 3, 3);
			Point point6 = new Point(3, 3, 1);
			Face face2 = new Face(point4, point5, point6);
			assertFalse(face1.adjacent(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.adjacent with an equal face (FALSE)
	 */
	@Test
	public void test_Face_adjacent_03() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face1 = new Face(point1, point2, point3);
			Point point4 = new Point(2, 2, 2);
			Point point5 = new Point(2, 1, 1);
			Point point6 = new Point(3, 1, 2);
			Face face2 = new Face(point4, point5, point6);
			assertFalse(face1.adjacent(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.edge (PASSES)
	 */
	@Test
	public void test_Face_edge() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face1 = new Face(point1, point2, point3);
			assertTrue(Math.sqrt(2) == face1.edge());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.area (PASSES)
	 */
	@Test
	public void test_Face_area() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 1, 2);
			Face face = new Face(point1, point2, point3);
			assertTrue((Math.sqrt(3)/4) * Math.pow(face.edge(), 2) == face.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.area (PASSES)
	 */
	public void test_Face_Area_02() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 3, 3);
			Point point3 = new Point(3, 3, 1);
			Face face = new Face(point1, point2, point3);
			assertTrue((Math.sqrt(3)/4) * Math.pow(face.edge(), 2) == face.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Face.area (PASSES)
	 */
	public void test_Face_Area_03() {
		try {
			Point point1 = new Point(3, 3, 3);
			Point point2 = new Point(3, 1, 1);
			Point point3 = new Point(5, 1, 3);
			Face face = new Face(point1, point2, point3);
			assertTrue((Math.sqrt(3)/4) * Math.pow(face.edge(), 2) == face.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Tetrahedron.constructor with faces (PASSES)
	 */
	@Test
	public void test_Tetrahedron_01() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			Point point4 = new Point(3, 1, 2);
			
			Face face1 = new Face(point1, point2, point3);
			Face face2 = new Face(point2, point3, point4);
			Face face3 = new Face(point3, point4, point1);
			Face face4 = new Face(point4, point1, point2);
			
			Tetrahedron tetrahedron = new Tetrahedron(face1, face2, face3, face4);
		}
		catch (TetrahedronException e) {
			assertEquals("The four faces do not form a tetrahedron", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.constructor with duplicate faces (FAILS)
	 */
	@Test
	public void test_Tetrahedron_02() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			Point point4 = new Point(3, 1, 2);
			
			Face face1 = new Face(point1, point2, point3);
			Face face2 = new Face(point2, point3, point4);
			Face face3 = new Face(point3, point4, point1);
			// duplicate face
			Face face4 = new Face(point2, point3, point1);
			
			Tetrahedron tetrahedron = new Tetrahedron(face1, face2, face3, face4);
		}
		catch (TetrahedronException e) {
			assertEquals("The four faces do not form a tetrahedron", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.constructor with non adjacent edges (FAILS)
	 */
	@Test
	public void test_Tetahedron_03() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			Point point4 = new Point(3, 1, 2);
			Point point5 = new Point(3, 3, 3);
			Point point6 = new Point(3, 1, 1);
			Point point7 = new Point(5, 1, 3);
			Face face1 = new Face(point1, point2, point3);
			Face face2 = new Face(point2, point3, point4);
			Face face3 = new Face(point3, point4, point1);
			// non adjacent face
			Face face4 = new Face(point5, point6, point7);
			
			Tetrahedron tetrahedron = new Tetrahedron(face1, face2, face3, face4);
		}
		catch (TetrahedronException e) {
			assertEquals("The four faces do not form a tetrahedron", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.constructor with points (PASSES)
	 */
	@Test
	public void test_Tetrahedron_04() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			Point point4 = new Point(3, 1, 2);
			
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
		}
		catch (TetrahedronException e) {
			assertEquals("The four faces do not form a tetrahedron", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.constructor with duplicate points (FAILS)
	 */
	@Test
	public void test_Tetrahedron_05() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			// duplicate point
			Point point4 = new Point(2, 2, 2);
			
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
		}
		catch (TetrahedronException e) {
			assertEquals("The four faces do not form a tetrahedron", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.constructor with non equidistant points (FAILS)
	 */
	@Test
	public void test_Tetrahedron_06() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			// non equidistant point
			Point point4 = new Point(3, 3, 3);
			
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
		}
		catch (TetrahedronException e) {
			assertEquals("The four faces do not form a tetrahedron", e.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.area with faces
	 */
	@Test
	public void test_Tetrahedron_area_01() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			Point point4 = new Point(3, 1, 2);
			
			Face face1 = new Face(point1, point2, point3);
			Face face2 = new Face(point2, point3, point4);
			Face face3 = new Face(point3, point4, point1);
			Face face4 = new Face(point4, point1, point2);
			
			Tetrahedron tetrahedron = new Tetrahedron(face1, face2, face3, face4);
			assertTrue(face1.area() * 4 == tetrahedron.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.area with points
	 */
	@Test
	public void test_Tetrahedron_area_02() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 1, 1);
			Point point3 = new Point(3, 2, 1);
			Point point4 = new Point(3, 1, 2);
			
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
			assertTrue(((Math.sqrt(3)/4) * Math.pow(point1.distance(point2), 2)) * 4 == tetrahedron.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	/**
	 * check Tetrahedron.volume with faces
	 */
	@Test
	public void test_Tetrahedron_volume_01() {
		try {
		Point point1 = new Point(2, 2, 2);
		Point point2 = new Point(2, 1, 1);
		Point point3 = new Point(3, 2, 1);
		Point point4 = new Point(3, 1, 2);
		
		Face face1 = new Face(point1, point2, point3);
		Face face2 = new Face(point2, point3, point4);
		Face face3 = new Face(point3, point4, point1);
		Face face4 = new Face(point4, point1, point2);
		
		Tetrahedron tetrahedron = new Tetrahedron(face1, face2, face3, face4);
		assertTrue((Math.pow(face1.edge(), 3)) / (6 * Math.sqrt(2)) == tetrahedron.volume());
		}
		catch (Exception e) {
			fail();
		}
	}
	@Test
	/**
	 * check Tetrahedron.volume with points
	 */
	public void test_Tetrahedron_volume_02() {
		try {
		Point point1 = new Point(2, 2, 2);
		Point point2 = new Point(2, 1, 1);
		Point point3 = new Point(3, 2, 1);
		Point point4 = new Point(3, 1, 2);
		
		Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
		assertTrue((Math.pow(point1.distance(point2), 3)) / (6 * Math.sqrt(2)) == tetrahedron.volume());
		}
		catch (Exception e) {
			fail();
		}
	}
}