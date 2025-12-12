package edu.wesga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
public class ViewModel {
	private StringProperty collectionName;
	private Collection collection;
	private ListProperty<Collection> collections;
	private ListProperty<Comic> comics;
	private StringProperty comicTitle;
	private IntegerProperty comicIssueNumber;
	
	/**Connects the business Logic in the collection model to the MainWWindow UI
	 * 
	 */
	public ViewModel() {
		this.collectionName = new SimpleStringProperty("");
		this.collections = new SimpleListProperty<Collection>(FXCollections.observableList(new ArrayList<Collection>()));
		this.comics = new SimpleListProperty<Comic>(FXCollections.observableArrayList());
		this.comicTitle = new SimpleStringProperty("");
		this.comicIssueNumber = new SimpleIntegerProperty();
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
	
	/**Gets the title of a comic
	 * 
	 * @return comic title
	 */
	public StringProperty getComicTitle() {
		return this.comicTitle;
	}
	
	/**Gets the issue number of a comic
	 * 
	 * @return comic issue number
	 */
	public IntegerProperty getComicIssueNumber() {
		return this.comicIssueNumber;
	}
	
	/**Gets the currently selected Collection
	 * 
	 * @return selected collection
	 */
	public Collection getSelectedCollection() {
		return this.collection;
	}
	
	/**Sets the selected collection
	 * 
	 * @precondition collection != null
	 * @postcondition none
	 * 
	 * @param collection the collection being set as the selected
	 * 
	 */
	public void setSelectedCollection(Collection collection) {
		if (collection == null) {
			throw new IllegalArgumentException("The selectedCollection isn't set");
		}
		this.collection = collection;
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
	
	/**Adds a comic to the collection
	 * 
	 * @precondition comic!= null
	 *               collection != null
	 * @postcondition none
	 * 
	 * @param comic the comic being added
	 * @param collection the collection being added to
	 */
	public void addComicToCollection(Comic comic, Collection collection) {
		if (comic == null) {
			throw new IllegalArgumentException("added comic can't be null");
		}
		if (collection == null) {
			throw new IllegalArgumentException("Collection that comic is being add to can't be null");
		}
		collection.addComic(comic);
	}
	
	/**Removes a comic from the collection
	 * 
	 * @precondition comic!= null
	 *               collection != null
	 * @postcondition none
	 * 
	 * @param comic the comic being removed
	 * @param collection the collection the comic is being removed from
	 */
	public void removeComicFromCollection(Comic comic, Collection collection) {
		if (comic == null) {
			throw new IllegalArgumentException("removed comic can't be null");
		}
		if (collection == null) {
			throw new IllegalArgumentException("Collection that comic is being removed from can't be null");
		}
		collection.removeComic(comic);
	}
	
	/**Stores the comic information from the user provided data
	 * 
	 * @return a comic with valid input data
	 */
	public Comic currentComic() {
		return new Comic(this.comicTitle.get(), this.comicIssueNumber.get());
	}
	
}
