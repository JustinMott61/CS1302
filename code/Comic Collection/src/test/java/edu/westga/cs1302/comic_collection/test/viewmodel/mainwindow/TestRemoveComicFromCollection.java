package edu.westga.cs1302.comic_collection.test.viewmodel.mainwindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.wesga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestRemoveComicFromCollection {

	@Test
	void testInvalidData() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.removeComicFromCollection(null, null);
		});
	}
	
	@Test
	void testInvalidCollection() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			Comic comic = new Comic("Xdudes", 89);
			vm.removeComicFromCollection(null, comic);
		});
	}

	@Test
	void testInvalidComic() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			Collection collection = new Collection("X-Men");
			vm.removeComicFromCollection(collection, null);
		});
	}
	
	@Test
	void testRemoveComicFromCollection() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Collection collection = new Collection("X-Men");
		Comic comic1 = new Comic("X",909);
		Comic comic2 = new Comic("days", 910);
		vm.addComicToCollection(collection, comic1);
		vm.addComicToCollection(collection, comic2);
		vm.removeComicFromCollection(collection, comic1);
		
		int result = collection.getComics().size();
		
		assertEquals(1, result);
	}

}
