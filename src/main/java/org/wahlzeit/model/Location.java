package org.wahlzeit.model;

import com.house.model.collaborations.Collaborations;

@Collaborations(
		bindings = {
			"photo-location:type"
	})
public class Location {
	
	private final Coordinate coordinate;
	
	private Location() {
		coordinate = null;
	}
		
	/**
	 * Create object Location with given coordinates
	 * @param coordinate
	 */
	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	/**
	 * Get coordinates for Location
	 * @return coordinate from this location
	 */
	public Coordinate getCoordinate() {	
		return this.coordinate;
	}
	


}
