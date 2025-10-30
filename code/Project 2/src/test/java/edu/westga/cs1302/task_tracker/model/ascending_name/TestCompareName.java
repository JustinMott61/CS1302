package edu.westga.cs1302.task_tracker.model.ascending_name;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.AscendingName;
import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompareName {

	@Test
	void testO1IsNull() {
		Task o1 = new ContainerTask("name", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("name", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new ContainerTask("name", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("name", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(o1, null);});
	}
	
	@Test
	void testO1FirstLetterIsEqualToO2FirstLetter() {
		Task o1 = new ContainerTask("name", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("name", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1FirstLetterIsGreaterThanO2FirstLetter() {
		Task o1 = new ContainerTask("apple", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("broke", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1FirstLetterIsLessThanO2FirstLetter() {
		Task o1 = new ContainerTask("croke", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("broke", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1FirstNumberIsEqualToO2FirstNumber() {
		Task o1 = new ContainerTask("1: name", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("1: name", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1FirstNumberIsGreaterThanO2FirstNumber() {
		Task o1 = new ContainerTask("1: apple", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("2: broke", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1FirstNumberIsLessThanO2FirstNumber() {
		Task o1 = new ContainerTask("2: croke", "desc", TaskPriority.HIGH);
		Task o2 = new ContainerTask("1: broke", "desc", TaskPriority.HIGH);
		AscendingName descending = new AscendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result < 0);
	}
}
