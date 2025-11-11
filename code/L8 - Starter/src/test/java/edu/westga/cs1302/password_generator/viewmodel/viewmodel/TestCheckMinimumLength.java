package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestCheckMinimumLength {

	@Test
	void testWhenMinimumLengthIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			ViewModel vm = new ViewModel(); 
			vm.checkMinimumLengthText(null);
		});
	}

	@Test
	void testWhenMinimumLengthIsLessThan0() {
		ViewModel vm = new ViewModel(); 
		Boolean result = vm.checkMinimumLengthText("-1");
		assertTrue(result);
	}
	
	@Test
	void testWhenMinimumLengthIs0() {
		ViewModel vm = new ViewModel(); 
		Boolean result = vm.checkMinimumLengthText("0");
		assertTrue(result);
	}
	
	@Test
	void testWhenMinimumLengthIsGreaterThan0() {
		ViewModel vm = new ViewModel(); 
		Boolean result = vm.checkMinimumLengthText("1");
		assertFalse(result);
	}
}
