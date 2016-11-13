package com.house;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.WahlzeitTestSuite;

import com.house.model.HousePhotoFactoryTest;

@RunWith(value=Suite.class)
@SuiteClasses(value={
		HousePhotoFactoryTest.class,
		WahlzeitTestSuite.class
	
})
public class HouseTestSuite {

}
