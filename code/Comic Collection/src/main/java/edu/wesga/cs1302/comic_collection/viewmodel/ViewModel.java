package edu.wesga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.Collection;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**Initializes the View Model
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class ViewModel {
	private StringProperty name;
	private ListProperty<Collection> collections;
	
	/**Connects the business Logic in the model to the UI
	 * 
	 */
	public ViewModel() {
		this.name = new SimpleStringProperty("");
		this.collections = new SimpleListProperty<Collection>(FXCollections.observableList(new ArrayList<Collection>()));
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
}
