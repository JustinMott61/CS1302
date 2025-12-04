package edu.westga.cs1302.comic_collection.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.wesga.cs1302.comic_collection.viewmodel.ViewModel;

class TestRemoveCollection {

	@Test
	void testInputNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			ViewModel vm = new ViewModel();
			vm.removeCollection(null);
		});
	}
	
	@Test
	void testRemove1Collection() {
		ViewModel vm = new ViewModel();
		
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
		ViewModel vm = new ViewModel();
		
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
