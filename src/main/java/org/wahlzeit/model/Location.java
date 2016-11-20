package org.wahlzeit.model;

public class Location {
	
	private final Coordinate coordinate;
	
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
