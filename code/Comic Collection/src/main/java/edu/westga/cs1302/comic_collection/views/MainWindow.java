package edu.westga.cs1302.comic_collection.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


/** Controller class for MainWindow of the Task Tracker system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
    @FXML
    private TextField collectionName;

    @FXML
    private ListView<?> collections;

    @FXML
    private MenuItem removeCollection;

    @FXML
    private Button removeCollectionButton;
    
    @FXML
    private Button addCollectionButton;

    
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
