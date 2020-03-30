package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {
    private int[] singleSeq = {5};
    private int[] multipleSeq = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    private BinarySearch binarySearch = new BinarySearch();

    @Test
    public void elementIsInSingleElementSequence() {
        int elementToBeFound = 5;
        SearchResult searchResult = binarySearch.search(elementToBeFound, singleSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, singleSeq[searchResult.getPosition()]);
    }

    @Test
    public void elementIsNotInSingleElementSequence() {
        int elementToBeFound = 2;
        SearchResult searchResult = binarySearch.search(elementToBeFound, singleSeq);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void elementIsFirstInMultipleElementSequence() {
        int elementToBeFound = 2;
        SearchResult searchResult = binarySearch.search(elementToBeFound, multipleSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, multipleSeq[searchResult.getPosition()]);
    }

    @Test
    public void elementIsLastInMultipleElementSequence() {
        int elementToBeFound = 91;
        SearchResult searchResult = binarySearch.search(elementToBeFound, multipleSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(multipleSeq.length-1, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, multipleSeq[searchResult.getPosition()]);
    }

    @Test
    public void elementIsInTheMiddleInMultipleElementSequence() {
        int elementToBeFound = 16;
        SearchResult searchResult = binarySearch.search(elementToBeFound, multipleSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(4, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, multipleSeq[searchResult.getPosition()]);
    }
}
