/**
 * 
 */
package org.wahlzeit.model;

/**
 * Singleton CoordinateCreationService
 *
 */
public class CoordinateCreationService {
	
	/**
	 * Enumerates supported coordinate types.
	 */
	public static enum CoordinateType {
		SPHERICAL, CARTESIAN;
		
		/**
		 * Gives an instance of {@link CoordinateType} according to the string represented name.
		 * @param name
		 * @return
		 * @throws CoordinateException
		 */
		public static CoordinateType fromString(String name) throws CoordinateException {
			CoordinateType coordinateType = valueOf(name.toUpperCase());
			if (coordinateType == null) {
				throw new CoordinateException(new NullPointerException());
			}
			return coordinateType;
		}
	}
	
	private static CoordinateCreationService instance;
		
	private CoordinateCreationService() { }
	
	public static CoordinateCreationService getInstance() {
		if(instance == null)
			instance = new CoordinateCreationService();
		return instance;			
	}
	
	/**
	 * Creates a new coordinate from the given string represented values.
	 * @param type the Type.
	 * @param values the Values. 
	 * @return the new instance.
	 * @throws CoordinateException 
	 */
	public Coordinate create(CoordinateType type, String... values) throws CoordinateException {
		try {
			switch (type) {
			case CARTESIAN:
				return new CartesianCoordinate(
						Double.parseDouble(values[0].trim()),
						Double.parseDouble(values[1].trim()),
						Double.parseDouble(values[2].trim()));
			case SPHERICAL:
				return new SphericCoordinate(
						Double.parseDouble(values[0].trim()),
						Double.parseDouble(values[1].trim()),
						SphericCoordinate.EARTH_RADIUS);
			default:
				throw new IllegalArgumentException(String.format("The coordinate-type '%s' is unknown.", values[0]));
			}
		} catch (Exception ex) {
			throw new CoordinateException(ex);
		}
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
