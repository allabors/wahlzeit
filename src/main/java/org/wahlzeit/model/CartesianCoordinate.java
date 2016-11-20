/**
 * 
 */
package org.wahlzeit.model;

/**
 * This class serves as a base for cartesian coordinate computations.
 *
 */
public class CartesianCoordinate implements Coordinate {

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
		
		CoordinateConvertService converter = CoordinateConvertService.getInstance();
		
		CartesianCoordinate cartesian = converter.convertToCartesian(other);
		
		double distance = Math.sqrt(Math.pow(cartesian.x-this.x, 2) + Math.pow(cartesian.y - this.y, 2) + Math.pow(cartesian.z - this.z, 2));
		return distance;
	}

}
