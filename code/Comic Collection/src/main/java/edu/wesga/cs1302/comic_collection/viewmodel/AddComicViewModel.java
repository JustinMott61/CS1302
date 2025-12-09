package edu.wesga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.beans.property.SimpleStringProperty;

/**connects the AddComicWindow to the models
 * 
 * @author Justin Mott
 * @version Fall 2025
 */
public class AddComicViewModel {
	private StringProperty comicTitle;
	private IntegerProperty comicIssueNumber;
	private ListProperty<Comic> comics;
	
	/**Connects the business logic of comic to the UI of AddComicWindow
	 * 
	 */
	public AddComicViewModel() {
		this.comicTitle = new SimpleStringProperty("");
		this.comicIssueNumber = new SimpleIntegerProperty();
		this.comics = new SimpleListProperty<Comic>(FXCollections.observableList(new ArrayList<Comic>()));
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
	
	/**Gets a list of comic in a collection
	 * 
	 * @return list of comics in a collection
	 */
	public ListProperty<Comic> getComics() {
		return this.comics;
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
		Comic comic = new Comic(this.comicTitle.getValue(), this.comicIssueNumber.getValue());
		collection.addComic(comic);
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
		collection.removeComic(comic);
	}
	
}
