package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.IncorrectArgumentException;
import items.Place;

class PlaceTest {

	@Test
	void testPlace() {
		try{
			Place p1 = new Place(2);
			Assertions.assertEquals(3,3);
		}
		catch (AssertionError e) {
			
		}
		catch (IncorrectArgumentException e) {
			
		}
	}

	@Test
	void testGetToken() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		int tokens = 3;
		int aTokens = 2;
		try {
			Place p1 = new Place(tokens);
			
		}
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

}
