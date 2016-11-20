package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoordinateConvertServiceTest {
	
	static CoordinateConvertService instance;

	CartesianCoordinate loc1cart;
	CartesianCoordinate loc2cart;
	SphericCoordinate loc1sp;
	SphericCoordinate loc2sp;

	@Before
	public void setUp() throws Exception {
		instance = CoordinateConvertService.getInstance();
		loc1cart = new CartesianCoordinate(-490.56, 2720.98, 5739.80);
		loc2cart = new CartesianCoordinate(1330.34, -4642.5, 4155.36);
		loc1sp = new SphericCoordinate(64.28, 100.22);
		loc2sp = new SphericCoordinate(40.71, -74.01);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToSpheric() {
		SphericCoordinate sphresult = instance.convertToSpheric(loc1cart);
		assertEquals(sphresult.getLatitude(), 64.28, 1);
		assertEquals(sphresult.getLongitude(), 100.22, 1);
		
		sphresult = instance.convertToSpheric(loc2cart);
		assertEquals(sphresult.getLatitude(), 40.71, 1);
		assertEquals(sphresult.getLongitude(), -74.01, 1);
		
		
	}
	
	@Test
	public void testConvertToCartesian() {
		CartesianCoordinate cartresult = instance.convertToCartesian(loc1sp);
		assertEquals(cartresult.getX(), -490.56, 1);
		assertEquals(cartresult.getY(), 2720.98, 1);
		assertEquals(cartresult.getZ(), 5739.80, 1);
		
		cartresult = instance.convertToCartesian(loc2sp);
		assertEquals(cartresult.getX(), 1330.34, 1);
		assertEquals(cartresult.getY(), -4642.5, 1);
		assertEquals(cartresult.getZ(), 4155.36, 1);
		
		
	}

}
