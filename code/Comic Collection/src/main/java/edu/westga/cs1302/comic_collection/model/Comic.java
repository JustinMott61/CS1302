package edu.westga.cs1302.comic_collection.model;

/**Initializes a comic book
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class Comic {
	private String name;
	private int issueNum;
	
	/**creates a comic book with a name and an issue number
	 * 
	 * @precondition !name.isEmpty() && !name.isBlank() && !name.equals(null)
	 *               issueNum > 0
	 * @postcondition none
	 * 
	 * @param name the title of the comic book
	 * @param serialNum the serial number of the comic book
	 */
	public Comic(String name, int issueNum) {
		if (((name.isEmpty()) || (name.isBlank()) || (name.equals(null)))) {
			throw new IllegalArgumentException("Please provide a valid comic name.");
		}
		if (issueNum <= 0) {
			throw new IllegalArgumentException("Please proovide valid comic serial number.");
		}
		this.name = name;
		this.issueNum = issueNum;
	}
	
	/**Gets the title of a comic book
	 * 
	 * @return title of comic book
	 */
	public String getName() {
		return this.name;
	}
	
	/**Gets the issue number of a comic book
	 * 
	 * @return serial number of comic book
	 */
	public int getIssueNum() {
		return this.issueNum;
	}
}
