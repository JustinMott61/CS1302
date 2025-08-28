package edu.westga.cs1302.lab2.test.BillView;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;
import edu.westga.cs1302.lab2.view.BillView;

class TestGetText {
	
	@Test
	void testProperCheckNoItems() {
		Bill bill = new Bill();
		BillView view = new BillView();
		
		String result = view.getText(bill);
		
		assertEquals("ITEMS" + System.lineSeparator()
		           + System.lineSeparator()
				   + "SUBTOTAL - $0.0" + System.lineSeparator()
				   + "TAX - $0.0" + System.lineSeparator()
				   + "TIP - $0.0" + System.lineSeparator()
				   + "TOTAL - $0.0", result);
	}

	@Test
	void testProperCheckWithOneItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Gas", 300.42); 
		BillView view = new BillView();
		bill.addItem(item1);
		
		String result = view.getText(bill);
		
		assertEquals("ITEMS" + System.lineSeparator()
		           + "Gas - 300.42" + System.lineSeparator() + System.lineSeparator()
				   + "SUBTOTAL - $300.42" + System.lineSeparator()
				   + "TAX - $30.04" + System.lineSeparator()
				   + "TIP - $60.08" + System.lineSeparator()
				   + "TOTAL - $390.54", result);
	}
	
	@Test
	void testProperCheckWithMultipleItems() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Gas", 300.42);
		BillItem item2 = new BillItem("Cereal", 16.89);
		BillItem item3 = new BillItem("Pack of Soda", 13.00);
		BillItem item4 = new BillItem("Utensils", 6.49);
		BillView view = new BillView();
		bill.addItem(item1);
		bill.addItem(item2);
		bill.addItem(item3);
		bill.addItem(item4);
		
		String result = view.getText(bill);
		
		assertEquals("ITEMS" + System.lineSeparator()
		           + "Gas - 300.42" + System.lineSeparator() 
		           + "Cereal - 16.89" + System.lineSeparator()
		           + "Pack of Soda - 13.0" + System.lineSeparator()
		           + "Utensils - 6.49" + System.lineSeparator()
		           + System.lineSeparator()
				   + "SUBTOTAL - $336.8" + System.lineSeparator()
				   + "TAX - $33.68" + System.lineSeparator()
				   + "TIP - $67.36" + System.lineSeparator()
				   + "TOTAL - $437.84", result);
	}
	
}
