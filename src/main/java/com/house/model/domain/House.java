package com.house.model.domain;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;


@Entity
public class House extends DataObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HouseType houseType;
	private double area;
	
	public House(HouseType houseType, double area){
		this.houseType = houseType;
		this.area = area;
	}
	/**
	 * 
	 * @return area of house
	 */
	public double getArea(){
		return this.area;
	}
	/**
	 * 
	 * @return houseType
	 */
	public HouseType getHouseType(){
		return houseType;
	}
	
	public boolean isSubtype(HouseType houseType){
		return this.houseType.equals(houseType);
		
	}
}
