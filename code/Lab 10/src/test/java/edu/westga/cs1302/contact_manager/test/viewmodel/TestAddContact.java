package edu.westga.cs1302.contact_manager.test.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class TestAddContact {

	@Test
	void testValidContacts() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
		vm.getName().set("April");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		
		vm.getName().set("Sam");
		vm.getPhoneNumber().set("1234561");
		vm.addContact();
		
		vm.getSearchCriteria().set("April");
		String result1 = vm.findContact();
		
		vm.getSearchCriteria().set("Sam");
		String result2 = vm.findContact();
		
		assertEquals("April, 1234567", result1);
		assertEquals("Sam, 1234561", result2);
	}

	@Test
	void testInvalidNameContactInformation() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.getPhoneNumber().set("1234567");
			vm.getName().set("");
			vm.addContact();
		});
	}
	
	@Test
	void testInvalidNumberContactInformation() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.getPhoneNumber().set("");
			vm.getName().set("Sam");
			vm.addContact();
		});
	}
	
	@Test
	void testDuplicateNameContactInformation() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.getName().set("April");
			vm.getPhoneNumber().set("1234567");
			vm.addContact();
			
			vm.getName().set("April");
			vm.getPhoneNumber().set("1234561");
			vm.addContact();
		});
	}
	
	@Test
	void testDuplicateNumberContactInformation() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.getName().set("April");
			vm.getPhoneNumber().set("1234567");
			vm.addContact();
			
			vm.getName().set("Sam");
			vm.getPhoneNumber().set("1234567");
			vm.addContact();
		});
	}
	
	@Test
	void testDuplicateNumberAndNameContactInformation() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.getName().set("April");
			vm.getPhoneNumber().set("1234567");
			vm.addContact();
			
			vm.getName().set("April");
			vm.getPhoneNumber().set("1234567");
			vm.addContact();
		});
	}
}
