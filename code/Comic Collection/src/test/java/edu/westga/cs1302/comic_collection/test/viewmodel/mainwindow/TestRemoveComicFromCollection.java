package edu.westga.cs1302.comic_collection.test.viewmodel.mainwindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.wesga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestRemoveComicFromCollection {

//	@Test
//	void testInvalidCollection() {
//		assertThrows(IllegalArgumentException.class, ()-> {
//			MainWindowViewModel vm = new MainWindowViewModel();
//			Comic comic = new Comic("Wolervine", 909);
//			vm.removeComicFromCollection(null, comic);
//		});
//	}
//	
//	@Test
//	void testInvalidComic() {
//		assertThrows(IllegalArgumentException.class, ()-> {
//			MainWindowViewModel vm = new MainWindowViewModel();
//			Collection collection = new Collection("X-Men Comic");
//			vm.removeComicFromCollection(collection, null);
//		});
//	}
//
//	@Test
//	void testRemoving1Comic() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		Collection collection = new Collection("X-Men Comic");
//		
//		vm.getComicTitle().set("X-Men Zombies");
//		vm.getComicIssueNumber().set(301);
//		vm.addComicToCollection(collection);
//		vm.getComicTitle().set("X-Men vs. Avengers");
//		vm.getComicIssueNumber().set(890);
//		vm.addComicToCollection(collection);
//		vm.getComicTitle().set("Wolverine");
//		vm.getComicIssueNumber().set(450);
//		vm.addComicToCollection(collection);
//		vm.removeComicFromCollection(collection, collection.getComics().get(0));
//		
//		int result = collection.getComics().size();
//		
//		assertEquals(2, result);
//	
//	}
//	
//	@Test
//	void testRemoving2Comics() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		Collection collection = new Collection("X-Men Comic");
//		
//		vm.getComicTitle().set("X-Men Zombies");
//		vm.getComicIssueNumber().set(301);
//		vm.addComicToCollection(collection);
//		vm.getComicTitle().set("X-Men vs. Avengers");
//		vm.getComicIssueNumber().set(890);
//		vm.addComicToCollection(collection);
//		vm.getComicTitle().set("Wolverine");
//		vm.getComicIssueNumber().set(450);
//		vm.addComicToCollection(collection);
//		
//		vm.removeComicFromCollection(collection, collection.getComics().get(0));
//		vm.removeComicFromCollection(collection, collection.getComics().get(1));
//		
//		int result = collection.getComics().size();
//		
//		assertEquals(1, result);
//	
//	}
}
