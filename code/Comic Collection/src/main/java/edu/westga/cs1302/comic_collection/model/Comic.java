package edu.westga.cs1302.comic_collection.model;

/**Initializes the creation of a comic
 * 
 * @author Justin Mott
 * @version Fall 2025
 * 
 */
public class Comic {
	private String comicTitle;
	private int comicIssueNum;
	
	/**creates a comic book with a title and issue number
	 * 
	 * @precondition comicTitle != null && !comicTitle.isEmpty() && !comicTitle.isBlank()
	 *               comicIssueNum >= 1
	 * @postcondition makes a comic with specified title and issue number
	 * 
	 * @param comicTitle title of the comic
	 * @param comicIssueNum issue number of the comic
	 */
	public Comic(String comicTitle, int comicIssueNum) {
		if (comicTitle == null || comicTitle.isBlank() || comicTitle.isEmpty()) {
			throw new IllegalArgumentException("Comic has an invalid title");
		}
		if (comicIssueNum <= 0) {
			throw new IllegalArgumentException("Comic has an invalid issue number");
		}
		this.comicTitle = comicTitle;
		this.comicIssueNum = comicIssueNum;
	}
	
	/**Gets the title of a comic
	 * 
	 * @return comic title
	 */
	public String getComicTitle() {
		return this.comicTitle;
	}
	
	/**Gets the issue number of a comic
	 * 
	 * @return comic issue number
	 */
	public int getComicIssueNum() {
		return this.comicIssueNum;
	}
	
	/**Makes the comic appear as the comics title in a list
	 * 
	 */
	@Override
	public String toString() {
		return this.comicTitle;
	}
}
