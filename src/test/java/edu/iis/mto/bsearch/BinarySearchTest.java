package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch binarySearch;
    private int[] singleElementSequence = {1};

    @BeforeEach
    public void setup() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void elementIsInSingleElementSequence() {
        int key = 1;
        SearchResult searchResult;
        searchResult = binarySearch.search(key,singleElementSequence);

        Assertions.assertEquals(true, searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(key,singleElementSequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsNotInSingleElementSequence() {
        int key = 2;
        SearchResult searchResult;
        searchResult = binarySearch.search(key, singleElementSequence);

        Assertions.assertEquals(false, searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());

    }
}