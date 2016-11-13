/**
 * 
 */
package com.house.main;

import org.wahlzeit.main.ServiceMain;

import com.house.model.HousePhotoFactory;

/**
 * A Main class that runs a Wahlzeit-FamilyHome web server extends from ServiceMain
 */
public class HouseMain extends ServiceMain {
	public static void initialize() {
		ServiceMain.instance = new HouseMain();
		HousePhotoFactory.init();
	}
}
