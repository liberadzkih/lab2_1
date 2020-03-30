package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {
    private int[] singleSeq = {5};
    private int[] multipleSeq = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    private int[] duplicateContainingSeq = {2, 2, 3, 4, 5};
    private int[] duplicateOnlySeq = {5, 5, 5, 5, 5, 5};
    private int[] unsortedSeq = {123, 11, 2, 3, 4, 5};
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
        Assertions.assertEquals(multipleSeq.length - 1, searchResult.getPosition());
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

    @Test
    public void elementIsNotInMultipleElementSequence() {
        int elementToBeFound = 123;
        SearchResult searchResult = binarySearch.search(elementToBeFound, multipleSeq);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void sequenceIsNull() {
        int elementToBeFound = 91;
        Assertions.assertThrows(NullPointerException.class, () -> {
            SearchResult searchResult = binarySearch.search(elementToBeFound, null);
        });
    }

    @Test
    public void elementIsFirstInSequenceContainingDuplicates() {
        int elementToBeFound = 2;
        SearchResult searchResult = binarySearch.search(elementToBeFound, duplicateContainingSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, duplicateContainingSeq[searchResult.getPosition()]);
    }

    @Test
    public void elementIsLastInSequenceContainingDuplicates() {
        int elementToBeFound = 5;
        SearchResult searchResult = binarySearch.search(elementToBeFound, duplicateContainingSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(duplicateContainingSeq.length - 1, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, duplicateContainingSeq[searchResult.getPosition()]);
    }

    @Test
    public void elementIsSequenceContainingOnlyDuplicates() {
        int elementToBeFound = 5;
        SearchResult searchResult = binarySearch.search(elementToBeFound, duplicateOnlySeq);

        Assertions.assertTrue(searchResult.isFound());
    }

    @Test
    public void elementInUnsortedSequence() {
        int elementToBeFound = 5;
        SearchResult searchResult = binarySearch.search(elementToBeFound, unsortedSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertNotEquals(-1, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, unsortedSeq[searchResult.getPosition()]);
    }

    @Test
    public void elementNotInUnsortedSequence() {
        int elementToBeFound = 18;
        SearchResult searchResult = binarySearch.search(elementToBeFound, unsortedSeq);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }
}
