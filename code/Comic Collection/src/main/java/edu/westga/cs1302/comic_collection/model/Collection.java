package edu.westga.cs1302.comic_collection.model;

/**Initializes a collection
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class Collection {
	
	private String name;
	
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
	}

	/**Returns the name of the collection
	 * 
	 * @return Name of Collection
	 */
	public String getName() {
		return this.name;
	}
	
	/**Makes the collection in the list appear as its name
	 * 
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
