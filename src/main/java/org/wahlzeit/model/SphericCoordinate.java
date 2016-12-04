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
	
	
	private class SphericInvariant extends AbstractCoordinate.Invariant {
		
		// Save the SphericCoordinate's state
		private final double radius = SphericCoordinate.this.radius;
		private final double latitude = SphericCoordinate.this.latitude;
		private final double longitude = SphericCoordinate.this.longitude;
		
				
		private boolean isValidLatitude() {
			return Math.abs(latitude) <= 90;
		}
		
		private boolean isValidLongitude() {
			return Math.abs(longitude) <= 180;
		}
		
		private boolean isValidRadius() {
			return radius > 0;
		}

		@Override
		protected void check() {

			assert radius == SphericCoordinate.this.radius
					&& latitude == SphericCoordinate.this.latitude
					&& longitude == SphericCoordinate.this.longitude;
			
			assert isValidLatitude() && isValidLongitude() && isValidRadius() :
				String.format(
						"The Coordinate state is invalid. Latitude is %s, Longitude is %s, Radius is %s ", 
						latitude, longitude, radius);
		}
	}
	
	/**
	 * Create Coordinate object with given latitude and longitude
	 * @param latitude
	 * @param longtitude
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		
				
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		//Class invariant
		new SphericInvariant().check();
	}
	
	/**
	 * Returns the latitude of a coordinate.
	 * @return the latitude.
	 */
	public double getLatitude(){
		return latitude;
	}
	
	/**
	 * Returns the longitude of a coordinate.
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

	@Override
	protected Invariant getInvariant() {
		return new SphericInvariant();
	}
}
