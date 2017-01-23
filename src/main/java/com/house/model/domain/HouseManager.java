package com.house.model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.services.ObjectManager;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;

/**
 * Manages the objects life cycle of type {@link House} providing a generic
 * way to declare each {@link House} of a different "application" type {@link HouseType}
 * (according to the design pattern "type object") and to persist such objects via ofy-framework.
 * <p>Here are the main steps of this process:
 * <ol>
 * 	<li> {@link #createType(String)} + {@link #saveHouseType(HouseType)} or {@link #getHousetype(String)}
 * 	- create a new {@link HouseType} or get an existing one </li>
 *  <li> {@link #createHouse(double, HouseType)} - create a transient instance of {@link House} </li>
 *  <li> {@link #saveHouse(House)} persist a {@link House} </li>
 * </ol>
 * 
 * The Design-Space can of the object creation process  be summarized as follows:
 * 
 * <ul>
 * 	<li> Delegation : Abstract Factory, since to {@link PhotoFactory} delegated </li>
 *  <li> Selection : Prototype, since {@link HouseType} isn't really abstract like "Abstract Factory", but based on
 *  its nature creates a "prototyped" instance with no specific state in our case.</li>
 *  <li> Configuration : Factory Method if not considering persistence framework or Product Trader if 
 *  the persistence annotation "entity" some kind of configuration provides.
 *  </li>
 *  <li> Instantiation : Prototype. The argumentation is the same as for the selection.</li>
 *  <li> Initialization : Prototype. The argumentation is the same as for the selection.</li>
 *  <li> Building : Factory Method, since there is no specific structure building logic.</li>
 * </ul>
 */
public class HouseManager extends ObjectManager {
	
	private static HouseManager instance;
	private Set<HouseType> houseTypes = new HashSet<>();
	private Collection<House> houses;
	
	private HouseManager(){
		
	}
	
	public static HouseManager getInstance(){
		if(instance == null){
			instance = new HouseManager();
		}
		return instance;
	}
	
	/**
	 * Load all persisted data.
	 */
	public void load() {
		houses = ObjectifyService.run(new Work<Collection<House>>() {
			@Override
			public Collection<House> run() {
				Collection<House> existingHouses = new ArrayList<>();
				readObjects(existingHouses, House.class);
				return existingHouses;
			}
		});

		Collection<HouseType> existingHouseTypes = ObjectifyService.run(new Work<Collection<HouseType>>() {
			@Override
			public Collection<HouseType> run() {
				Collection<HouseType> existingHousesTypes = new ArrayList<>();
				readObjects(existingHousesTypes, HouseType.class);
				return existingHousesTypes;
			}
		});
		
		for (HouseType houseType : existingHouseTypes) {
			if (houseType.getSupertype() == null) {
				houseTypes.add(houseType);
			}
		}
	}
	
	/**
	 * Create new House type
	 * @param typeName
	 * @return HouseType object
	 */
	public HouseType createType(String typeName){
		return new HouseType(typeName, null);
	}
	
	/**
	 * Returns a {@link HouseType} with given name if such one is there.
	 * 
	 * @param typeName
	 * @return HouseType.
	 */
	public HouseType getHousetype(String typeName) {
		for (HouseType houseType : houseTypes) {
			if (Objects.equals(typeName, houseType.getName())) {
				return houseType;
			}
		}
		return null;
	}
	
	/**
	 * Returns all root {@link HouseType}-objects having no super type
	 * in their {@link HouseType} hierarchy.
	 * @return
	 */
	public Set<HouseType> getAllHouseTypes() {
		return houseTypes;
	}
	
	/**
	 * Saves an Object HouseType
	 * @param houseType
	 */
	public void saveHouseType(HouseType houseType){
		writeObject(houseType);
		// refresh cashed data...
		load();
	}
	
	/**
	 * Create House with appropriate HouseType
	 * @param area
	 * @param houseType
	 * @return House object
	 */
	public House createHouse(double area, HouseType houseType){
		return houseType.newInstance(area);
	}
	
	/**
	 * Returns all {@link House} objects.
	 * @return
	 */
	public Collection<House> getAllHouses() {
		return houses;
	}
	
	/**
	 * Saves an Object House
	 * @param houseType
	 */
	public void saveHouse(House house){
		writeObject(house);
		// refresh cashed data...
		load();
	}
}
