package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

/**Stores the information of a ContainerTask
 * 
 * @author Justin Mott
 * @version Fall 2025
 */
public class ContainerTask extends Task {
	private ArrayList<Task> subTasks;
	
	/**Creates a ContainerTask with the specified name, description, and priority
	 * 
	 * @param name the name given by the Task class
	 * @param description the description given by the Task class
	 * @param priority the priority given by the Task class
	 */
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		this.subTasks = new ArrayList<Task>();
	}

	/** Adds a task to the subtasks and then returns itself
	 * 
	 * 
	 */
	@Override
	public ContainerTask addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Input task can't be null");
		}
		this.subTasks.add(task);
		return this;
	}

	@Override
	public ArrayList<Task> getSubTasks() {
		return this.subTasks;
	}
	
	/**Overrides the toString() in the task class to inform that it has a subTask
	 * 
	 */
	@Override
	public String toString() {
		return this.name + "(+)";
	}
}
