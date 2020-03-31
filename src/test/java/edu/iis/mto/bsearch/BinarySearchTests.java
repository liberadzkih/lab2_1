package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTests {
	@Test
	public void keyIsInSequence() {
		int key = 1;
		int[] sequence = { 1 };
		int expected = 0;
		
		SearchResult result = BinarySearch.create().search(key, sequence);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(expected, result.getPosition());
	}
	
	@Test
	public void keyIsNotInSequence() {
		int key = 0;
		int[] sequence = { 1 };
		int expected = -1;
		
		SearchResult result = BinarySearch.create().search(key, sequence);
		Assert.assertFalse(result.isFound());
		Assert.assertEquals(expected, result.getPosition());
	}
	
	@Test
	public void keyIsFirstInSequence() {
		int key = 1;
		int[] sequence = { 1, 2, 3, 4, 5 };
		int expected = 0;
		
		SearchResult result = BinarySearch.create().search(key, sequence);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(expected, result.getPosition());
	}
	
	@Test
	public void keyIsLastInSequence() {
		int key = 5;
		int[] sequence = { 1, 2, 3, 4, 5 };
		int expected = 4;
		
		SearchResult result = BinarySearch.create().search(key, sequence);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(expected, result.getPosition());
	}
	
	@Test
	public void keyIsMiddleInSequence() {
		int key = 3;
		int[] sequence = { 1, 2, 3, 4, 5 };
		int expected = 2;
		
		SearchResult result = BinarySearch.create().search(key, sequence);
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(expected, result.getPosition());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void keyInEmptySequence() {
		int key = 0;
		int[] sequence = { };

		BinarySearch.create().search(key, sequence);
	}
}
