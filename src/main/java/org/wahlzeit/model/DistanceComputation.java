package org.wahlzeit.model;

public class DistanceComputation {
	
	private static DistanceComputation instance;
	
	private DistanceComputation() { }
	
	public static DistanceComputation getInstance() {
		if(instance == null)
			instance = new DistanceComputation();
		return instance;
	}
	/**
	 * Calculate the shortest distance between two coordinates,
	 * first use {@link CoordinateCreationService} to convert coordinates to {@link CartesianCoordinate}
	 * and than calculate shortest distance
	 * @param first coordinate
	 * @param second coordinate
	 * @return distance in km
	 */
	public double getDistance(Coordinate first, Coordinate second) {
		CoordinateCreationService convertService = CoordinateCreationService.getInstance();
		CartesianCoordinate cartesianFirst = convertService.convertToCartesian(first);
		CartesianCoordinate cartesianSecond = convertService.convertToCartesian(second);
		
		return Math.sqrt(Math.pow(cartesianSecond.getX() - cartesianFirst.getX(), 2) + 
				Math.pow(cartesianSecond.getY() - cartesianFirst.getY(), 2) + 
				Math.pow(cartesianSecond.getZ() - cartesianFirst.getZ(), 2));
	}
	
	

}
