package org.wahlzeit.model;

/**
 * Common Interface for coordinates.
 *
 */
public interface Coordinate {
	
	/**
	 * Calculate distance between two coordinates.
	 * 
	 * @param other
	 * @throws IllegalArgumentException
	 * @return distance in km.
	 * @throws CoordinateException when some exception during coordination handling occurred.
	 */
	double getDistance(Coordinate other) throws CoordinateException;
	
	
	/**
	 * Checks that the given coordinate is equal.
	 * 
	 * @param other some other coordinate instance.
	 * @return TRUE / FALSE.
	 * @throws CoordinateException  when some exception during coordination handling occurred.
	 */
	boolean isEqual(Coordinate other) throws CoordinateException;

}
