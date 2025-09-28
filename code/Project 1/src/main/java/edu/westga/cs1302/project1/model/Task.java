package edu.westga.cs1302.project1.model;

/**Initializes the creation of a new task
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class Task {
	private final String name;
	private String description;
	private final int priority;
	
	/**Creates a new Task with a name, description, and a priority
	 * 
	 * @precondition name != null, description != null, priority != 0
	 *               name can't be blank, name can't be empty
	 *               description can't be blank, description can't be empty
	 * @postcondition A successfully created task
	 * 
	 * @param name the name of the Task
	 * @param description the description of the task
	 * @param priority the priority level of the task
	 */
	public Task(String name, String description, int priority) {
		if ((name == null) || (name.isBlank()) || (name.isBlank())) {
			throw new IllegalArgumentException("Name can't be empty");
		} 
		if ((description == null) || (description.isEmpty()) || (description.isBlank())) {
			throw new IllegalArgumentException("Description can't be empty");
		} 
		if (priority <= 0) {
			throw new IllegalArgumentException("Priority can't be less than or equal to 0");
		}

		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	/**Gets the name of a Task
	 * 
	 * @return task name
	 */
	public String getName() {
		return this.name;
	}
	
	/**Gets the description of a task
	 * 
	 * @return task description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**Gets the priority of a task
	 * 
	 * @return task priority
	 */
	public int getPriority() {
		return this.priority;
	}
    
	/**Updates the description of a task
	 * 
	 * @precondition updatedDescription can't be null, updatedDescription can't be empty
	 *               updatedDescription can't be blank
	 * @postcondition updates a task with a valid description
	 * @param updatedDescription the description replacing the previous description
	 */
	public void updateDescription(String updatedDescription) {
		if ((updatedDescription == null) || (updatedDescription.isEmpty()) || (updatedDescription.isBlank())) {
			throw new IllegalArgumentException("Updated description can't be empty");
		} 
		this.description = updatedDescription;
	}
	
	/**Makes task on list appear as name of task
	 * 
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
