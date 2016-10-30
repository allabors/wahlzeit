package org.wahlzeit.model;


/**
 * This class serves as a base for coordinate computations.
 *
 */
public class Coordinate {
	
	/**
	 * Earths radius
	 */
	public static double RADIUS = 6371;
	
	private final double latitude;
	private final double longitude;
	
	/**
	 * Create Coordinate object with given latitude and longitude
	 * @param latitude
	 * @param longtitude
	 */
	public Coordinate(double latitude, double longitude) {
		
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException("Latitude should be between -90 and 90");
		}
		if (longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException("Longtitude should be between -180 and 180");
		}
		
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	/**
	 * Returns the latitude of a coordinate.
	 * @return the latitude.
	 */
	public double getLatitudeInRadian(){
		return calculateInRadian(latitude);
	}


	/**
	 * Calculate variable in radians
	 * @param param
	 * @return
	 */
	private double calculateInRadian(double param) {
		return param * Math.PI / 180;
	}
	
	/**
	 * @return the longitude
	 */
	public double getLongitudeInRadian(){
		return calculateInRadian(longitude);
	}

}
