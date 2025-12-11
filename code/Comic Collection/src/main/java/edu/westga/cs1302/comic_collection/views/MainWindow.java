package edu.westga.cs1302.comic_collection.views;

import java.io.IOException;

import edu.wesga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import edu.westga.cs1302.comic_collection.Main;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** Controller class for MainWindow of the Comic collection system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	private MainWindowViewModel vm;
    @FXML
    private TextField collectionName;

    @FXML
    private ListView<Collection> collections;

    @FXML
    private MenuItem removeCollectionMenuItem;

    @FXML
    private Button removeCollectionButton;
    
    @FXML
    private Button addCollectionButton;
    
    @FXML
    private ListView<Comic> comicsInCollection;
    
    @FXML
    private Button addComicButton;
    
    @FXML
    private Button removeComicButton;

    @FXML
    private MenuItem removeComicMenuItem;
    
    /** Perform any needed initialization of UI components and underlying objects.
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    @FXML
    public void initialize() {
    	this.vm = new MainWindowViewModel();
    	this.bindViewModelProperties();
    	this.buttonBindings();
    	this.disableAddButton();
    	this.menuItemBindings();
    }

	/**
	 * Binds all the Main window view model properties to the UI
	 * 
	 */
	private void bindViewModelProperties() {
		this.vm.getName().bind(this.collectionName.textProperty());
		this.collections.setItems(this.vm.getCollections());
		this.comicsInCollection.setItems(this.vm.getComics());
	}

	/**
	 * Sets the bindings for all the buttons and context menu
	 * 
	 */
	private void buttonBindings() {
		this.addCollectionButton.setOnAction((Event) -> {
			try {
				this.vm.addCollection();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(error.getMessage());
				alert.showAndWait();
			}
		});

		this.removeCollectionButton.setOnAction((Event) -> {
			try {
				this.vm.removeCollection(this.collections.getSelectionModel().getSelectedItem());
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(error.getMessage());
				alert.showAndWait();
			}
		});
		
		this.addComicButton.setOnAction((Event) -> {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource(Main.ADD_COMIC_WINDOW));
				loader.load();
				Parent parent = loader.getRoot();
				Scene scene = new Scene(parent);
				Stage addComicWindowStage = new Stage();
				addComicWindowStage.setTitle(Main.ADD_COMIC_WINDOW);
				addComicWindowStage.setScene(scene);
				addComicWindowStage.initModality(Modality.APPLICATION_MODAL);
				AddComicWindow controller = (AddComicWindow) loader.getController();
				addComicWindowStage.showAndWait();
			} catch (IOException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Failed to load options window. Error loading UI components;");
				alert.showAndWait();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Failed to load options window. Error passing collection info to add comic window.");
				alert.showAndWait();
			}
		});
		
		this.removeComicButton.setOnAction((Event) -> {
			
		});
		
	}

	/**
	 * disables the add Button if collectionName is empty
	 * 
	 */
	private void disableAddButton() {
		this.addCollectionButton.disableProperty().bind(this.collectionName.textProperty().isEmpty());
	}
	
	/**Binds all the menu items to their respected list views
	 * 
	 */
	private void menuItemBindings() {
		this.removeCollectionMenuItem.setOnAction((Event) -> {
			try {
				this.vm.removeCollection(this.collections.getSelectionModel().getSelectedItem());
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Please select a vaild collection to be removed");
				alert.showAndWait();
			}
		});
		
		this.removeComicMenuItem.setOnAction((Event) -> {
			
		});
	}
    
}
