package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value={
		AccessRightsTest.class, 
		CartesianCoordinateTest.class,
		FlagReasonTest.class,
		GenderTest.class,
		GuestTest.class,
		PhotoFilterTest.class,
		TagsTest.class,
		UserStatusTest.class,
		ValueTest.class,
		SphericCoordinate.class,
		CartesianCoordinate.class,
		CoordinateConvertService.class
})


public class ModelSuite {

}
