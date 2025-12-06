package edu.westga.cs1302.comic_collection.test.model.comic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Comic;

class TestConstructor {

	@Test
	void testNullComicName() {
		assertThrows(NullPointerException.class, () -> {
			new Comic(null, 1);
		});
	}

	@Test
	void testEmptyComicName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic("", 1);
		});
	}
	
	@Test
	void testBlankComicName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic(" ", 1);
		});
	}
	
	@Test
	void serialNumberIs0() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic("X-men", 0);
		});
	}
	
	@Test
	void serialNumberIsLessThan0() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Comic("X-men", -1);
		});
	}
	
	@Test
	void validConstructor() {
		Comic comic = new Comic("X-Men", 1);
		
		String actual1 = comic.getName();
		int actual2 = comic.getIssueNum();
		
		assertEquals("X-Men", actual1);
		assertEquals(1, actual2);
	}
}
