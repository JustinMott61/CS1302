package edu.westga.cs1302.comic_collection.model;

import java.util.ArrayList;

/**Initializes a collection
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class Collection {
	
	private String collectionName;
	private ArrayList<Comic> comics;
	
	/**A collection of comic books
	 * 
	 * @precondition !name.isEMpty() && !name.isBlank() && name!= null
	 * 
	 * @postcondition none
	 * 
	 * @param name the name of the collection
	 */
	public Collection(String name) {
		if (((name.isEmpty()) || (name.isBlank()) || (name == null))) {
			throw new IllegalArgumentException("Please input valid name for Collection");
		}
		this.collectionName = name;
		this.comics = new ArrayList<Comic>();
	}

	/**Returns the name of the collection
	 * 
	 * @return Name of Collection
	 */
	public String getCollectionName() {
		return this.collectionName;
	}
	
	/**Gets the comics in a collection
	 * 
	 * @return comics in collection
	 */
	public ArrayList<Comic> getComics() {
		return this.comics;
	}
	
	/**Adds a comic to the list of comics
	 * 
	 * @precondition comic != null
	 * @postcondition comic gets add to the list
	 * 
	 * @param comic the comic being added
	 */
	public void addComic(Comic comic) {
		if (comic == null) {
			throw new IllegalArgumentException("Comic being added must be valid");
		}
		this.comics.add(comic);
	}
	
	/**Removes a comic from the list of comics
	 * 
	 * @precondition comic != null
	 * @postcondition comic is removed from list
	 * 
	 * @param comic the comic being removed
	 */
	public void removeComic(Comic comic) {
		if(comic == null) {
			throw new IllegalArgumentException("Comic being removed must be valid");
		}
		this.comics.remove(comic);
	}
	
	/**Makes the collection in the list appear as its name
	 * 
	 */
	@Override
	public String toString() {
		return this.collectionName;
	}
}
