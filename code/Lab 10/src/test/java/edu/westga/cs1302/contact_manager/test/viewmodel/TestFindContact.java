package edu.westga.cs1302.contact_manager.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class TestFindContact {

	@Test
	void testWhenNullSearchCriteria() {
		assertThrows(IllegalArgumentException.class, () ->  {
			MainWindowViewModel vm = new MainWindowViewModel();
		    vm.findContact();
		});
	}
	
	@Test
	void testWhenNoContacts() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getSearchCriteria().set("Sam");
		
		String result = vm.findContact();
		
		assertEquals("No contact found.", result);
	}
	
	@Test
	void testWhenNoContactsMatchName() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getSearchCriteria().set("Sam");
		
		vm.getName().set("April");
		vm.getPhoneNumber().set("9099091");
		vm.addContact();
		
		vm.getName().set("Max");
		vm.getPhoneNumber().set("9099092");
		vm.addContact();
		
		vm.getName().set("James");
		vm.getPhoneNumber().set("9099093");
		vm.addContact();
		
		String result = vm.findContact();
		
		assertEquals("No contact found.", result);
	}

	@Test
	void testWhenNoContactsMatchPhoneNumber() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getSearchCriteria().set("9099090");
		
		vm.getName().set("April");
		vm.getPhoneNumber().set("9099091");
		vm.addContact();
		
		vm.getName().set("Max");
		vm.getPhoneNumber().set("9099092");
		vm.addContact();
		
		vm.getName().set("James");
		vm.getPhoneNumber().set("9099093");
		vm.addContact();
		
		String result = vm.findContact();
		
		assertEquals("No contact found.", result);
	}
	
	@Test
	void testWhenContactMatchesName() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getSearchCriteria().set("April");
		
		vm.getName().set("April");
		vm.getPhoneNumber().set("9099091");
		vm.addContact();
		
		vm.getName().set("Max");
		vm.getPhoneNumber().set("9099092");
		vm.addContact();
		
		vm.getName().set("James");
		vm.getPhoneNumber().set("9099093");
		vm.addContact();
		
		String result = vm.findContact();
		
		assertEquals("April, 9099091" , result);
	}
	
	@Test
	void testWhenContactMatchesPhoneNumber() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getSearchCriteria().set("9099091");
		
		vm.getName().set("April");
		vm.getPhoneNumber().set("9099091");
		vm.addContact();
		
		vm.getName().set("Max");
		vm.getPhoneNumber().set("9099092");
		vm.addContact();
		
		vm.getName().set("James");
		vm.getPhoneNumber().set("9099093");
		vm.addContact();
		
		String result = vm.findContact();
		
		assertEquals("April, 9099091", result);
	}
}
