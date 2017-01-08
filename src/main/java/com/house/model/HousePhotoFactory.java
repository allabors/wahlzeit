/**
 * 
 */
package com.house.model;

import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.OfyService;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
		patternName = "Abstract Factory",
		participants = {"ConcreteFactory"}
		)

/**
 * An Abstract Factory for creating photos.
 * 
 */
public class HousePhotoFactory extends PhotoFactory {

	/**
	 * Replacing PhotoFactory with HousePhotoFactory to change the default factory for creating photos
	 * Registers class HousePhoto
	 */
	public static void init() {
		OfyService.factory().register(HousePhoto.class);
		setInstance(new HousePhotoFactory());
	}
	
	@Override
	public HousePhoto createPhoto() {
		return new HousePhoto();
	}
	
	@Override
	public HousePhoto createPhoto(PhotoId id) {
		return new HousePhoto(id);
	}
}


