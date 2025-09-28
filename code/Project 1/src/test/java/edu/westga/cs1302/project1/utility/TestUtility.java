package edu.westga.cs1302.project1.utility;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Task;

class TestUtility {

	@Test
	void testWhenPriorityLessThan0() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task[] tasks = new Task[2];
			Task task = new Task("Greeting","Hi",1);
			tasks[1] = task;
			Utility.countNumberOfPriorities(-1, tasks);
		});
	}
	
	@Test
	void testWhenPriorityis0() {
		assertThrows(IllegalArgumentException.class, () -> {
			Task[] tasks = new Task[2];
			Task task = new Task("Greeting","Hi",1);
			tasks[1] = task;
			Utility.countNumberOfPriorities(-1, tasks);
		});
	}
	
	@Test
	void testWhen1OfPriority() {
		Task[] tasks = new Task[2];
		Task task1 = new Task("Greeting","Hi",1);
		Task task2 = new Task("Greeting","Hi",2);
		tasks[0] = task1;
		tasks[1] = task2;
		
		int actual = Utility.countNumberOfPriorities(1, tasks);
		
		assertEquals(1, actual);
	}

	@Test
	void testWhen3OfPriority() {
		Task[] tasks = new Task[4];
		Task task1 = new Task("Greeting","Hi",1);
		Task task2 = new Task("Greeting","Hi",1);
		Task task3 = new Task("Greeting","Hi",1);
		Task task4 = new Task("Greeting","Hi",2);
		tasks[0] = task1;
		tasks[1] = task2;
		tasks[2] = task3;
		tasks[3] = task4;
		
		int actual = Utility.countNumberOfPriorities(1, tasks);
		
		assertEquals(3, actual);
	}
	
}
