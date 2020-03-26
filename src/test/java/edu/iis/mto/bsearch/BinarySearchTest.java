package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch binarySearch;
    SearchResult searchResult;
    private int[] singleElementSequence = {1};
    private int[] multipleElementsSequence = {1,2,3,4,5};

    @BeforeEach
    public void setup() {
        binarySearch = new BinarySearch();
        searchResult = null;
    }

    @Test
    public void elementIsInSingleElementSequence() {
        int key = 1;
        searchResult = binarySearch.search(key,singleElementSequence);

        Assertions.assertEquals(true, searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(key,singleElementSequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsNotInSingleElementSequence() {
        int key = 2;
        searchResult = binarySearch.search(key, singleElementSequence);

        Assertions.assertEquals(false, searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void elementIsFirstInMultipleElementsSequence() {
        int key = 1;
        searchResult = binarySearch.search(key, multipleElementsSequence);

        Assertions.assertEquals(true, searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(key, multipleElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsLastInMultipleElementsSequence() {
        int key = 5;
        int expectedPosition = multipleElementsSequence.length-1;
        searchResult = binarySearch.search(key, multipleElementsSequence);

        Assertions.assertEquals(true, searchResult.isFound());
        Assertions.assertEquals(expectedPosition,searchResult.getPosition());
        Assertions.assertEquals(key, multipleElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsInTheMiddleOfMultipleElementsSequence() {
        int key = 3;
        int expectedPosition = 2;
        searchResult = binarySearch.search(key, multipleElementsSequence);

        Assertions.assertEquals(true, searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
        Assertions.assertEquals(key, multipleElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsNotInTheMultipleElementsSequence() {
        int key = 999;
        int expectedPosition = -1;
        searchResult = binarySearch.search(key, multipleElementsSequence);

        Assertions.assertEquals(false, searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }
}