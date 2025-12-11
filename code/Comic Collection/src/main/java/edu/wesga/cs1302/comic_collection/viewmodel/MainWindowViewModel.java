package edu.wesga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**Initializes the MainWIndow View Model
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class MainWindowViewModel {
	private StringProperty collectionName;
	private ListProperty<Collection> collections;
	private ListProperty<Comic> comics;
	
	/**Connects the business Logic in the collection model to the MainWWindow UI
	 * 
	 */
	public MainWindowViewModel() {
		this.collectionName = new SimpleStringProperty("");
		this.collections = new SimpleListProperty<Collection>(FXCollections.observableList(new ArrayList<Collection>()));
		this.comics = new SimpleListProperty<Comic>(FXCollections.observableList(new ArrayList<Comic>()));
	}
	
	/**Gets the name of a collection
	 * 
	 * @return the name of a collection
	 */
	public StringProperty getName() {
		return this.collectionName;
	}
	
	/**Gets a list of collections
	 * 
	 * @return list of collections
	 */
	public ListProperty<Collection> getCollections() {
		return this.collections;
	}
	
	/**Gets a list of comic in a collection
	 * 
	 * @return list of comics in a collection
	 */
	public ListProperty<Comic> getComics() {
		return this.comics;
	}
	
	/**Adds a collection to the list
	 * 
	 * @precondition Collection Name can't be null
	 * @postcondition none
	 */
	public void addCollection() {
		if (this.getName().get() == null) {
			throw new IllegalArgumentException("Please enter valid name");
		}
		Collection added = new Collection(this.getName().get());
		this.getCollections().add(added);
	}
	
	/**removes a collection from the list
	 * 
	 * @precondition remove != null
	 * @precondition none
	 * 
	 * @param remove the collection being removed
	 */
	public void removeCollection(Collection remove) {
		if (remove == null) {
			throw new IllegalArgumentException("Please select a Collection to be removed");
		}
		this.collections.remove(remove);
	}
	
	/**Removes a selected comic from a selected collection
	 * 
	 * @precondition collection != null
	 *               comic != null
	 * @postcondition the comic is removed from the specified collection
	 * 
	 * @param collection the collection the comic is being removed from
	 * @param comic the comic being removed from the collection
	 */
	public void removeComicFromCollection(Collection collection, Comic comic) {
		if (collection == null) {
			throw new IllegalArgumentException("Please select a valid Collction to remove comic from");
		} 
		if (comic == null) {
			throw new IllegalArgumentException("Please select a valid comic to be removed from collection");
		}
		collection.getComics().remove(comic);
	}
	
}
