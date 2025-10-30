package edu.westga.cs1302.task_tracker.container_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.Task;

class TestAddTask {

	@Test
	void testNullTask() {
		ContainerTask container = new ContainerTask("name", "description", TaskPriority.HIGH);
		assertThrows(IllegalArgumentException.class, () -> {
			container.addTask(null);
		});
	}

	@Test 
	void addValidTask() {
		ContainerTask container = new ContainerTask("name", "description", TaskPriority.HIGH);
		Task subTask = new ContainerTask("name", "description", TaskPriority.HIGH);
		container.addTask(subTask);
		
		Task result = container.getSubTasks().get(0);
		
		assertEquals(subTask, result);
	}
	
	@Test 
	void add2ValidTask() {
		ContainerTask container = new ContainerTask("name", "description", TaskPriority.HIGH);
		Task subTask1 = new ContainerTask("name", "description", TaskPriority.HIGH);
		Task subTask2 = new ContainerTask("name", "description", TaskPriority.HIGH);
		container.addTask(subTask1);
		container.addTask(subTask2);
		
		Task result1 = container.getSubTasks().get(0);
		Task result2 = container.getSubTasks().get(1);
		
		assertEquals(subTask1, result1);
		assertEquals(subTask2, result2);
	}
}
