package org.wahlzeit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.HadlersSuite;
import org.wahlzeit.main.ServiceMain;
import org.wahlzeit.model.ModelSuite;
import org.wahlzeit.model.persistence.PersistenceSuite;
import org.wahlzeit.services.ServicesSuite;
import org.wahlzeit.services.mailing.ServicesMailingSuite;
import org.wahlzeit.utils.UtilsSuite;



@RunWith(value=Suite.class)
@SuiteClasses(value={
		HadlersSuite.class,
		ModelSuite.class,
		PersistenceSuite.class,
		ServicesSuite.class,
		ServicesMailingSuite.class,
		UtilsSuite.class
	
})
public class WahlzeitTestSuit {

	private static class ServiceMainExchanger extends ServiceMain {
		private static ServiceMain original = ServiceMain.getInstance();
		private static ServiceMain me = new ServiceMainExchanger();
		
		/**
		 * set isInProduction to false in ServiceMainExchanger
		 * for using in test case
		 */
		private ServiceMainExchanger() { 
			isInProduction = false;
		}
		
		/**
		 * prepares all test for execution
		 */
		private static void prepare() {
			ServiceMain.instance = me;
		}
		
		/**
		 * cleans up all the prepared states
		 */
		private static void cleanup() {
			ServiceMain.instance = original;
		}
	}
	
	
	/**
	 * 
	 */
	@BeforeClass
	public static void prepare() {
llpö´ä-		ServiceMainExchanger.prepare();
	}
	
	/**
	 * 
	 */
	@AfterClass
	public static void cleanup() {
		ServiceMainExchanger.cleanup();
	}
}
