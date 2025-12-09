package edu.westga.cs1302.comic_collection.test.model.Collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestRemoveComic {

	@Test
	void test() {
		assertThrows(IllegalArgumentException.class, () -> {
			Collection collection = new Collection("X-men");
			collection.removeComic(null);
		});
	}

	@Test
	void testRemove1Comic() {
		Collection collection = new Collection("X-Men");
		Comic comic1 = new Comic("Wolverine", 890);
		Comic comic2 = new Comic("Gambit", 240);
		Comic comic3 = new Comic("Rogue", 380);
		collection.addComic(comic1);
		collection.addComic(comic2);
		collection.addComic(comic3);
		collection.removeComic(comic1);
		
		int result = collection.getComics().size();
		
		assertEquals(2, result);
	}
	
	@Test
	void testRemove2Comics() {
		Collection collection = new Collection("X-Men");
		Comic comic1 = new Comic("Wolverine", 890);
		Comic comic2 = new Comic("Gambit", 240);
		Comic comic3 = new Comic("Rogue", 380);
		collection.addComic(comic1);
		collection.addComic(comic2);
		collection.addComic(comic3);
		collection.removeComic(comic1);
		collection.removeComic(comic2);
		
		int result = collection.getComics().size();
		
		assertEquals(1, result);
	}
	
	@Test
	void testRemove3Comics() {
		Collection collection = new Collection("X-Men");
		Comic comic1 = new Comic("Wolverine", 890);
		Comic comic2 = new Comic("Gambit", 240);
		Comic comic3 = new Comic("Rogue", 380);
		collection.addComic(comic1);
		collection.addComic(comic2);
		collection.addComic(comic3);
		collection.removeComic(comic1);
		collection.removeComic(comic2);
		collection.removeComic(comic3);
		
		int result = collection.getComics().size();
		
		assertEquals(0, result);
	}
}
