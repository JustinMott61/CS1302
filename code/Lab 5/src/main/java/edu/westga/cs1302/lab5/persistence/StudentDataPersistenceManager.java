package edu.westga.cs1302.lab5.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.lab5.model.Student;

/** Supports saving and loading student data,
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class StudentDataPersistenceManager {
	
	public static final String FILE_LOCATION = "data.txt";
	
	/** Save the students!
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the set of students to save
	 * @throws IllegalArgumentException if precondition is violated
	 * @throws IOException Unable to write to FILE_LOCATION
	 */
	public static void saveStudentData(Student[] students) throws IOException, IllegalArgumentException {
		StudentDataPersistenceManager.saveStudentData(students, StudentDataPersistenceManager.FILE_LOCATION);
	}

	/**Same as the saveStudentData but used for for testing instead
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the set of students to be saved 
	 * @param fileLocation the location of the test file
	 * @throws IOException unable to write FILE_LOcation
	 * @throws IllegalArgumentException if precondition
	 */
	public static void saveStudentData(Student[] students, String fileLocation) throws IOException, IllegalArgumentException {
		if (students == null) {
			throw new IllegalArgumentException("must provide an array of students");
		}
		try (FileWriter writer = new FileWriter(fileLocation)) {
			for (Student currStudent : students) {
				if (currStudent != null) {
				    writer.write(currStudent.getName() + "," + currStudent.getGrade() + System.lineSeparator());
				}
			}
		}
	}
	
	/** Load the students!
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the set of students loaded
	 * @throws FileNotFoundException no file exists at FILE_LOCATION
	 * @throws IOException unable to read file due to formatting issue 
	 */
	public static Student[] loadStudentData() throws FileNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(StudentDataPersistenceManager.FILE_LOCATION);
		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String lineBeingStripped = reader.nextLine();
				String[] currentStudent = lineBeingStripped.split(",");
				String name = currentStudent[0];
				int grade = Integer.parseInt(currentStudent[1]);
				Student student = new Student(name, grade);
				students.add(student);
			}
		} catch (NumberFormatException error) {
			throw new IOException("grade value was not formatted as an integer (" + error.getMessage() + ")");
		} catch (IllegalArgumentException error) {
			throw new IOException(error.getMessage());
		}
		
		return students.toArray(new Student[0]);
	}
}
