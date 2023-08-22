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

public class E3Tester {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("E3Tester");
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

    /**
        This is an empty test; it's always a pass
        Not a useful test!
    */
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

    /**
     * check Point.constructor
     */
    @Test
    public void test_Point_01() {
    	try {
    		Point point = new Point(1, 2, 3);
    	}
    	catch(Exception e) {
    		fail();
    	}
    }

    /**
     * check Point.constructor: negative x value - FAIL
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
	 * check Point.constructor: negative y value - FAIL
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
	 * check Point.constructor: negative z value - FAIL
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
	 * check Point.toString - PASS
	*/
	@Test
	public void test_Point_toString() {
		try {
			Point point = new Point(1.2, 2.3, 3.1);
			assertEquals("{1.2,2.3,3.1}", point.toString());
		}
		catch (Exception e) {
			fail();
		}
	}

	/**
	 * check Point.equals - PASS
	*/
	@Test
	public void test_Point_equals_01() {
		try {
			Point point1 = new Point(1.2, 2.3, 3.1);
			Point point2 = new Point(1.2, 2.3, 3.1);
			assertTrue(point1.equals(point2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Point.equals: unequal points - FAIL
	*/
	@Test
	public void test_Point_equals_02() {
		try {
			Point point1 = new Point(1.2, 2.3, 3.1);
			Point point2 = new Point(1.1, 2.2, 3.3);
			assertFalse(point1.equals(point2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Point.equals: incorrect object - FAIL
	*/
	@Test
	public void test_Point_equals_03() {
		try {
			Point point1 = new Point(1.2, 2.3, 3.1);
			assertFalse(point1.equals("tester"));
		}
		catch (Exception e) {
			fail();
		}
	}

	/**
	 * check Point.distance: equal points - PASS
	*/
	@Test
	public void test_Point_distance_01() {
		try {
			Point point1 = new Point(1.2, 2.3, 3.1);
			Point point2 = new Point(1.2, 2.3, 3.1);
			assertTrue(0 == point1.distance(point2));
		}
		catch (Exception e) {
			fail();
		}
	}

	/**
	 * check Point.distance: different points - PASS
	*/
	@Test
	public void test_Point_distance_02() {
		try {
			Point point1 = new Point(1, 2, 0);
			Point point2 = new Point(1, 2, 5);
			assertTrue(5 == point1.distance(point2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Point.distance - FAIL
	*/
	@Test
	public void test_Point_distance_03() {
		try {
			Point point1 = new Point(1, 2, 0);
			Point point2 = new Point(1, 2, 3);
			assertFalse(0 == point1.distance(point2));
		}
		catch (Exception e) {
			fail();
		}
	}

	/**
	 * check Face.constructor - PASS
	*/
	@Test
	public void test_Face_01() {
		try {
			Point point1 = new Point(1, 2, 3);
			Point point2 = new Point(3, 1, 2);
			Point point3 = new Point(2, 3, 1);
			Face face = new Face(point1, point2, point3);
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.constructor: zero area - FAIL
	*/
	@Test
	public void test_Face_02() {
		try {
			Point point1 = new Point(0, 0, 0);
			Point point2 = new Point(0, 0, 0);
			Point point3 = new Point(0, 0, 0);
			Face face = new Face(point1, point2, point3);
		}
		catch (FaceException e) {
			assertEquals("A face can't have a zero area", e.getMessage()); // passes
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.constructor: not equidistant points - FAIL
	*/
	@Test
	public void test_Face_03() {
		try {
			Point point1 = new Point(1, 2, 3);
			Point point2 = new Point(3, 1, 2);
			Point point3 = new Point(3, 3, 3);
			Face face = new Face(point1, point2, point3);
		}
		catch (FaceException e) {
			assertEquals("Points must be equidistant", e.getMessage()); // passes
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.toString - PASS
	*/
	@Test
	public void test_Face_toString() {
		try {
			Point point1 = new Point(1, 2, 3);
			Point point2 = new Point(3, 1, 2);
			Point point3 = new Point(2, 3, 1);
			Face face = new Face(point1, point2, point3);
			assertEquals("[{1.0,2.0,3.0}-{3.0,1.0,2.0}-{2.0,3.0,1.0}]", face.toString());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.equals: equal faces - PASS
	*/
	@Test
	public void test_Face_equals_01() {
		try {
			Point point1 = new Point(1, 2, 3);
			Point point2 = new Point(3, 1, 2);
			Point point3 = new Point(2, 3, 1);
			Face face1 = new Face(point1, point2, point3);
			Point pointA = new Point(1, 2, 3);
			Point pointB = new Point(3, 1, 2);
			Point pointC = new Point(2, 3, 1);
			Face face2 = new Face(pointA, pointB, pointC);
			assertTrue(face1.equals(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.equals: unequal faces - FAIL
	*/
	@Test
	public void test_Face_equals_02() {
		try {
			Point point1 = new Point(1, 2, 3);
			Point point2 = new Point(3, 1, 2);
			Point point3 = new Point(2, 3, 1);
			Face face1 = new Face(point1, point2, point3);
			Point pointA = new Point(0, 0, 0);
			Point pointB = new Point(1, 1, 1);
			Point pointC = new Point(2, 2, 2);
			Face face2 = new Face(pointA, pointB, pointC);
			assertFalse(face1.equals(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.equals: incorrect object - FAIL
	*/
	@Test
	public void test_Face_equals_03() {
		try {
			Point point1 = new Point(1, 2, 3);
			Point point2 = new Point(3, 1, 2);
			Point point3 = new Point(2, 3, 1);
			Face face = new Face(point1, point2, point3);
			assertFalse(face.equals("tester"));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.adjacent - PASS
	*/
	@Test
	public void test_Face_adjacent_01() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 0, 0);
			Point point3 = new Point(2, 1, 0);
			Face face1 = new Face(point1, point2, point3);
			Point pointA = new Point(1, 0, 0);
			Point pointB = new Point(2, 0, 1);
			Point pointC = new Point(2, 1, 0);
			Face face2 = new Face(pointA, pointB, pointC);
			assertTrue(face1.adjacent(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.adjacent: same faces - FAIL
	*/
	@Test
	public void test_Face_adjacent_02() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 0, 0);
			Point point3 = new Point(0, 1, 0);
			Face face1 = new Face(point1, point2, point3);
			Point pointA = new Point(1, 1, 1);
			Point pointB = new Point(1, 0, 0);
			Point pointC = new Point(0, 1, 0);
			Face face2 = new Face(pointA, pointB, pointC);
			assertFalse(face1.adjacent(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.adjacent: no adjacent edge - FAIL
	*/
	@Test
	public void test_Face_adjacent_03() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 0, 0);
			Point point3 = new Point(0, 1, 0);
			Face face1 = new Face(point1, point2, point3);
			Point pointA = new Point(2, 2, 2);
			Point pointB = new Point(2, 1, 1);
			Point pointC = new Point(1, 2, 1);
			Face face2 = new Face(pointA, pointB, pointC);
			assertFalse(face1.adjacent(face2));
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.edge - PASS
	*/
	@Test
	public void test_Face_edge() {
		try {
			Point point1 = new Point(3, 3, 3);
			Point point2 = new Point(3, 0, 0);
			Point point3 = new Point(0, 3, 0);
			Face face1 = new Face(point1, point2, point3);
			assertTrue(Math.sqrt(18) == face1.edge());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.area - PASS
	*/
	@Test
	public void test_Face_area_01() {
		try {
			Point point1 = new Point(3, 3, 3);
			Point point2 = new Point(3, 0, 0);
			Point point3 = new Point(0, 3, 0);
			Face face = new Face(point1, point2, point3);
			assertTrue((Math.sqrt(3) / 4) * Math.pow(face.edge(),2) == face.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Face.area - PASS
	*/
	@Test
	public void test_Face_area_02() {
		try {
			Point point1 = new Point(2, 2, 2);
			Point point2 = new Point(2, 4, 4);
			Point point3 = new Point(4, 2, 4);
			Face face = new Face(point1, point2, point3);
			assertTrue((Math.sqrt(3) / 4) * Math.pow(face.edge(),2) == face.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Tetrahedron.constructor - PASS
	*/
	@Test
	public void test_Tetrahedron_01() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 0, 0);
			Point point3 = new Point(2, 1, 0);
			Point point4 = new Point(2, 0, 1);
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
	 * check Tetrahedron.constructor: 2 equal faces - FAIL
	*/
	@Test
	public void test_Tetrahedron_02() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 0, 0);
			Point point3 = new Point(2, 1, 0);
			Point point4 = new Point(2, 0, 1);
			Face face1 = new Face(point1, point2, point3);
			Face face2 = new Face(point2, point3, point4);
			Face face3 = new Face(point3, point4, point1);
			Face face4 = new Face(point3, point4, point1);
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
	 * check Tetrahedron.constructor: no adjacent sides - FAIL
	*/
	@Test
	public void test_Tetrahedron_03() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 3, 3);
			Point point3 = new Point(3, 1, 3);
			Point point4 = new Point(3, 3, 1);
			Face face1 = new Face(point1, point2, point3);
			Face face2 = new Face(point2, point3, point4);
			Face face3 = new Face(point3, point4, point1);
			Point pointA = new Point(3, 3, 3);
			Point pointB = new Point(3, 1, 1);
			Point pointC = new Point(5, 3, 1);
			Face face4 = new Face(pointA, pointB, pointC);
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
	 * check Tetrahedron.constructor w/ points - PASS
	*/
	@Test
	public void test_Tetrahedron_wPoints_01() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 3, 3);
			Point point3 = new Point(3, 1, 3);
			Point point4 = new Point(3, 3, 1);
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Tetrahedron.constructor w/ points: 2 equal points - FAIL
	*/
	@Test
	public void test_Tetrahedron_wPoints_02() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 3, 3);
			Point point3 = new Point(3, 1, 3);
			Point point4 = new Point(3, 1, 3);
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
		}
		catch (TetrahedronException te) {
			assertEquals("The four faces do not form a tetrahedron", te.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Tetrahedron.constructor w/ points: different side lengths - FAIL
	*/
	@Test
	public void test_Tetrahedron_wPoints_03() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 3, 3);
			Point point3 = new Point(3, 1, 3);
			Point point4 = new Point(2, 2, 2);
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
		}
		catch (TetrahedronException te) {
			assertEquals("The four faces do not form a tetrahedron", te.getMessage());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Tetrahedron.area - PASS
	*/
	@Test
	public void test_Tetrahedron_area_01() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 0, 0);
			Point point3 = new Point(2, 1, 0);
			Point point4 = new Point(2, 0, 1);
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
	 * check Tetrahedron.area: with points - PASS
	*/
	@Test
	public void test_Tetrahedron_area_02() {
		try {
			Point point1 = new Point(3, 3, 3);
			Point point2 = new Point(3, 1, 1);
			Point point3 = new Point(5, 3, 1);
			Point point4 = new Point(5, 1, 3);
//			Face face1 = new Face(point1, point2, point3);
//			Face face2 = new Face(point2, point3, point4);
//			Face face3 = new Face(point3, point4, point1);
//			Face face4 = new Face(point4, point1, point2);
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
			assertTrue(((Math.sqrt(3)/4) * Math.pow(point1.distance(point2), 2)) * 4 == tetrahedron.area());
		}
		catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * check Tetrahedron.volume - PASS
	*/
	@Test
	public void test_Tetrahedron_volume_01() {
		try {
			Point point1 = new Point(3, 3, 3);
			Point point2 = new Point(3, 1, 1);
			Point point3 = new Point(5, 3, 1);
			Point point4 = new Point(5, 1, 3);
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
	
	/**
	 * check Tetrahedron.volume: with points - PASS
	*/
	@Test
	public void test_Tetrahedron_volume_02() {
		try {
			Point point1 = new Point(1, 1, 1);
			Point point2 = new Point(1, 0, 0);
			Point point3 = new Point(2, 1, 0);
			Point point4 = new Point(2, 0, 1);
			Tetrahedron tetrahedron = new Tetrahedron(point1, point2, point3, point4);
			assertTrue((Math.pow(point1.distance(point2), 3)) / (6 * Math.sqrt(2)) == tetrahedron.volume());
		}
		catch (Exception e) {
			fail();
		}
	}
}