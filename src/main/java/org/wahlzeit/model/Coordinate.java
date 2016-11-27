package org.wahlzeit.model;

public interface Coordinate {
	
	double getDistance(Coordinate other);
	boolean isEqual(Coordinate other);

}
