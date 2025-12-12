package edu.westga.cs1302.comic_collection.views;

import edu.wesga.cs1302.comic_collection.viewmodel.ViewModel;
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
	private ViewModel addComicVm;
	
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
    	this.addComicVm = new ViewModel();
    	this.buttonBindings();
    }

	/**
	 * Sets up the connection between the AddComicViewModels
	 * 
	 * @param vm the add Comic View Model being connected
	 */
	public void setAddComicVM(ViewModel vm) {
		if (vm == null) {
			throw new IllegalArgumentException("The vm connection isn't established");
		}
		this.addComicVm = vm;
		this.comicTitle.textProperty().bindBidirectional(this.addComicVm.getComicTitle());
		this.issueNumber.textProperty().bindBidirectional(this.addComicVm.getComicIssueNumber(),
				new NumberStringConverter());
	}

	/**Binds all the buttons
	 * 
	 */
	public void buttonBindings() {
		this.cancelButton.setOnAction((Event) -> {
			this.addComicGUI.getScene().getWindow().hide();
		});

		this.confirmButton.setOnAction((Event) -> {
			try {
				this.addComicVm.addComicToCollection(this.addComicVm.currentComic(), this.addComicVm.getSelectedCollection());
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(error.getMessage());
				alert.showAndWait();
			}
		});
	}
 
}
