package org.wahlzeit.model.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value={
		AbstractAdapterTest.class,
		DatastoreAdapterTest.class,
		GcsAdapterTest.class
})

public class PersistenceSuite {

}
