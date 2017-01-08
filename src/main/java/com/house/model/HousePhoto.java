/**
 * 
 */
package com.house.model;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.utils.PatternInstance;

import com.googlecode.objectify.annotation.Subclass;

@PatternInstance(
		patternName = "AbstractFactory",
		participants = {"ConcreteProduct"}
		)


/**
 * A housephoto represents a uploaded photo for FamilyHome.
 */
@Subclass
public class HousePhoto extends Photo {
	
	private static final long serialVersionUID = 7070186052793618556L;

	HousePhoto() {
		super();
	}

	HousePhoto(PhotoId myId) {
		super(myId);
	}
}
