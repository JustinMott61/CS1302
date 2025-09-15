package edu.westga.cs1302.bill.test.view.bill_view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.view.BillView;

class TestGetText {

	@Test
	void testNullBill() {		
		assertThrows(NullPointerException.class, ()->{BillView.getText(null);});
	}
	
	@Test
	void testEmptyBill() {
		Bill[] bills = new Bill[1];
		Bill bill = new Bill();
		bills[1] = bill;
		
		String result = BillView.getText(bills);
		
		String expected = "ITEMS" + System.lineSeparator();
		expected += System.lineSeparator();
		expected += "SUBTOTAL - $0.0" + System.lineSeparator();
		expected += "TAX - $0.0" + System.lineSeparator();
		expected += "TIP - $0.0" + System.lineSeparator();
		expected += "TOTAL - $0.0";
		
		assertEquals(expected, result);
	}
	
	@Test
	void testOneItemInBill() {
		Bill[] bills = new Bill[1];
		Bill bill = new Bill();
		BillItem item1 = new BillItem("orange", 1);
		bill.addItem(item1);
		bills[1] = bill;
		
		String result = BillView.getText(bills);
		
		String expected = "ITEMS" + System.lineSeparator();
		expected += "orange - 1.0" + System.lineSeparator();
		expected += System.lineSeparator();
		expected += "SUBTOTAL - $1.0" + System.lineSeparator();
		expected += "TAX - $0.1" + System.lineSeparator();
		expected += "TIP - $0.2" + System.lineSeparator();
		expected += "TOTAL - $1.3";
		
		assertEquals(expected, result);
	}
	
	@Test
	void testMultipleItemsInBill() {
		Bill[] bills = new Bill[1];
		Bill bill = new Bill();
		BillItem item1 = new BillItem("orange", 1);
		bill.addItem(item1);
		BillItem item2 = new BillItem("banana", 2);
		bill.addItem(item2);
		bills[1] = bill;
		
		String result = BillView.getText(bills);
		
		String expected = "ITEMS" + System.lineSeparator();
		expected += "orange - 1.0" + System.lineSeparator();
		expected += "banana - 2.0" + System.lineSeparator();
		expected += System.lineSeparator();
		expected += "SUBTOTAL - $3.0" + System.lineSeparator();
		expected += "TAX - $0.3" + System.lineSeparator();
		expected += "TIP - $0.6" + System.lineSeparator();
		expected += "TOTAL - $3.9";
		
		assertEquals(expected, result);
	}

}
