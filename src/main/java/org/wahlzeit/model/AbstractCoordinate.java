/**
 * 
 */
package org.wahlzeit.model;

/**
 * Abstract Superclass for coordinates of various types
 *
 * 
 */
public abstract class AbstractCoordinate implements Coordinate {
	
	/**
	 * The distance between two same coordinates is always null
	 * A possible deviation can not be greater than 0.01  
	 */
	@Override
	public final boolean isEqual(Coordinate other) {
		
		return Math.abs(this.getDistance(other)) < 0.01 ;
	}
	
}
