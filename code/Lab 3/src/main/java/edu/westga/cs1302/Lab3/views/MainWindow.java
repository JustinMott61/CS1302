package edu.westga.cs1302.Lab3.views;

import edu.westga.cs1302.Lab3.model.Bill;
import edu.westga.cs1302.Lab3.model.BillItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	private Bill bill;
	@FXML
    private TextField itemAmount;

    @FXML
    private TextField itemName;

    @FXML
    private TextArea output;

    @FXML
    void getReciept(ActionEvent event) {
    	String name = this.itemName.getText();
    	double amount = Double.parseDouble(this.itemAmount.getText());
    	BillView view = new BillView();
    	try {
    		BillItem billItem = new BillItem(name, amount);
    		this.bill.addItem(billItem);
    	} catch (IllegalArgumentException e){
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Please insert valid item name and amount");
    		alert.showAndWait();
    	} 
    	this.output.setText(view.getText(bill));
    }
	/**
	 * Perform any needed initialization of UI components and underlying objects.
	 */
	public void initialize() {
		this.bill = new Bill();
	}

}
