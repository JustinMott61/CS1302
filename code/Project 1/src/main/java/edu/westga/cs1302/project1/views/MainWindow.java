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
    private ListView<Task> taskList;

    @FXML
    private TextField taskName;

    @FXML
    private ComboBox<Integer> taskPriority;

    @FXML
    void sumbitTask(ActionEvent event) {
    	try {
    	String name = this.taskName.getText();
    	String description = this.taskDescription.getText();
    	int priority = this.taskPriority.getSelectionModel().getSelectedItem();
    	Task task = new Task(name, description, priority);
    	this.taskList.getItems().add(task);
    	this.taskDescription.clear();
    	this.taskName.clear();
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Please enter all fields with valid data");
    		alert.showAndWait();
    	}
    }

	/**
	 * Perform any needed initialization of UI components and underlying objects.
	 */
	@FXML
	void initialize() {
		this.taskPriority.getItems().add(1);
		this.taskPriority.getItems().add(2);
		this.taskPriority.getItems().add(3);
		this.taskPriority.getItems().add(4);
		this.taskPriority.getItems().add(5);
	}
}
