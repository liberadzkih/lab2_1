package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private BinarySearch binarySearch = BinarySearch.create();
    private int[] oneElementSequence = { 1 };

    @Test
    public void foundInOneElementSequenceTest() {
        int key = 1;
        SearchResult searchResult = binarySearch.search(key, oneElementSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(key, oneElementSequence[searchResult.getPosition()]);
    }

    @Test
    public void notFoundInOneElementSequenceTest() {
        int key = 0;
        SearchResult searchResult = binarySearch.search(key, oneElementSequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }
}