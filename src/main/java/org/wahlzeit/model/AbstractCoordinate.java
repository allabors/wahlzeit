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
	 * 
	 *
	 */
	protected abstract class Invariant {
		/**
		 * 
		 */
		protected abstract void check();
	}
	
	@Override
	public final double getDistance(Coordinate other) {
		//precondition in public method
		if (other == null)
			throw new IllegalArgumentException("Second coordinate can not be null!");

		Invariant invariant = getInvariant();
		
		DistanceComputation computation = DistanceComputation.getInstance();	
		double distance = computation.getDistance(this, other);
		
		invariant.check();
		
		//postcondition in public method
		assert distance >= 0 : "The calculated distance may not be less than zero";
		
		return distance;
	}
	
	/**
	 * Gives an invariant instance for the check if it fulfills after some modification method. 
	 * @return an invariant instance.
	 */
	protected abstract Invariant getInvariant();
		
	/**
	 * The distance between two same coordinates is always zero. Based on this assumption
	 * checks this implementation the equality.
	 * A possible deviation can not be greater than 0.01.
	 * 
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public final boolean isEqual(Coordinate other) {
		
		return this.getDistance(other) <= 0.01 ;
	}
}
