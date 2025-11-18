package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestSavePasswordData {

	@Test
	void testMakeSureFileHasNextLine() throws IOException {
		ViewModel vm = new ViewModel();
		File inputFile = new File("test-data.txt");
		
		vm.generatePassword();
		vm.savePasswordData(inputFile);
		
		try (Scanner reader = new Scanner(inputFile)) {
		     assertTrue(reader.hasNextLine(), "checking if file is empty (file should have lines)");
		}
	}
	
	@Test
	void testWhenFileDoesNotHasNextLine() throws IOException {
		ViewModel vm = new ViewModel();
		File inputFile = new File("test-data.txt");
		
		vm.savePasswordData(inputFile);
		
		try (Scanner reader = new Scanner(inputFile)) {
		     assertFalse(reader.hasNextLine(), "checking if file is empty (file should not have lines)");
		}
	}
	@Test
	void testCheckWhenPasswordsUnchecked() throws IOException {
		ViewModel vm = new ViewModel();
		File inputFile = new File("test-data.txt");
		
		vm.generatePassword();
		vm.generatePassword();
		vm.generatePassword();
		vm.savePasswordData(inputFile);
		
		String result1 = vm.getPasswordHistory().get(0);
		String result2 = vm.getPasswordHistory().get(1);
		String result3 = vm.getPasswordHistory().get(2);
		
		try (Scanner reader = new Scanner(inputFile)) {
		     assertEquals(reader.next(), result1);
		     assertEquals(reader.next(), result2);
		     assertEquals(reader.next(), result3);
		}
	}
	
	@Test
	void testCheckWhenPasswordsHaveCheckedMustHaveDigits() throws IOException {
		ViewModel vm = new ViewModel();
		File inputFile = new File("test-data.txt");
		
		vm.getRequireDigits().setValue(true);
		vm.getRequireLowercase().setValue(false);
		vm.getRequireUppercase().setValue(false);
		vm.generatePassword();
		vm.generatePassword();
		vm.generatePassword();
		vm.savePasswordData(inputFile);
		
		String result1 = vm.getPasswordHistory().get(0);
		String result2 = vm.getPasswordHistory().get(1);
		String result3 = vm.getPasswordHistory().get(2);
		
		try (Scanner reader = new Scanner(inputFile)) {
		     assertEquals(reader.next(), result1);
		     assertEquals(reader.next(), result2);
		     assertEquals(reader.next(), result3);
		}
	}
	
	@Test
	void testCheckWhenPasswordsHaveCheckedMustHaveLowerCase() throws IOException {
		ViewModel vm = new ViewModel();
		File inputFile = new File("test-data.txt");
		
		vm.getRequireDigits().setValue(false);
		vm.getRequireLowercase().setValue(true);
		vm.getRequireUppercase().setValue(false);
		vm.generatePassword();
		vm.generatePassword();
		vm.generatePassword();
		vm.savePasswordData(inputFile);

		String result1 = vm.getPasswordHistory().get(0);
		String result2 = vm.getPasswordHistory().get(1);
		String result3 = vm.getPasswordHistory().get(2);
		
		try (Scanner reader = new Scanner(inputFile)) {
		     assertEquals(reader.next(), result1);
		     assertEquals(reader.next(), result2);
		     assertEquals(reader.next(), result3);
		}
	}
	
	@Test
	void testCheckWhenPasswordsHaveCheckedMustHaveUpperCase() throws IOException {
		ViewModel vm = new ViewModel();
		File inputFile = new File("test-data.txt");
		
		vm.getRequireDigits().setValue(false);
		vm.getRequireLowercase().setValue(false);
		vm.getRequireUppercase().setValue(true);
		vm.generatePassword();
		vm.generatePassword();
		vm.generatePassword();
		vm.savePasswordData(inputFile);

		String result1 = vm.getPasswordHistory().get(0);
		String result2 = vm.getPasswordHistory().get(1);
		String result3 = vm.getPasswordHistory().get(2);
		
		try (Scanner reader = new Scanner(inputFile)) {
		     assertEquals(reader.next(), result1);
		     assertEquals(reader.next(), result2);
		     assertEquals(reader.next(), result3);
		}
	}
	
	@Test
	void testCheckWhenPasswordsHaveAllChecked() throws IOException {
		ViewModel vm = new ViewModel();
		File inputFile = new File("test-data.txt");
		
		vm.getRequireDigits().setValue(true);
		vm.getRequireLowercase().setValue(true);
		vm.getRequireUppercase().setValue(true);
		vm.generatePassword();
		vm.generatePassword();
		vm.generatePassword();
		vm.savePasswordData(inputFile);

		String result1 = vm.getPasswordHistory().get(0);
		String result2 = vm.getPasswordHistory().get(1);
		String result3 = vm.getPasswordHistory().get(2);
		
		try (Scanner reader = new Scanner(inputFile)) {
		     assertEquals(reader.next(), result1);
		     assertEquals(reader.next(), result2);
		     assertEquals(reader.next(), result3);
		}
	}
}
