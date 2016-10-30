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
	
	/**
	 * Calculate distance between two location
	 * @param otherLocation
	 * @return distance in km.
	 */
	public double getDistance(Location otherLocation) {
		double deltaPhi = Math.abs(getCoordinate().getLatitudeInRadian() - otherLocation.getCoordinate().getLatitudeInRadian());
		double deltaLa = Math.abs(getCoordinate().getLongitudeInRadian() - otherLocation.getCoordinate().getLongitudeInRadian());
		double deltaSigma = 2 * Math.asin(Math.sqrt((Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) +
				Math.cos(getCoordinate().getLatitudeInRadian()) * Math.cos(otherLocation.getCoordinate().getLatitudeInRadian()) *
				Math.sin(deltaLa / 2) * Math.sin(deltaLa / 2))));
		return Coordinate.RADIUS * deltaSigma;
	
	}


}
