package com.house.model;

import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.house.main.HouseMain;

public class HousePhotoFactoryTest {
	
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());
	
	@Before
	public void setUp() {
		HouseMain.initialize();
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void housePhotoCreatedByPhotoFactory() {
		PhotoId nextId = PhotoId.getNextId();
		Photo testphoto = PhotoFactory.getInstance().createPhoto(nextId);
		assertThat(testphoto, IsInstanceOf.instanceOf(HousePhoto.class));
	}
}
