package edu.westga.cs1302.lab2.test.Bill;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestAddItem {

	@Test
	public void testNullIsNotValidItem() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			Bill bill = new Bill();
			BillItem item = new BillItem(null,0.0);
			bill.addItem(item);
		});
	}
	
	@Test
	public void testAddOneItem() {
		Bill bill = new Bill();
		BillItem billItem1 = new BillItem("Gas",69.02);
		
		bill.addItem(billItem1);
		ArrayList<BillItem> result = bill.getItems();
		
		assertEquals(billItem1, result.get(0));
	}
	
	@Test
	public void testAddTwoItems() {
		Bill bill = new Bill();
		BillItem billItem1 = new BillItem("Gas",69.02);
		BillItem billItem2 = new BillItem("Electricity", 200.29);
		
		bill.addItem(billItem1);
		bill.addItem(billItem2);
		ArrayList<BillItem> result = bill.getItems();
		
		assertEquals(billItem1, result.get(0));
		assertEquals(billItem2, result.get(1));
	}

}
