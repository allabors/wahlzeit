/**
 * 
 */
package org.wahlzeit.model;

/**
 * This class serves as a base for cartesian coordinate computations.
 *
 */
public class CartesianCoordinate extends AbstractCoordinate {

	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	/**
	 * calculate shortest distance between two point
	 */
	@Override
	public double getDistance(Coordinate other) {
		
		DistanceComputation instance = DistanceComputation.getInstance();
		double distance = instance.getDistance(this, other);
		return distance;
	}
	

}
