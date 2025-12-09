package edu.westga.cs1302.comic_collection.views;

import edu.wesga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.util.converter.NumberStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/** Controller class for AddComicWindow of the Comic collection system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class AddComicWindow {
	private MainWindowViewModel vm;
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
    }
    
    public void buttonBindings() {
    	this.cancelButton.setOnAction((Event) -> {
    		this.addComicGUI.getScene().getWindow().hide();
    	});
    	
    	this.confirmButton.setOnAction((Event) -> {
    		
    	});
    }
 
}
