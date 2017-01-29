package com.house.model.collaborations;

/**
 * Serves as a description method for objects participating in a
 * collaboration.
 */
public @interface Collaborations {
	
	/**
	 * @return all bindings for the annotated type in format '&ltcollaboration-name&gt:&ltrole-name&gt'
	 */
	String[] bindings();
}
