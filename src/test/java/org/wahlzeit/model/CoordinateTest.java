package org.wahlzeit.model;

import org.junit.Test;

public class CoordinateTest {

	/**
	 * Tests illegal value for latitude
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalLatitude() {
		new Coordinate(187, 0);		
	}

	/**
	 * Tests illegal value for longitude
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalLongtitude() {
		new Coordinate(300,-124);		
	}
	
}
