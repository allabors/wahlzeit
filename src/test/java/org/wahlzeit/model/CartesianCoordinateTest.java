package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartesianCoordinateTest {

	private CartesianCoordinate loc1cart;
	private CartesianCoordinate loc2cart;
	
	@Before
	public void setUp() throws Exception {
		loc1cart = new CartesianCoordinate(-490.56, 2720.98, 5739.80);
		loc2cart = new CartesianCoordinate(1330.34, -4642.5, 4155.36);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(loc1cart.getDistance(loc2cart), 7750, 10);
	}             
}
