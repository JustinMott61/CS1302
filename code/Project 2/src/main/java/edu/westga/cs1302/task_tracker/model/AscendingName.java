package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Compare two Tasks to identify the correct Ascending ordering of the tasks based on names.
 * 
 * @author Justin Mott
 * @version Fall 2025
 */
public class AscendingName implements Comparator<Task> {
	
	/** Returns a value indicating ordering of the two tasks based 
	 * on Ascending name.
	 * 
	 * @precondition o1 != null && o2 != null
	 * @postcondition none
	 * 
	 * @param o1 the first task to compare
	 * @param o2 the second task to compare
	 * 
	 * @return -1 if o1 goes first
	 * 			0 if o1 and o2 are same
	 * 			1 if o1 goes last
	 */
	@Override
	public int compare(Task o1, Task o2) {
		if ((o1 == null) || o2 == null) {
			throw new IllegalArgumentException("Tasks being compared can't be null");
		}
		char o1FirstLetter = o1.getName().trim().toLowerCase().charAt(0);
		char o2FirstLetter = o2.getName().trim().toLowerCase().charAt(0);
		
		if (o1FirstLetter == o2FirstLetter) {
			return 0;
		}
		if (o1FirstLetter < o2FirstLetter) {
			return 1;
		}
		if (o1FirstLetter > o2FirstLetter) {
			return -1;
		}
		return 0;
	}

	/** Returns the name of the task to represent the task as a String
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the task
	 */
	@Override
	public String toString() {
		return "Ascending (By Name)";
	}
}
