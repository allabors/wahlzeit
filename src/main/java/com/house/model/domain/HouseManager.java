package com.house.model.domain;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.services.ObjectManager;

public class HouseManager extends ObjectManager {
	
	private static HouseManager instance;
	private Map<String, HouseType> mapHouseTypes = new HashMap<String, HouseType>();
	
	private HouseManager(){
		
	}
	
	public static HouseManager getInstance(){
		if(instance == null){
			instance = new HouseManager();
		}
		return instance;
	}
	/**
	 * Create new House type
	 * @param typeName
	 * @return HouseType object
	 */
	public HouseType createType(String typeName){
		return addHouseType(new HouseType(typeName));
	}
	
	public HouseType addHouseType(HouseType type){
		if(!mapHouseTypes.containsKey(type.getName()))
			mapHouseTypes.put(type.getName(), type);
		else
			type = mapHouseTypes.get(type.getName());
			return type;
	}
	/**
	 * Create House with appropriate HouseType
	 * @param typeName
	 * @param area
	 * @return House object
	 */
	public House createHouse(HouseType typeName, double area){
		return new House(mapHouseTypes.get(typeName.getName()), area);
	}
		
	/**
	 * Saves an Object House
	 * @param houseType
	 */
	public void saveHouse(House house){
		writeObject(house);
	}
}
