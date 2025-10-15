package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

/**Changes list of tasks into an ascending order based on priority
 * 
 * @author Justin Mott
 * @version Fall 2025
 */
public class Ascending implements Comparator<Task> {

	/**
	 * Compares a List of Tasks based on ascending priority
	 * 
	 * @precondition o1 != null && o2 != null
	 * @postcondition an ascending list of tasks based on priority (LOW,MEDIUM,HIGH)
	 * 
	 * @return a List in ascending order based on priority
	 */
	@Override
	public int compare(Task o1, Task o2) {
		if ((o1 != null) && (o2 != null)) {
			if ((o1.getPriority() == TaskPriority.LOW) && (o2.getPriority() == TaskPriority.MEDIUM)) {
				return -1;
			}
			if ((o1.getPriority() == TaskPriority.LOW) && (o2.getPriority() == TaskPriority.HIGH)) {
				return -1;
			}
			if ((o1.getPriority() == TaskPriority.MEDIUM) && (o2.getPriority() == TaskPriority.HIGH)) {
				return -1;
			}
			if (o1.getPriority() == o2.getPriority()) {
				return 0;
			}
			if ((o1.getPriority() == TaskPriority.HIGH) && (o2.getPriority() == TaskPriority.LOW)) {
				return 1;
			}
			if ((o1.getPriority() == TaskPriority.HIGH) && (o2.getPriority() == TaskPriority.MEDIUM)) {
				return 1;
			}
			if ((o1.getPriority() == TaskPriority.MEDIUM) && (o2.getPriority() == TaskPriority.LOW)) {
				return 1;
			}
			
		} else {
			throw new IllegalArgumentException("List can't contain a null");
		}
		return 0;
	}
	
	/**Overrides the name to be Ascending on the list to sort tasks
	 * 
	 * @return Ascending
	 */
	@Override
	public String toString() {
		return "Ascending";
	}
}
