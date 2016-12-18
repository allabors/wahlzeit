package org.wahlzeit.model;

/**
 * Serves to represent Runtime-Exceptions occurring when coordinate handling is faulty.
 */
public class CoordinateRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public CoordinateRuntimeException() {
		super("The coordinate handling is faulty.");
	}
	
	/**
	 * Constructor
	 * @param throwable origin throwable.
	 */
	public CoordinateRuntimeException(Throwable throwable) {
		super(throwable);
	}
	
	/**
	 * Constructor
	 * @param message the message.
	 */
	public CoordinateRuntimeException(String message) {
		super(message);
	}
	
}
