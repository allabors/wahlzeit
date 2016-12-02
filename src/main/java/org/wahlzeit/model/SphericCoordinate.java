/**
 * 
 */
package org.wahlzeit.model;

/**
 * This class serves as a base for spherical coordinate computations.
 *
 */
public class SphericCoordinate extends AbstractCoordinate {
	
	public static final double EARTH_RADIUS = 6371;
	private final double radius;
	private final double latitude;
	private final double longitude;
	
	/**
	 * Create Coordinate object with given latitude and longitude
	 * @param latitude
	 * @param longtitude
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException("Latitude should be between -90 and 90");
		}
		if (longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException("Longtitude should be between -180 and 180");
		}
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	/**
	 * Returns the latitude of a coordinate.
	 * @return the latitude.
	 */
	public double getLatitude(){
		return latitude;
	}
	
	/**
	 * @return the longitude
	 */
	public double getLongitude(){
		return longitude;
	}
	
	/**
	 * @return the radius
	 */
	public double getRadius(){
		return radius;
	}

	/**
	 * Calculate distance between two spherical coordinate
	 * 
	 * @param other
	 * @return distance in km.
	 */
	@Override
	public double getDistance(Coordinate other) {
		
		DistanceComputation computation = DistanceComputation.getInstance();
					
	/*	getDistance for spherical coordinate version 1.0
		double deltaPhi = Math.abs(Math.toRadians(this.latitude) - Math.toRadians(spheric.latitude));
		double deltaLa = Math.abs(Math.toRadians(this.longitude) - Math.toRadians(spheric.longitude));
		double deltaSigma = 2 * Math.asin( Math.sqrt( Math.pow(Math.sin(deltaPhi/2), 2) + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(spheric.latitude)) * Math.pow(Math.sin(deltaLa/2), 2)));
		return EARTH_RADIUS * deltaSigma;			
	*/
		double distance = computation.getDistance(this, other);
		return distance;
		
	}
	
	
	

}
