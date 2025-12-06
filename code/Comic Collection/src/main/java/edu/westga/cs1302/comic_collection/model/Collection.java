package edu.westga.cs1302.comic_collection.model;

import java.util.ArrayList;

/**Initializes a collection
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class Collection {
	
	private String name;
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
		this.name = name;
		this.comics = new ArrayList<Comic>();
	}

	/**Returns the name of the collection
	 * 
	 * @return Name of Collection
	 */
	public String getName() {
		return this.name;
	}
	
	/**Gets the list of comic in the collections
	 * 
	 * @return the comics in the collections
	 */
	public ArrayList<Comic> getComics() {
		return this.comics;
	}
	
	/**Adds a comic to the collection
	 * 
	 * @precondition comic != null
	 * @postcondition none
	 * 
	 * @param comic the comic being added to the collection
	 */
	public void addComic(Comic comic) {
		if (comic == null) {
			throw new IllegalArgumentException("Please add a valid comic to collection");
		}
		this.comics.add(comic);
	}
	
	/**Makes the collection in the list appear as its name
	 * 
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
