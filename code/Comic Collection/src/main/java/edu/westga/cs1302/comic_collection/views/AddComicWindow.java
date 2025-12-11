package edu.westga.cs1302.comic_collection.views;

import edu.wesga.cs1302.comic_collection.viewmodel.AddComicViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.NumberStringConverter;

/** Controller class for AddComicWindow of the Comic collection system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class AddComicWindow {
	private AddComicViewModel vm;
	@FXML
	private AnchorPane addComicGUI;
	  
    @FXML
    private Button cancelButton;

    @FXML
    private TextField comicTitle;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField issueNumber;

    /** Perform any needed initialization of UI components and underlying objects.
     * 
     */
    @FXML
    public void initialize() {
    	this.buttonBindings();
    	this.bindAddComicViewModel();
    }

	/**
	 * Binds the add comic view model to the add comic window UI
	 * 
	 */
	private void bindAddComicViewModel() {
		this.comicTitle.textProperty().bindBidirectional(this.vm.getComicTitle());
		this.issueNumber.textProperty().bindBidirectional(this.vm.getComicIssueNumber(), new NumberStringConverter());
	}

	/**Binds all the buttons
	 * 
	 */
	public void buttonBindings() {
		this.cancelButton.setOnAction((Event) -> {
			this.addComicGUI.getScene().getWindow().hide();
		});

		this.confirmButton.setOnAction((Event) -> {
			
		});
	}
	
	/**Adds comic to the desired collection
	 * 
	 * @param collection the collection to be added to
	 */
	public void setUpAddComic(Collection collection) {
		try {
			this.vm.addComicToCollection(collection);
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
		
	}
 
}
