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
	 */
	double getDistance(Coordinate other);
	
	
	/**
	 * Checks that the given coordinate is equal.
	 * 
	 * @param other some other coordinate instance.
	 * @return TRUE / FALSE.
	 */
	boolean isEqual(Coordinate other);

}
