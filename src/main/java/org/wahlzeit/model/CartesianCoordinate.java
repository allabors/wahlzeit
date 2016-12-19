/**
 * 
 */
package org.wahlzeit.model;

import java.util.Objects;

/**
 * This class serves as a base for cartesian coordinate computations.
 *
 */
public final class CartesianCoordinate extends AbstractCoordinate {

	private final double x;
	private final double y;
	private final double z;
	
private class CartesianInvariant extends AbstractCoordinate.Invariant {
		
		// Save the SphericCoordinate's state
		private final double x = CartesianCoordinate.this.x;
		private final double y = CartesianCoordinate.this.y;
		private final double z = CartesianCoordinate.this.z;
		
		@Override
		protected void check() {

			assert x == CartesianCoordinate.this.x
					&& y == CartesianCoordinate.this.y
					&& z == CartesianCoordinate.this.z
				: "The Coordinate state is invalid.";
		}
	}
	CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		//Class invariant
		new CartesianInvariant().check();
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

	@Override
	protected Invariant getInvariant() {
		return new CartesianInvariant();
	}

	public int toHash() {
		return Objects.hash(x, y, z);
	}
}
