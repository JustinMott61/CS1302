package edu.wesga.cs1302.comic_collection.viewmodel;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**Initializes the AddComic View Model
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class AddComicViewModel {
	private StringProperty comicTitle;
	private IntegerProperty comicIssueNumber;
	
	/**Connects the business Logic in the comic model to the comic UI
	 * 
	 */
	public AddComicViewModel() {
		
		this.comicTitle = new SimpleStringProperty("");
		this.comicIssueNumber = new SimpleIntegerProperty();
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
		Comic comic = new Comic(this.getComicTitle().getValue(), this.getComicIssueNumber().get());
		collection.getComics().add(comic);
	}
	
}
