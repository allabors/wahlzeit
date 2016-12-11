package org.wahlzeit.model;

/**
 * Serves to represent Exceptions occurring when coordinate handling is faulty.
 */
public class CoordinateException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public CoordinateException() {
		super("The coordinate handling is faulty.");
	}
	
	/**
	 * Constructor
	 * @param throwable origin throwable.
	 */
	public CoordinateException(Throwable throwable) {
		super(throwable);
	}
	
	/**
	 * Constructor
	 * @param message the message.
	 */
	public CoordinateException(String message) {
		super(message);
	}
	
}
