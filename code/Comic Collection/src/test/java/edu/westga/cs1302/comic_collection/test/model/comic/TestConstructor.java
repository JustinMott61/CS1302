package edu.westga.cs1302.comic_collection.test.model.comic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Comic;

class TestConstructor {

	@Test
	void testNullComicTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic(null, 203);
		});
	}
	
	@Test
	void testBlankComicTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic(" ", 203);
		});
	}
	
	@Test
	void testEmptyComicTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic("", 203);
		});
	}
	
	@Test
	void testComicIssueNumberIsLessThan0() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic("", -1);
		});
	}
	
	@Test
	void testComicIssueNumberIs0() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic("", 0);
		});
	}
	
	@Test
	void testValidConstructor() {
		Comic comic = new Comic("Avengers vs. X-Men", 904);
		
		String resultName = comic.getComicTitle();
		int resultIssueNum = comic.getComicIssueNum();
		
		assertEquals("Avengers vs. X-Men", resultName);
		assertEquals(904, resultIssueNum);
	}

}
