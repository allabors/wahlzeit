package com.house.model.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.model.PhotoUtil;

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import com.house.model.HousePhoto;

/**
 * Manages the objects life cycle of type {@link HousePhoto} and persisting them via ofy-framework.
 * 
 * <p>Here are the main steps of this process:
 * <ol>
 *  <li> {@link #createPhoto(String, Image) - create a transient instance of {@link Photo} </li>
 *  <li> {@link PhotoManager#savePhoto(HousePhoto) or {@link #savePhotos()} persist one {@link HousePhoto} or all as a whole.</li>
 * </ol>
 * 
 * The Design-Space of the object creation process can be summarized as follows:
 * 
 * <ul>
 * 	<li> Delegation : Abstract Factory, since to {@link HouseType} delegated </li>
 *  <li> Selection : Prototype. The involvement of ofy-framework can be viewed here as "prototyped" 
 *  type selection.</li>
 *  <li> Configuration : Product Trader, since the persistence annotation "entity" provides some kind of configuration.
 *  </li>
 *  <li> Instantiation : Prototype. The argumentation is the same as for the selection.</li>
 *  <li> Initialization : Prototype. The argumentation is the same as for the selection.</li>
 *  <li> Building : Builder, since many other subjects like {@link PhotoId}, {@link PhotoUtil} etc. give the initial
 *  complex structure of a photo.</li>
 * </ul>
 */
public class HousePhotoManager extends PhotoManager {
	
	private static HousePhotoManager instance;
	private Collection<HousePhoto> housePhotos;
	
	private HousePhotoManager(){
		
	}
	
	public static HousePhotoManager getInstance(){
		if(instance == null){
			instance = new HousePhotoManager();
		}
		return instance;
	}
	
	/**
	 * Load all persisted data.
	 */
	public void load() {
		housePhotos = ObjectifyService.run(new Work<Collection<HousePhoto>>() {
			@Override
			public Collection<HousePhoto> run() {
				Collection<HousePhoto> existingHouses = new ArrayList<>();
				readObjects(existingHouses, HousePhoto.class);
				return existingHouses;
			}
		});
	}
	
	/**
	 * Creates a new {@link HousePhoto}-Object.
	 * @param filename
	 * @param uploadedImage
	 * @return
	 * @throws Exception
	 */
	public HousePhoto createHousePhoto(String filename, Image uploadedImage) throws Exception {
		PhotoId id = PhotoId.getNextId();
		Photo result = PhotoUtil.createPhoto(filename, id, uploadedImage);
		addPhoto(result);
		return (HousePhoto) result;
	}
	
	/**
	 * Returns all {@link HousePhoto} objects.
	 * @return
	 */
	public Collection<HousePhoto> getAllHousePhotos() {
		return housePhotos;
	}
	
	/**
	 * Saves an Object {@link HousePhoto}
	 * @param housePhoto
	 */
	public void saveHousePhoto(HousePhoto housePhoto){
		writeObject(housePhoto);
		// refresh cashed data...
		load();
	}
}
