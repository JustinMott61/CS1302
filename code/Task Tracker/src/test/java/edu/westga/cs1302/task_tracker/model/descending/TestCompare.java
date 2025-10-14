package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

public Descending descending = new Descending();
	
	@Test
	void testWhen1TaskIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task1 = new Task("Important Exam", "Very High priority", TaskPriority.HIGH);
			Task task2 = null;
			descending.compare(task1, task2);
		});
	}

	@Test
	void testWhen2TaskIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task task1 = null;
			Task task2 = null;
			descending.compare(task1, task2);
		});
	}
	
	@Test
	void testWhenBothAreLowPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.LOW);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.LOW);
		int actual = descending.compare(task1, task2);
		assertEquals(0, actual);
	}
	
	@Test
	void testWhenBothAreMediumPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.MEDIUM);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.MEDIUM);
		int actual = descending.compare(task1, task2);
		assertEquals(0, actual);
	}
	
	@Test
	void testWhenBothAreHighPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.HIGH);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.HIGH);
		int actual = descending.compare(task1, task2);
		assertEquals(0, actual);
	}
	
	@Test
	void testWhenOnesLowAndOnesMediumPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.LOW);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.MEDIUM);
		int actual = descending.compare(task1, task2);
		assertEquals(1, actual);
	}
	
	@Test
	void testWhenOnesLowandOnesHighPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.LOW);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.MEDIUM);
		int actual = descending.compare(task1, task2);
		assertEquals(1, actual);
	}
	
	@Test
	void testWhenOnesMediumAndOnesHighPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.MEDIUM);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.HIGH);
		int actual = descending.compare(task1, task2);
		assertEquals(1, actual);
	}
	
	@Test
	void testWhenOnesHighAndOnesLowPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.HIGH);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.LOW);
		int actual = descending.compare(task1, task2);
		assertEquals(-1, actual);
	}
	
	@Test
	void testWhenOnesHighAndOnesMediumPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.HIGH);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.MEDIUM);
		int actual = descending.compare(task1, task2);
		assertEquals(-1, actual);
	}
	
	@Test
	void testWhenOnOnesMediumAndOnesLowPriority() {
		Task task1 = new Task("Get milk", "ran out today", TaskPriority.MEDIUM);
		Task task2 = new Task("Schedule change", "no class today", TaskPriority.LOW);
		int actual = descending.compare(task1, task2);
		assertEquals(-1, actual);
	}

}
