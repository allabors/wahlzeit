package com.house.model.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;

/**
 * 
 * TypeClass for types of Houses
 *
 */

@Entity
public class HouseType extends DataObject{
	
	private static final long serialVersionUID = -6476129560396528002L;
	private String typeName;
	
	private final HouseType supertype;
	private final Set<HouseType> subtypes = new HashSet<>();
	
	/**
	 * Constructs a new {@link HouseType} with the given name and
	 * an optional supertype {@link HouseType}.
	 * @param name
	 * @param supertype
	 */
	HouseType(String name, HouseType supertype){
		typeName = name;
		if (supertype != null) {
			supertype.subtypes.add(this);
		}
		this.supertype = supertype;
	}
	
	/**
	 * Cretes a new {@link House} instance.
	 * @param area
	 * @return
	 */
	House newInstance(double area) {
		return new House(this, area);
	}
	
	/**
	 * Create new House type
	 * @param typeName
	 * @return HouseType object
	 */
	public HouseType createSubtype(String typeName) {
		return new HouseType(typeName, this);
	}
	
	/**
	 * Return TRUE if the given {@link HouseType} argument contains
	 * this {@link HouseType} in his subclass hierarchy.
	 * @param checkParent
	 * @return
	 */
	public boolean isSubtype(HouseType checkParent) {
		if (checkParent.subtypes.contains(this)) {
			return true;
		}
		for (HouseType houseType : checkParent.subtypes) {
			if (isSubtype(houseType)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retruns all direct subtypes.
	 * @return
	 */
	public Set<HouseType> getSubtypes() {
		return subtypes;
	}

	/**
	 * Returns a direct subtype with given name if such one is there.
	 * 
	 * @param subTypeName
	 * @return subtype.
	 */
	public HouseType getSubtype(String subTypeName) {
		for (HouseType houseType : subtypes) {
			if (Objects.equals(subTypeName, houseType.typeName)) {
				return houseType;
			}
		}
		return null;
	}
	
	/**
	 * Returns a supertype if any set.
	 * @return supertype.
	 */
	public HouseType getSupertype() {
		return supertype;
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
	
	@Override
	public int hashCode() {
		return typeName.hashCode();
	}
}
