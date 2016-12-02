package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartesianCoordinateTest {
	
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
		loc2cart = new CartesianCoordinate(1330.34, -4642.5, 4155.36);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(loc1cart.getDistance(loc2cart), 7748.997, EPSILON);
		assertEquals(loc1cart.getDistance(loc2sp), 7748.997, EPSILON);
		
		assertEquals(loc2cart.getDistance(loc1cart), 7748.997, EPSILON);
		assertEquals(loc2cart.getDistance(loc1sp), 7748.997, EPSILON);
		
		assertEquals(loc1cart.getDistance(loc1cart), 0, EPSILON);
		assertEquals(loc1cart.getDistance(loc1sp), 0, EPSILON);
		
	} 
	/**
	 * Test isEqual for same type and two different types of coordinates
	 */
	@Test
	public void testIsEqual() {
		assertEquals(loc2cart.isEqual(loc2sp), true);
		assertEquals(loc2cart.isEqual(loc2cart), true);
		assertEquals(loc2cart.isEqual(loc1cart), false);
	}
		
}
