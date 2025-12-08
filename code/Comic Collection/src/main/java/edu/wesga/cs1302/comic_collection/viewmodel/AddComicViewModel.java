package edu.wesga.cs1302.comic_collection.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**Initializes the AddComic View Model
 * 
 * @author Justin Mott
 * @version Fall2025
 * 
 */
public class AddComicViewModel {
	private StringProperty title;
	private IntegerProperty issueNum;
	
	/**Connects the business Logic in the comic model to the AddComicWindow UI
	 * 
	 */
	public AddComicViewModel() {
		this.title = new SimpleStringProperty("");
		this.issueNum = new SimpleIntegerProperty();
	}
	
	/**retrieves the title of a comic book wanted to be added
	 * 
	 * @return the title of the comic book
	 */
	public StringProperty getComicTitle() {
		return this.title;
	}
	
	/**Gets the issue number of a comic book
	 * 
	 * @return the issue Number of the comic book
	 */
	public IntegerProperty getIssueNum() {
		return this.issueNum;
	}
	
}
