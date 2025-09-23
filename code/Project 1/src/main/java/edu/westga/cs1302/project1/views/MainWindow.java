package edu.westga.cs1302.project1.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	    @FXML
	    private TextArea taskDescription;

	    @FXML
	    private TextField taskName;

	    @FXML
	    private ListView<?> taskOutput;

	    @FXML
	    private ComboBox<?> taskPriority;

	    @FXML
	    void createNewTask(ActionEvent event) {
	    	
	    }
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
}
