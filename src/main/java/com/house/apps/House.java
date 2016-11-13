/**
 * 
 */
package com.house.apps;

import javax.servlet.ServletContextEvent;

import org.wahlzeit.apps.Wahlzeit;

import com.house.main.HouseMain;
import com.house.model.HousePhotoFactory;

/**
 * Listener to startup and shutdown the FamilyHome application.
 */
public class House extends Wahlzeit {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HouseMain.initialize();
		super.contextInitialized(sce);
	}
}
