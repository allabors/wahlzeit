package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {
	
	private SphericCoordinate loc1sp;
	private SphericCoordinate loc2sp;
	
	private CartesianCoordinate loc2cart;
	
	@Before
	public void setUp() throws Exception {
		loc1sp = new SphericCoordinate(64.28, 100.22);
		loc2sp = new SphericCoordinate(40.71, -74.01);
		
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
		new SphericCoordinate(187, 0);		
	}

	/**
	 * Tests illegal value for longitude
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalLongtitude() {
		new SphericCoordinate(300,-124);		
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(loc1sp.getDistance(loc2sp), 8335, 10);
		assertEquals(loc1sp.getDistance(loc2cart), 8335, 10);
	}

}
