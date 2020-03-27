package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private BinarySearch binarySearch = BinarySearch.create();
    private int[] oneElementSequence = { 1 };
    private int[] fewElementsSequence = { 1, 2, 3, 4, 5 };

    @Test
    public void foundInOneElementSequenceTest() {
        int key = 1;
        SearchResult searchResult = binarySearch.search(key, oneElementSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertNotEquals(-1, searchResult.getPosition());
        Assertions.assertEquals(key, oneElementSequence[searchResult.getPosition()]);
    }

    @Test
    public void notFoundInOneElementSequenceTest() {
        int key = 0;
        SearchResult searchResult = binarySearch.search(key, oneElementSequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void foundAtFirstPositionInFewElementsSequenceTest() {
        int key = 1;
        SearchResult searchResult = binarySearch.search(key, fewElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(key, fewElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void foundAtLastPositionInFewElementsSequenceTest() {
        int key = 5;
        SearchResult searchResult = binarySearch.search(key, fewElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(fewElementsSequence.length - 1, searchResult.getPosition());
        Assertions.assertEquals(key, fewElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void foundAtMiddlePositionInFewElementsSequenceTest() {
        int key = 3;
        SearchResult searchResult = binarySearch.search(key, fewElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(fewElementsSequence.length / 2, searchResult.getPosition());
        Assertions.assertEquals(key, fewElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void notFoundInFewElementsSequenceTest() {
        int key = 6;
        SearchResult searchResult = binarySearch.search(key, fewElementsSequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }
}