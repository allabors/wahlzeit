/**
 * 
 */
package com.house.model;

import org.wahlzeit.model.Location;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.utils.PatternInstance;

import com.googlecode.objectify.annotation.Subclass;
import com.house.model.collaborations.Collaborations;
import com.house.model.domain.House;


/**
 * A housephoto represents a uploaded photo for FamilyHome.
 */
@PatternInstance(
		patternName = "AbstractFactory",
		participants = {"ConcreteProduct"}
		)
@Collaborations(
		bindings = {
				"house-representation:photo",
				"photo-location:photo"
		})
@Subclass
public class HousePhoto extends Photo {
	
	private static final long serialVersionUID = 7070186052793618556L;
	private House house;
	private Location location;

	
	HousePhoto() {
		super();
	}

	HousePhoto(PhotoId myId) {
		super(myId);
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	/**
	 * @methodtype get
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @methodtype set
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}
