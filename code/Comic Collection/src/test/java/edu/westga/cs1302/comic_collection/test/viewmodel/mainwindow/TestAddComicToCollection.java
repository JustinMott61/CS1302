package edu.westga.cs1302.comic_collection.test.viewmodel.mainwindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.wesga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestAddComicToCollection {
	
	@Test
	void testInvalidData() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.addComicToCollection(null, null);
		});
	}

	@Test
	void testInvalidCollection() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			Comic comic = new Comic("Xdudes", 89);
			vm.addComicToCollection(null, comic);
		});
	}

	@Test
	void testInvalidComic() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			Collection collection = new Collection("X-Men");
			vm.addComicToCollection(collection, null);
		});
	}
	
	@Test
	void add1ValidComicToCollection() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Collection collection = new Collection("X-Men");
		Comic comic = new Comic("X",909);
		vm.addComicToCollection(collection, comic);
		
		Comic result = collection.getComics().get(0);
		
		assertEquals(comic.getName(), result.getName());
		assertEquals(comic.getIssueNum(), result.getIssueNum());
	}
	
	@Test
	void add2ValidComicToCollection() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Collection collection = new Collection("X-Men");
		Comic comic1 = new Comic("X",909);
		Comic comic2 = new Comic("days", 910);
		vm.addComicToCollection(collection, comic1);
		vm.addComicToCollection(collection, comic2);
		
		Comic result1 = collection.getComics().get(0);
		Comic result2 = collection.getComics().get(0);
		
		assertEquals(comic1.getName(), result1.getName());
		assertEquals(comic1.getIssueNum(), result1.getIssueNum());
		assertEquals(comic2.getName(), result2.getName());
		assertEquals(comic2.getIssueNum(), result2.getIssueNum());
	}
}
