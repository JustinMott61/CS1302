package edu.westga.cs1302.comic_collection.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/** Controller class for AddComicWindow of the Comic collection system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class AddComicWindow {
	
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
     * @precondition none
     * @postcondition none
     * 
     */
    @FXML
    public void initialize() {
    
    }
}
