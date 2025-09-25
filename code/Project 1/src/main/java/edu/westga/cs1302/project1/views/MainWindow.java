package edu.westga.cs1302.project1.views;

import edu.westga.cs1302.project1.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
	    private ListView<Task> taskOutput;

	    @FXML
	    private ComboBox<Integer> taskPriority;

	    @FXML
	    void createNewTask(ActionEvent event) {
	    	try {
				String name = this.taskName.getText();
				String description = this.taskDescription.getText();
				int priority = this.taskPriority.getSelectionModel().getSelectedItem();
				Task task = new Task(name, description, priority);
				this.taskOutput.getItems().add(task);
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Task Failed to be added. Please insert a valid name, Description, and pick a valid priority rating");
				alert.showAndWait();
	    	}
	    }
	    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	this.taskPriority = new ComboBox<Integer>();
    	this.taskPriority.setValue(1);
    	this.taskPriority.setValue(2);
    }
}
