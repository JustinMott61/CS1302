package edu.westga.cs1302.comic_collection.views;

import edu.wesga.cs1302.comic_collection.viewmodel.ViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private ViewModel vm;
    @FXML
    private TextField collectionName;

    @FXML
    private ListView<Collection> collections;

    @FXML
    private MenuItem removeCollection;

    @FXML
    private Button removeCollectionButton;
    
    @FXML
    private Button addCollectionButton;
    
    @FXML
    private Button removeComicButton;
    
    
    /** Perform any needed initialization of UI components and underlying objects.
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    @FXML
    public void initialize() {
    	this.vm = new ViewModel();
    	this.buttonBindings();
    	this.disableAddButton();
    	this.vm.getName().bind(this.collectionName.textProperty());
    	this.collections.setItems(this.vm.getCollections());
    }

    /**Sets the bindings for all the buttons and context menu
     * 
     */
	private void buttonBindings() {
		this.removeCollection.setOnAction(
    			(Event) -> {
    		        this.vm.removeCollection(this.collections.getSelectionModel().getSelectedItem());
    	});
    	
		
		this.addCollectionButton.setOnAction(
				(Event) -> {
			try {
			this.vm.addCollection();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(error.getMessage());
				alert.showAndWait();
			}
		});

		this.removeCollectionButton.setOnAction(
				(Event) -> {
			try {
			this.vm.removeCollection(this.collections.getSelectionModel().getSelectedItem());
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(error.getMessage());
				alert.showAndWait();
			}
		});
		
	}

	/**disables the add Button if collectionName is empty
	 * 
	 */
    private void disableAddButton() {
    	this.addCollectionButton.disableProperty().bind(this.collectionName.textProperty().isEmpty());
    }
    
    
}
