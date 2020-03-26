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

    @Test
    public void sequenceIsNull() {
        assertThrows(NullPointerException.class, () -> {
            searchResult = binarySearch.search(2, null);
        });
    }

    @Test
    public void sequenceIsEmpty() {
        int key = 3;
        int expectedPosition = -1;
        int[] emptySequence = {};
        searchResult = binarySearch.search(key, emptySequence);

        Assertions.assertEquals(false, searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    public void elementsInSequenceAreInWrongOrderNotFound() {
        int key = 1;
        int expectedPosition = -1;
        int[] wrongOrderSequence = {2,5,1};
        searchResult = binarySearch.search(key, wrongOrderSequence);

        //element is in sequence but it cannot be found
        Assertions.assertEquals(false, searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    public void elementsInSequenceAreInWrongOrderFound() {
        int key = 1;
        int expectedPosition = 0;
        int[] wrongOrderSequence = {1,5,2};
        searchResult = binarySearch.search(key, wrongOrderSequence);

        //element is in unsorted sequence, but still can be found
        Assertions.assertEquals(true, searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
        Assertions.assertEquals(key,wrongOrderSequence[searchResult.getPosition()]);
    }
}