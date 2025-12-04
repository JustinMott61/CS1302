package edu.westga.cs1302.comic_collection.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.wesga.cs1302.comic_collection.viewmodel.ViewModel;
import edu.westga.cs1302.comic_collection.model.Collection;

class TestAddCollection {

	@Test
	void testNullCollectionAdded() {
		assertThrows(IllegalArgumentException.class, () -> {
			ViewModel vm = new ViewModel();
			vm.addCollection();
		});
	}
	
	/**Checks to make sure that the model errors will come through
	 * 
	 */
	@Test
	void testEmptyCollectionAdded() {
		assertThrows(IllegalArgumentException.class, () -> {
			ViewModel vm = new ViewModel();
			vm.getName().set("");
			vm.addCollection();
		});
	}
	
	/**Checks to make sure the model errors will come through
	 * 
	 */
	@Test
	void testBlankCollectionAdded() {
		assertThrows(IllegalArgumentException.class, () -> {
			ViewModel vm = new ViewModel();
			vm.getName().set(" ");
			vm.addCollection();
		});
	}
	
	@Test
	void testAdd1Collection() {
		ViewModel vm = new ViewModel();
		vm.getName().set("X-Men");
		vm.addCollection();
		
		Collection actual = vm.getCollections().get(0);
		
		assertEquals("X-Men", actual.getName());
	}
	
	@Test
	void testAdd2Collections() {
		ViewModel vm = new ViewModel();
		vm.getName().set("X-Men");
		vm.addCollection();
		vm.getName().set("Avengers");
		vm.addCollection();
		
		Collection actual1 = vm.getCollections().get(0);
		Collection actual2 = vm.getCollections().get(1);
		
		assertEquals("X-Men", actual1.getName());
		assertEquals("Avengers", actual2.getName());
	}

}
