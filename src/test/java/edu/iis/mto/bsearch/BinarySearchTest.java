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

}