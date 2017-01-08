/**
 * 
 */
package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
		patternName = "Flyweight",
		participants = {"FlyweightFactory"}
		)
		
/**
 * CoordinateCreationService
 *
 */
public class CoordinateCreationService {
	
		
	/**
	 * Enumerates supported coordinate types.
	 */
	public static enum CoordinateType {
		SPHERICAL {
			@Override
			Coordinate create(double arg1, double arg2, double arg3) {
				return new SphericCoordinate(arg1, arg2, arg3);
			}
		}, 
		CARTESIAN {
			@Override
			Coordinate create(double arg1, double arg2, double arg3) {
				return new CartesianCoordinate(arg1, arg2, arg3);
			}
		};
		
		/**
		 * Gives an instance of {@link CoordinateType} according to the string represented name.
		 * @param name
		 * @return coordinate type
		 * @throws CoordinateException
		 */
		public static CoordinateType fromString(String name) throws CoordinateException {
			CoordinateType coordinateType = valueOf(name.toUpperCase());
			if (coordinateType == null) {
				
				throw new CoordinateException(new NullPointerException());
			}
			return coordinateType;
		}
		
		Coordinate create(double arg1, double arg2, double arg3) {
			throw new UnsupportedOperationException("Unsupported coordinate type.");
		}
	}
	
	Map<CoordinateType, Map<double[],Coordinate>> coordinateTypeMap = new HashMap<>();
	
	private static CoordinateCreationService instance;
		
	private CoordinateCreationService() { }
	
	public static CoordinateCreationService getInstance() {
		if(instance == null)
			instance = new CoordinateCreationService();
		return instance;			
	}
	
	/**
	 * Creates a new coordinate from the given string represented values.
	 * 
	 * 
	 * 
	 * @param type the Type.
	 * @param values the Values. 
	 * @return the new instance.
	 * 
	 */
	public Coordinate create(CoordinateType type, double arg1, double arg2, double arg3) {
		Map<double[], Coordinate> coordinateMap = coordinateTypeMap.get(type);
		if (coordinateMap == null) {
			coordinateMap = new HashMap<>();
			coordinateTypeMap.put(type, coordinateMap);
		}
		
		double[] key = {arg1, arg2, arg3};
		Coordinate coordinate = coordinateMap.get(key);
		if (coordinate == null) {
			coordinate = type.create(arg1, arg2, arg3);
			coordinateMap.put(key, coordinate);
		}
		return coordinate;
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
