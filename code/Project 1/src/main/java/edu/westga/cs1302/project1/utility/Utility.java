package edu.westga.cs1302.project1.utility;

import edu.westga.cs1302.project1.model.Task;

/**Initializes the utility method to be used freely
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class Utility {
	
	/**Used to access the countNumberOfPriorities method
	 * 
	 */
	public Utility() {
		
	}
	
	/**counts the number of priorities in a list with a given priority
	 * 
	 * @precondition priority != 0 tasks can't have a null
	 * @postcondition the amount of a priority given
	 * 
	 * @param priority the selected priority to be counted
	 * @param tasks the list of tasks to be counted over
	 * @return the amount of a given priority
	 */
	public static int countNumberOfPriorities(int priority, Task[] tasks) {
		if (priority <= 0) {
			throw new IllegalArgumentException("Priority can't be 0 or less");
		}
		int num = 0;
		for (int currentTask = 0; currentTask < tasks.length; currentTask++) {
			int currentNum = tasks[currentTask].getPriority(); 
			if (currentNum == priority) {
				num++;
			}
		}
		return num;
	}
}
