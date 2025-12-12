package edu.westga.cs1302.comic_collection.test.viewmodel.mainwindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.wesga.cs1302.comic_collection.viewmodel.ViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestAddComicToCollection {

	@Test
	void testInvalidComic() {
		assertThrows(IllegalArgumentException.class, ()-> {
			ViewModel vm = new ViewModel();
			Collection  colllection = new Collection("Sup");
			vm.addComicToCollection(null, colllection);
		});
	}
	
	@Test
	void testInvalidCollection() {
		assertThrows(IllegalArgumentException.class, ()-> {
			ViewModel vm = new ViewModel();
			Comic comic = new Comic("Hello", 2);
			vm.addComicToCollection(comic, null);
		});
	}
	
	@Test
	void testAdding1Comic() {
		ViewModel vm = new ViewModel();
		Collection collection = new Collection("X-Men Comic");
		Comic comic = new Comic("Hello", 2);
		vm.addComicToCollection(comic,collection);
		
		Comic result = collection.getComics().get(0);
		
		assertEquals("Hello", result.getComicTitle());
		assertEquals(2, result.getComicIssueNum());
	}

	@Test
	void testAdding2Comic() {
		ViewModel vm = new ViewModel();
		Collection collection = new Collection("X-Men Comic");
		Comic comic1 = new Comic("Hello", 2);
		Comic comic2 = new Comic("Bye",3);
		vm.addComicToCollection(comic1,collection);
		vm.addComicToCollection(comic2,collection);
		
		
		Comic result1 = collection.getComics().get(0);
		Comic result2 = collection.getComics().get(1);
		
		
		assertEquals("Hello", result1.getComicTitle());
		assertEquals(2, result1.getComicIssueNum());
		assertEquals("Bye", result2.getComicTitle());
		assertEquals(3, result2.getComicIssueNum());
	}
	
	@Test
	void testAdding3Comic() {
		ViewModel vm = new ViewModel();
		Collection collection = new Collection("X-Men Comic");
		Comic comic1 = new Comic("Hello", 2);
		Comic comic2 = new Comic("Bye",3);
		Comic comic3 = new Comic("Bueno",4);
		vm.addComicToCollection(comic1,collection);
		vm.addComicToCollection(comic2,collection);
		vm.addComicToCollection(comic3,collection);
		
		Comic result1 = collection.getComics().get(0);
		Comic result2 = collection.getComics().get(1);
		Comic result3 = collection.getComics().get(2);
		
		assertEquals("Hello", result1.getComicTitle());
		assertEquals(2, result1.getComicIssueNum());
		assertEquals("Bye", result2.getComicTitle());
		assertEquals(3, result2.getComicIssueNum());
		assertEquals("Bueno", result3.getComicTitle());
		assertEquals(4, result3.getComicIssueNum());
	}
}
