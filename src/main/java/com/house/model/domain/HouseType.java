package com.house.model.domain;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;

/**
 * 
 * TypeClass for types of Houses
 *
 */

@Entity
public class HouseType extends DataObject{
	
	private String typeName;
	
	HouseType(String name){
		typeName = name;
	}
	
	/**
	 * 
	 * @return name of type
	 */
	public String getName(){
		return typeName;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof HouseType && typeName.equals(((HouseType)obj).typeName);
	}

}
