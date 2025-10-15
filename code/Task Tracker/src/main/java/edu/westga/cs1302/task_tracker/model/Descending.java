package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class Descending implements Comparator<Task> {

	/**
	 * Compares a List of Tasks based on Descending priority
	 * 
	 * @precondition o1 != null && o2 != null
	 * @postcondition a descending list of tasks based on priority (HIGH,MEDIUM,LOW)
	 * 
	 * @return a List in descending order based on priority
	 */
	@Override
	public int compare(Task o1, Task o2) {
		if ((o1 != null) && (o2 != null)) {
			if ((o1.getPriority() == TaskPriority.LOW) && (o2.getPriority() == TaskPriority.MEDIUM)) {
				return 1;
			}
			if ((o1.getPriority() == TaskPriority.LOW) && (o2.getPriority() == TaskPriority.HIGH)) {
				return 1;
			}
			if ((o1.getPriority() == TaskPriority.MEDIUM) && (o2.getPriority() == TaskPriority.HIGH)) {
				return 1;
			}
			if (o1.getPriority() == o2.getPriority()) {
				return 0;
			}
			if ((o1.getPriority() == TaskPriority.HIGH) && (o2.getPriority() == TaskPriority.LOW)) {
				return -1;
			}
			if ((o1.getPriority() == TaskPriority.HIGH) && (o2.getPriority() == TaskPriority.MEDIUM)) {
				return -1;
			}
			if ((o1.getPriority() == TaskPriority.MEDIUM) && (o2.getPriority() == TaskPriority.LOW)) {
				return -1;
			}
		} else {
			throw new IllegalArgumentException("List can't contain a null");
		}
		return 0;
	}

	/**
	 * Returns the title Descending instead of package name
	 *
	 * @return Descending as package name
	 */
	public String toString() {
		return "Descending";
	}

}
