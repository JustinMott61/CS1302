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
public class MainWindowViewModel {
	private StringProperty collectionName;
	private ListProperty<Collection> collections;
	private ListProperty<Comic> comics;
	private StringProperty comicTitle;
	private IntegerProperty comicIssueNumber;
	private Collection collection;
	private Comic comic;
	
	/**Connects the business Logic in the collection model to the MainWWindow UI
	 * 
	 */
	public MainWindowViewModel() {
		this.collection = new Collection("PlaceHolder");
		this.comic = new Comic("PlaceHolder", 1);
		this.collectionName = new SimpleStringProperty("");
		this.collections = new SimpleListProperty<Collection>(FXCollections.observableList(new ArrayList<Collection>()));
		this.comics = new SimpleListProperty<Comic>(FXCollections.observableList(this.collection.getComics()));
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
	
	/**Gets a list of comic in a collection
	 * 
	 * @return list of comics in a collection
	 */
	public ListProperty<Comic> getComics() {
		return this.comics;
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
	
	/**Gets the collection in the vm
	 * 
	 * @return vm collection
	 */
	public Collection getCollection() {
		return this.collection;
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
	
	/**Adds a comic to to a specified collection
	 * 
	 * @precondition collection != null
	 * @postcondition none
	 * 
	 * @param collection the collection the comic is being added to
	 */
	public void addComicToCollection(Collection collection) {
		if (collection == null) {
			throw new IllegalArgumentException("Please select a valid Collction to add to");
		}
		this.comic = new Comic(this.comicTitle.getValue(), this.comicIssueNumber.getValue());
		this.collection = collection;
		this.collection.addComic(this.comic);
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
		this.collection = collection;
		this.comic = comic;
		collection.removeComic(comic);
	}
	
}
