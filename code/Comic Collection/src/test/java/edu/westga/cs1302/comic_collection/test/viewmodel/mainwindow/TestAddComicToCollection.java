package edu.westga.cs1302.comic_collection.test.viewmodel.mainwindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.wesga.cs1302.comic_collection.viewmodel.MainWindowViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestAddComicToCollection {

	@Test
	void testInvalidComic() {
		assertThrows(IllegalArgumentException.class, ()-> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.addComicToCollection(null);
		});
	}
	
	@Test
	void testAdding1Comic() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Collection collection = new Collection("X-Men Comic");
		vm.getComicTitle().set("X-Men Zombies");
		vm.getComicIssueNumber().set(301);
		vm.addComicToCollection(collection);
		
		Comic result = collection.getComics().get(0);
		
		assertEquals("X-Men Zombies", result.getComicTitle());
		assertEquals(301, result.getComicIssueNum());
	}

	@Test
	void testAdding2Comic() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Collection collection = new Collection("X-Men Comic");
		
		vm.getComicTitle().set("X-Men Zombies");
		vm.getComicIssueNumber().set(301);
		vm.addComicToCollection(collection);
		vm.getComicTitle().set("X-Men vs. Avengers");
		vm.getComicIssueNumber().set(890);
		vm.addComicToCollection(collection);
		
		Comic result1 = collection.getComics().get(0);
		Comic result2 = collection.getComics().get(1);
		
		assertEquals("X-Men Zombies", result1.getComicTitle());
		assertEquals(301, result1.getComicIssueNum());
		assertEquals("X-Men vs. Avengers", result2.getComicTitle());
		assertEquals(890, result2.getComicIssueNum());
	}
	
	@Test
	void testAdding3Comic() {
		MainWindowViewModel vm = new MainWindowViewModel();
		Collection collection = new Collection("X-Men Comic");
		
		vm.getComicTitle().set("X-Men Zombies");
		vm.getComicIssueNumber().set(301);
		vm.addComicToCollection(collection);
		vm.getComicTitle().set("X-Men vs. Avengers");
		vm.getComicIssueNumber().set(890);
		vm.addComicToCollection(collection);
		vm.getComicTitle().set("Wolverine");
		vm.getComicIssueNumber().set(450);
		vm.addComicToCollection(collection);
		
		Comic result1 = collection.getComics().get(0);
		Comic result2 = collection.getComics().get(1);
		Comic result3 = collection.getComics().get(2);
		
		assertEquals("X-Men Zombies", result1.getComicTitle());
		assertEquals(301, result1.getComicIssueNum());
		assertEquals("X-Men vs. Avengers", result2.getComicTitle());
		assertEquals(890, result2.getComicIssueNum());
		assertEquals("Wolverine", result3.getComicTitle());
		assertEquals(450, result3.getComicIssueNum());
	}
}
