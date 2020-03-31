package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTests {
	private static final int[] EMPTY_SEQUENCE = { };
	private static final int[] ONE_ELEMENT_SEQUENCE = { 10 };
	private static final int[] MULTIPLE_ELEMENT_SEQUENCE = { 10, 20, 30, 40, 50 };
	private static final int ELEMENT_NOT_FOUD_POSITION = -1;
	
	@Test
	public void keyIsInSequence() {
		int key = 10;
		
		SearchResult result = BinarySearch.create().search(key, ONE_ELEMENT_SEQUENCE);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(key, ONE_ELEMENT_SEQUENCE[result.getPosition()]);
	}
	
	@Test
	public void keyIsNotInSequence() {
		int key = 0;
		
		SearchResult result = BinarySearch.create().search(key, ONE_ELEMENT_SEQUENCE);
		Assert.assertFalse(result.isFound());
		Assert.assertEquals(ELEMENT_NOT_FOUD_POSITION, result.getPosition());
	}
	
	@Test
	public void keyIsFirstInSequence() {
		int key = 10;
		
		SearchResult result = BinarySearch.create().search(key, MULTIPLE_ELEMENT_SEQUENCE);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(key, MULTIPLE_ELEMENT_SEQUENCE[result.getPosition()]);
	}
	
	@Test
	public void keyIsLastInSequence() {
		int key = 50;
		
		SearchResult result = BinarySearch.create().search(key, MULTIPLE_ELEMENT_SEQUENCE);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(key, MULTIPLE_ELEMENT_SEQUENCE[result.getPosition()]);
	}
	
	@Test
	public void keyIsMiddleInSequence() {
		int key = 30;
		
		SearchResult result = BinarySearch.create().search(key, MULTIPLE_ELEMENT_SEQUENCE);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(key, MULTIPLE_ELEMENT_SEQUENCE[result.getPosition()]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void keyInEmptySequence() {
		int key = 0;

		BinarySearch.create().search(key, EMPTY_SEQUENCE);
	}
}
