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
	
	private StringProperty name;
	private ListProperty<Collection> collections;
	private ListProperty<Comic> comics;
	
	/**Connects the business Logic in the collection model to the MainWWindow UI
	 * 
	 */
	public MainWindowViewModel() {
		this.name = new SimpleStringProperty("");
		this.collections = new SimpleListProperty<Collection>(FXCollections.observableList(new ArrayList<Collection>()));
		this.comics = new SimpleListProperty<Comic>(FXCollections.observableList(new ArrayList<Comic>()));
	}
	
	/**Gets the name of a collection
	 * 
	 * @return the name of a collection
	 */
	public StringProperty getName() {
		return this.name;
	}
	
	/**Gets a list of collections
	 * 
	 * @return list of collections
	 */
	public ListProperty<Collection> getCollections() {
		return this.collections;
	}
	
	/**Gets a list of comics
	 * 
	 * @return list of comics
	 */
	public ListProperty<Comic> getComics() {
		return this.comics;
	}
	
	/**Adds a collection to the list
	 * 
	 * @precondition Collection Name can't be null
	 * 
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
	 * 
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
	
	/**Adds a comic to the selected collection
	 * 
	 * @precondition selectedCollection != null && addComic != null
	 * @postcondition none
	 * 
	 * @param selectedCollection the collection the comic is being added to
	 * @param addComic the comic being added
	 */
	public void addComicToCollection(Collection selectedCollection, Comic addComic) {
		if (selectedCollection == null) {
			throw new IllegalArgumentException("Please have a valid collection selected");
		}
		if (addComic == null) {
			throw new IllegalArgumentException("Please have a valid comic to add to the collection");
		}
		selectedCollection.addComic(addComic);
	}
	
	/**Removes a comic from a selected Collection
	 * 
	 * @precondition selectedCollection != null && removeComic != null
	 * @postcondition none
	 * 
	 * @param selectedCollection the collection the comic is being added to
	 * @param addComic the comic being removed
	 */
	public void removeComicFromCollection(Collection selectedCollection, Comic removeComic) {
		if (selectedCollection == null) {
			throw new IllegalArgumentException("Please have a valid collection selected");
		}
		if (removeComic == null) {
			throw new IllegalArgumentException("Please have a valid comic to be removed from the collection");
		}
		selectedCollection.getComics().remove(removeComic);
	}
}
