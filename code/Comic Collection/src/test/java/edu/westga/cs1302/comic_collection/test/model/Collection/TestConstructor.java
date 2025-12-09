package edu.westga.cs1302.comic_collection.test.model.Collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Collection;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(NullPointerException.class, () -> {
			 new Collection(null);
		});
	}

	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> {
			 new Collection("");
		});
	}
	
	@Test
	void testBlankName() {
		assertThrows(IllegalArgumentException.class, () -> {
			 new Collection(" ");
		});
	}
	
	@Test
	void testValidConstructor() {
		Collection collect = new Collection("X-Men");
		String actual = collect.getCollectionName();
		assertEquals("X-Men", actual);
	}
}
