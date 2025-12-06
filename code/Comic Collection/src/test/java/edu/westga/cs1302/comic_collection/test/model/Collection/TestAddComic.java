package edu.westga.cs1302.comic_collection.test.model.Collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestAddComic {

	@Test
	void testInvalidComic() {
		assertThrows(IllegalArgumentException.class, () -> {
			Collection collect = new Collection("X-Men");
			collect.addComic(null);
		});
	}

	@Test
	void testAddingComic() {
		Collection collect = new Collection("X-Men");
		Comic comic = new Comic("Days of Future Past", 101);
		collect.addComic(comic);
		
		String resultName = collect.getComics().get(0).getName();
		int resultNum = collect.getComics().get(0).getIssueNum();
		
		assertEquals("Days of Future Past", resultName);
		assertEquals(101, resultNum);
	}
	
	@Test
	void testAdding2Comics() {
		Collection collect = new Collection("X-Men");
		Comic comic1 = new Comic("Days of Future Past", 101);
		Comic comic2 = new Comic("Avengers: Assemble", 209);
		collect.addComic(comic1);
		collect.addComic(comic2);
		
		String resultName1 = collect.getComics().get(0).getName();
		int resultNum1 = collect.getComics().get(0).getIssueNum();
		String resultName2 = collect.getComics().get(1).getName();
		int resultNum2 = collect.getComics().get(1).getIssueNum();
		
		assertEquals("Days of Future Past", resultName1);
		assertEquals(101, resultNum1);
		assertEquals("Avengers: Assemble", resultName2);
		assertEquals(209, resultNum2);
	}
	
	@Test
	void testAdding3Comics() {
		Collection collect = new Collection("X-Men");
		Comic comic1 = new Comic("Days of Future Past", 101);
		Comic comic2 = new Comic("Avengers: Assemble", 209);
		Comic comic3 = new Comic("Punisher", 408);
		collect.addComic(comic1);
		collect.addComic(comic2);
		collect.addComic(comic3);
		
		String resultName1 = collect.getComics().get(0).getName();
		int resultNum1 = collect.getComics().get(0).getIssueNum();
		String resultName2 = collect.getComics().get(1).getName();
		int resultNum2 = collect.getComics().get(1).getIssueNum();
		String resultName3 = collect.getComics().get(2).getName();
		int resultNum3 = collect.getComics().get(2).getIssueNum();
		
		assertEquals("Days of Future Past", resultName1);
		assertEquals(101, resultNum1);
		assertEquals("Avengers: Assemble", resultName2);
		assertEquals(209, resultNum2);
		assertEquals("Punisher", resultName3);
		assertEquals(408, resultNum3);
	}
}
