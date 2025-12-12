package edu.westga.cs1302.comic_collection.test.viewmodel.mainwindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.wesga.cs1302.comic_collection.viewmodel.ViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestRemoveComicFromCollection {

	@Test
	void testInvalidCollection() {
		assertThrows(IllegalArgumentException.class, ()-> {
			ViewModel vm = new ViewModel();
			Collection collection = new Collection("X-Men Comics");
			vm.removeComicFromCollection(null, collection);
		});
	}
	
	@Test
	void testInvalidComic() {
		assertThrows(IllegalArgumentException.class, ()-> {
			ViewModel vm = new ViewModel();
			Comic comic = new Comic("Wolervine", 909);
			vm.removeComicFromCollection(comic, null);
		});
	}

	@Test
	void testRemoving1Comic() {
		ViewModel vm = new ViewModel();
		Collection collection = new Collection("X-Men Comic");
		Comic comic1 = new Comic("Hello", 2);
		Comic comic2 = new Comic("Bye",3);
		Comic comic3 = new Comic("Bueno",4);
		vm.addComicToCollection(comic1,collection);
		vm.addComicToCollection(comic2,collection);
		vm.addComicToCollection(comic3,collection);
		vm.removeComicFromCollection(comic3, collection);
		
		int result = collection.getComics().size();
		
		assertEquals(2, result);
	}
	
	@Test
	void testRemoving2Comics() {
		ViewModel vm = new ViewModel();
		Collection collection = new Collection("X-Men Comic");
		Comic comic1 = new Comic("Hello", 2);
		Comic comic2 = new Comic("Bye",3);
		Comic comic3 = new Comic("Bueno",4);
		vm.addComicToCollection(comic1,collection);
		vm.addComicToCollection(comic2,collection);
		vm.addComicToCollection(comic3,collection);
		vm.removeComicFromCollection(comic3, collection);
		vm.removeComicFromCollection(comic2, collection);
		
        int result = collection.getComics().size();
		
		assertEquals(1, result);
	}
	
	@Test
	void testRemoving3Comics() {
		ViewModel vm = new ViewModel();
		Collection collection = new Collection("X-Men Comic");
		Comic comic1 = new Comic("Hello", 2);
		Comic comic2 = new Comic("Bye",3);
		Comic comic3 = new Comic("Bueno",4);
		vm.addComicToCollection(comic1,collection);
		vm.addComicToCollection(comic2,collection);
		vm.addComicToCollection(comic3,collection);
		vm.removeComicFromCollection(comic3, collection);
		vm.removeComicFromCollection(comic2, collection);
		vm.removeComicFromCollection(comic1, collection);
		
        int result = collection.getComics().size();
		
		assertEquals(0, result);
	}
}
