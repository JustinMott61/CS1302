package edu.westga.cs1302.comic_collection.test.model.Collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestAddComic {

	@Test
	void testInvalidComic() {
		assertThrows(IllegalArgumentException.class, () -> {
			Collection collection = new Collection("X-men");
			collection.addComic(null);
		});
	}
	
	@Test
	void testAdding1Comic() {
		Collection collection = new Collection("X-Men");
		Comic comic = new Comic("Wolverine", 890);
		collection.addComic(comic);
		
		String resultTitle = collection.getComics().get(0).getComicTitle();
		int resultNum = collection.getComics().get(0).getComicIssueNum();
		
		assertEquals("Wolverine", resultTitle);
		assertEquals(890, resultNum);
	}
	
	@Test
	void testAdding2Comics() {
		Collection collection = new Collection("X-Men");
		Comic comic1 = new Comic("Wolverine", 890);
		Comic comic2 = new Comic("Gambit", 240);
		collection.addComic(comic1);
		collection.addComic(comic2);
		
		String resultTitle1 = collection.getComics().get(0).getComicTitle();
		int resultNum1 = collection.getComics().get(0).getComicIssueNum();
		String resultTitle2 = collection.getComics().get(1).getComicTitle();
		int resultNum2 = collection.getComics().get(1).getComicIssueNum();
		
		assertEquals("Wolverine", resultTitle1);
		assertEquals(890, resultNum1);
		assertEquals("Gambit", resultTitle2);
		assertEquals(240, resultNum2);
	}
	
	@Test
	void testAdding3Comics() {
		Collection collection = new Collection("X-Men");
		Comic comic1 = new Comic("Wolverine", 890);
		Comic comic2 = new Comic("Gambit", 240);
		Comic comic3 = new Comic("Rogue", 380);
		collection.addComic(comic1);
		collection.addComic(comic2);
		collection.addComic(comic3);
		
		String resultTitle1 = collection.getComics().get(0).getComicTitle();
		int resultNum1 = collection.getComics().get(0).getComicIssueNum();
		String resultTitle2 = collection.getComics().get(1).getComicTitle();
		int resultNum2 = collection.getComics().get(1).getComicIssueNum();
		String resultTitle3 = collection.getComics().get(2).getComicTitle();
		int resultNum3 = collection.getComics().get(2).getComicIssueNum();
		
		assertEquals("Wolverine", resultTitle1);
		assertEquals(890, resultNum1);
		assertEquals("Gambit", resultTitle2);
		assertEquals(240, resultNum2);
		assertEquals("Rogue", resultTitle3);
		assertEquals(380, resultNum3);
	}

}
