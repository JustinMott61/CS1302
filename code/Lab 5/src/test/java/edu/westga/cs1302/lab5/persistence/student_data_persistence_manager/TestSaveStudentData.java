package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestSaveStudentData {

	@Test
	void testNoStudents() throws IllegalArgumentException, IOException {
		StudentDataPersistenceManager.saveStudentData(new Student[0], "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		try (Scanner reader = new Scanner(inputFile)) {
		     assertFalse(reader.hasNextLine(), "checking if file is empty (should have no lines)");
		}
	}
	
	@Test
	void testNullArray() throws IllegalArgumentException, IOException{
		Student[] student= new Student[1];
		student[0] = null;
		StudentDataPersistenceManager.saveStudentData(student, "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		try (Scanner reader = new Scanner(inputFile)) {
		     assertFalse(reader.hasNextLine(), "Checks for null array");
		}
	}

	@Test
	void testNullStudentFirst() throws IllegalArgumentException, IOException{
		Student[] students = new Student[2];
		Student smplStudent = new Student("Justin Mott", 23);
		students[0] = null;
		students[1] = smplStudent;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		try (Scanner reader = new Scanner(inputFile)) {
		     assertTrue(reader.hasNextLine(), "Checks for when first student null: List should still be valid");
		}
	}
	
	@Test
	void testNullSecondStudent() throws IllegalArgumentException, IOException{
		Student[] students = new Student[2];
		Student smplStudent = new Student("Justin Mott", 23);
		students[1] = null;
		students[0] = smplStudent;
		StudentDataPersistenceManager.saveStudentData(students, "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		try (Scanner reader = new Scanner(inputFile)) {
		     assertTrue(reader.hasNextLine(), "Checks for when second student null: List should still be valid");
		}
	}
}
