package edu.westga.cs1302.password_generator.view;

import java.io.File;
import java.io.IOException;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private Label errorTextLabel;
    @FXML private Label minLengthErrorText;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> passwordHistory;
    @FXML private MenuItem saveMenuItem;
    @FXML private MenuItem aboutMenuItem;
    @FXML private MenuItem closeMenuItem;
    
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.bindDisableGeneratePassword();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.passwordHistory.setItems(this.vm.getPasswordHistory());
    	
    	this.minimumLength.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (this.vm.checkMinimumLengthText(newValue)) {
						this.minLengthErrorText.setVisible(true);
					} else {
						this.minLengthErrorText.setVisible(false);
					}
		});
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    	
    	this.saveMenuItem.setOnAction(
				(event) -> {
					FileChooser fileChooser = new FileChooser();
					fileChooser.setTitle("Choose Where to Save");
					fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", ".txt"));
					File selectedFile = fileChooser.showSaveDialog(null);
					try {
						this.vm.savePasswordData(selectedFile);
					} catch (IOException error) {
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setContentText("An error occured while saving file");
						alert.showAndWait();
					}
				});
    	
		this.aboutMenuItem.setOnAction((event) -> {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("This Project is used to create and save the passwords created by a user."
					+ System.lineSeparator() + "Author: Justin Mott");
			alert.showAndWait();
		});
    	
    	this.closeMenuItem.setOnAction(
    			(event) -> {
    				((Node) (this.errorTextLabel)).getScene().getWindow().hide();
    			}
    	);
    }
    
    private void bindDisableGeneratePassword() {
    	BooleanBinding disablePasswordButton = Bindings.or(this.minimumLength.textProperty().isEmpty(), this.minLengthErrorText.visibleProperty());
    	this.generatePasswordButton.disableProperty().bind(disablePasswordButton);
    }
    
}
