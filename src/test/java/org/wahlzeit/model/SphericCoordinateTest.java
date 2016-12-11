package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {
	
	private final static double EPSILON = 0.01;
	private SphericCoordinate loc1sp;
	private SphericCoordinate loc2sp;
	
	private CartesianCoordinate loc1cart;
	private CartesianCoordinate loc2cart;
	
	@Before
	public void setUp() throws Exception {
		loc1sp = new SphericCoordinate(64.28, 100.22, SphericCoordinate.EARTH_RADIUS);
		loc2sp = new SphericCoordinate(40.71, -74.01, SphericCoordinate.EARTH_RADIUS);
		
		loc1cart = new CartesianCoordinate(-490.56, 2720.98, 5739.80);
		loc2cart = new CartesianCoordinate(1330.34, -4642.5 , 4155.36);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests illegal value for latitude
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalLatitude() {
		new SphericCoordinate(187, 0, SphericCoordinate.EARTH_RADIUS);		
	}

	/**
	 * Tests illegal value for longitude
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalLongtitude() {
		new SphericCoordinate(300, -124, SphericCoordinate.EARTH_RADIUS);		
	}
	
	@Test
	public void testGetDistance() throws CoordinateException {
		assertEquals(loc1sp.getDistance(loc2sp), 7748.997, EPSILON);
		assertEquals(loc1sp.getDistance(loc2cart), 7748.997, EPSILON);
		// An idea for isEqual method, the distance between same coordinates
	    assertEquals(loc1sp.getDistance(loc1cart), 0, EPSILON);
	}

	/**
	 * Test isEqual for same type and two different types of coordinates
	 * @throws CoordinateException 
	 */
	@Test
	public void testIsEqual() throws CoordinateException {
		assertEquals(loc2sp.isEqual(loc2sp), true);
		assertEquals(loc2sp.isEqual(loc2cart), true);
		
		
	}
}
