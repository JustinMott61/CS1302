package edu.westga.cs1302.password_generator.tests.viewmodel.password_view_model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.PasswordViewModel;

class TestUpdatePassword {

	@Test
	void testWhenlowerCaseNeededIsChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(false);
		passwordBinding.lowercaseNeeded().setValue(true);
		passwordBinding.uppercaseNeeded().setValue(false);
		passwordBinding.minimumLength().setValue(1);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() == 1);
		assertTrue(result.matches(".*[a-z].*"));
	}
	
	@Test
	void testWhenUpperCaseNeededIsChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(false);
		passwordBinding.lowercaseNeeded().setValue(false);
		passwordBinding.uppercaseNeeded().setValue(true);
		passwordBinding.minimumLength().setValue(1);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() == 1);
		assertTrue(result.matches(".*[A-Z].*"));
	}
	
	@Test
	void testWhenDigitsNeededIsChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(true);
		passwordBinding.lowercaseNeeded().setValue(false);
		passwordBinding.uppercaseNeeded().setValue(false);
		passwordBinding.minimumLength().setValue(1);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() == 1);
		assertTrue(result.matches(".*[0-9].*"));
	}
	
	@Test
	void testWhenAllAreCheckChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(true);
		passwordBinding.lowercaseNeeded().setValue(true);
		passwordBinding.uppercaseNeeded().setValue(true);
		passwordBinding.minimumLength().setValue(10);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() >= 10);
		assertTrue(result.matches(".*[0-9].*"));
		assertTrue(result.matches(".*[A-Z].*"));
		assertTrue(result.matches(".*[a-z].*"));
	}
	
	@Test
	void testWhenNoOptionsAreChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(false);
		passwordBinding.lowercaseNeeded().setValue(false);
		passwordBinding.uppercaseNeeded().setValue(false);
		passwordBinding.minimumLength().setValue(10);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() >= 10);
		assertTrue(result.matches(".*[a-z].*"));
		assertTrue(result.matches(".*[A-Z].*"));
		assertTrue(result.matches(".*[0-9].*"));
	}
	@Test
	void testWhenDigitsNeededIsCheckedAndLowercaseNeededIsChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(true);
		passwordBinding.lowercaseNeeded().setValue(true);
		passwordBinding.uppercaseNeeded().setValue(false);
		passwordBinding.minimumLength().setValue(2);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() >= 2);
		assertTrue(result.matches(".*[0-9].*"));
		assertTrue(result.matches(".*[a-z].*"));
	}
	
	@Test
	void testWhenDigitsNeededIsCheckedAndUppercaseNeededIsChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(true);
		passwordBinding.lowercaseNeeded().setValue(false);
		passwordBinding.uppercaseNeeded().setValue(true);
		passwordBinding.minimumLength().setValue(2);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() >= 2);
		assertTrue(result.matches(".*[0-9].*"));
		assertTrue(result.matches(".*[A-Z].*"));
	}
	
	@Test
	void testWhenLowercaseNeededIsCheckedAndUppercaseNeededIsChecked() {
		PasswordViewModel passwordBinding = new PasswordViewModel();
		passwordBinding.digitsNeeded().setValue(false);
		passwordBinding.lowercaseNeeded().setValue(true);
		passwordBinding.uppercaseNeeded().setValue(true);
		passwordBinding.minimumLength().setValue(2);
		passwordBinding.updatePassword();
		
		String result = passwordBinding.resultedPassword().getValue();
		
		assertTrue(result.length() >= 2);
		assertTrue(result.matches(".*[a-z].*"));
		assertTrue(result.matches(".*[A-Z].*"));
	}
}
