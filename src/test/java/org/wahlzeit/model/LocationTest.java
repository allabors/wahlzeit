package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.Coordinate;
import org.wahlzeit.model.Location;

public class LocationTest {

	private Location loc1;
	private Location loc2;
	
	@Before
	public void setUp() throws Exception {
		loc1 = new Location(new Coordinate(64.28, 100.22));
		loc2 = new Location(new Coordinate(40.71, -74.01));
	}

	@After
	public void tearDown() throws Exception {
		loc1 = null;
		loc2 = null;
	}

	/**
	 * Tests calculation distance for two location
	 */
	@Test
	public void testGetDistance() {
		assertEquals(loc1.getDistance(loc2), 8335, 10);
	}

}
