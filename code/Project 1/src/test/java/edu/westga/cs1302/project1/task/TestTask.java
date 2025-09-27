package edu.westga.cs1302.project1.task;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Task;

class TestTask {

	@Test
	void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null,"hi",1);
		});
	}

	@Test
	void testNameEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("","hi",1);
		});
	}
	
	@Test
	void testNameBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(" ","hi",1);
		});
	}
	
	@Test
	void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Greeting",null,1);
		});
	}
	
	@Test
	void testDescriptionEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Greeting","",1);
		});
	}
	
	@Test
	void testDescriptionBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Greeting"," ",1);
		});
	}
	
	@Test
	void testPriorityLessThan0() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Greeting","Hi",-1);
		});
	}
	
	@Test
	void testPriorityIs0() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Greeting","Hi",0);
		});
	}
	
	@Test
	void testValidConstructor() {
		String name = "Greeting";
		String description = "Hi";
		int priority = 1;
		
		Task actual = new Task(name, description, priority);
		
		assertEquals(name, actual.getName());
		assertEquals(description, actual.getDescription());
		assertEquals(priority, actual.getPriority());
	}
}
