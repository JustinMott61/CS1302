package edu.westga.cs1302.project1.task;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Task;

class TestUpdateDescription {

	@Test
	void testNullDescriptionUpdate() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("Greeting","Hi",1);
			task.updateDescription(null);
		});
	}
	
	@Test
	void testEmptyDescriptionUpdate() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("Greeting","Hi",1);
			task.updateDescription("");
		});
	}
	
	@Test
	void testBlankUpdate() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("Greeting","Hi",1);
			task.updateDescription(" ");
		});
	}
	
	@Test
	void validDescriptionUpdate() {
		Task task = new Task("Greeting","Hi",1);
		task.updateDescription("This isn't a greeting");
		
		String actual = task.getDescription();
		
		assertEquals("This isn't a greeting", actual);
	}

}
