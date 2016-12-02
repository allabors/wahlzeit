/**
 * 
 */
package org.wahlzeit.model;

//import static org.wahlzeit.model.SphericCoordinate.*;

/**
 * Singelton CoordinateConvertService
 *
 */
public class CoordinateConvertService {
	private static CoordinateConvertService instance;
		
	private CoordinateConvertService() { }
	
	public static CoordinateConvertService getInstance() {
		if(instance == null)
			instance = new CoordinateConvertService();
		return instance;			
	}
	
	/**
	 * convert cartesian to spherical
	 */
	public SphericCoordinate convertToSpheric(Coordinate other) {
		
		if(other instanceof CartesianCoordinate) {
			CartesianCoordinate cartesianCoordinate = (CartesianCoordinate) other;
			double radius = Math.sqrt(Math.pow (cartesianCoordinate.getX(), 2) + Math.pow(cartesianCoordinate.getY(), 2) + Math.pow(cartesianCoordinate.getZ(), 2));
			double latitude = Math.asin(cartesianCoordinate.getZ()/radius);
			double longitude = Math.atan2(cartesianCoordinate.getY(),cartesianCoordinate.getX());
			return new SphericCoordinate(Math.toDegrees(latitude), Math.toDegrees(longitude), radius);
		}
		return (SphericCoordinate) other;
		
		
	}
	
	/**
	 * convert spherical to cartesian
	 */
	public CartesianCoordinate convertToCartesian(Coordinate other) {
		
		if (other instanceof SphericCoordinate) {
			SphericCoordinate sphericCoordinate = (SphericCoordinate) other;
			double x = sphericCoordinate.getRadius()*Math.sin(Math.toRadians(90-sphericCoordinate.getLatitude()))*Math.cos(Math.toRadians(sphericCoordinate.getLongitude()));
			double y = sphericCoordinate.getRadius()*Math.sin(Math.toRadians(90-sphericCoordinate.getLatitude()))*Math.sin(Math.toRadians(sphericCoordinate.getLongitude()));
			double z = sphericCoordinate.getRadius()*Math.cos(Math.toRadians(90-sphericCoordinate.getLatitude()));
			return new CartesianCoordinate(x, y, z);
		}
		return (CartesianCoordinate) other;
	}

}
