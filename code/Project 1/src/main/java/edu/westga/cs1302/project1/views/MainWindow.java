package edu.westga.cs1302.project1.views;

import edu.westga.cs1302.project1.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	private String selectedTaskDescription;
	
	private String selectedTaskPriority;
	
	@FXML
	private TextArea displayTaskDescription;

	@FXML
	private TextField displayTaskPriority;

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
    	
    @FXML
    void displayTaskInfo(MouseEvent event) {
    	this.selectedTaskDescription = this.taskList.getSelectionModel().getSelectedItem().getDescription();
    	this.selectedTaskPriority = Integer.toString(this.taskList.getSelectionModel().getSelectedItem().getPriority());
    	this.displayTaskDescription.setText(this.selectedTaskDescription);
    	this.displayTaskPriority.setText(this.selectedTaskPriority);
    }
    
    @FXML
    void updateDescription(ActionEvent event) {
    	if (this.taskList.getItems().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Can't edit a task with empty task list");
    		alert.showAndWait();
    	}
    	try {
    		Task task = this.taskList.getSelectionModel().getSelectedItem();
    		this.selectedTaskDescription = this.displayTaskDescription.getText();
    		task.updateDescription(this.selectedTaskDescription);
    		this.displayTaskDescription.clear();
    		this.displayTaskPriority.clear();
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Please update tasks with valid description in the display description area");
    		alert.showAndWait();
    	} 
    }
    
    @FXML
    void removeTask(ActionEvent event) {
    	if (this.taskList.getItems().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Can't remove a task with empty task list");
    		alert.showAndWait();
    	}
    	try {
    		Task task = this.taskList.getSelectionModel().getSelectedItem();
    		this.taskList.getItems().remove(task);
    		this.displayTaskDescription.clear();
    		this.displayTaskPriority.clear();
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Please select Task to be removed");
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
