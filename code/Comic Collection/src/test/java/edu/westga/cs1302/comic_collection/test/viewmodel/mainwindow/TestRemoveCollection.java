package edu.westga.cs1302.comic_collection.test.viewmodel.mainwindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.wesga.cs1302.comic_collection.viewmodel.MainWindowViewModel;

class TestRemoveCollection {

	@Test
	void testInputNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			MainWindowViewModel vm = new MainWindowViewModel();
			vm.removeCollection(null);
		});
	}
	
	@Test
	void testRemove1Collection() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
		vm.getName().set("X-Men");
		vm.addCollection();
		vm.getName().set("Avengers");
		vm.addCollection();
		vm.getName().set("Justice League");
		vm.addCollection();
		
		vm.removeCollection(vm.getCollections().get(0));
		
		int actual = vm.getCollections().size();
		
		assertEquals(2, actual);
	}

	@Test
	void testRemove2Collections() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
		vm.getName().set("X-Men");
		vm.addCollection();
		vm.getName().set("Avengers");
		vm.addCollection();
		vm.getName().set("Justice League");
		vm.addCollection();
		
		vm.removeCollection(vm.getCollections().get(0));
		vm.removeCollection(vm.getCollections().get(1));
		
		int actual = vm.getCollections().size();
		
		assertEquals(1, actual);
	}
	
}
