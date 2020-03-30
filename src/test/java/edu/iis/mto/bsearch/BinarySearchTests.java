package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {
    private int[] singleSeq = {5};
    private BinarySearch binarySearch = new BinarySearch();

    @Test
    public void elementIsInSingleElementSequence() {
        int elementToBeFound = 5;
        SearchResult searchResult= binarySearch.search(elementToBeFound, singleSeq);

        Assertions.assertEquals(true, searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(elementToBeFound, singleSeq[searchResult.getPosition()]);
    }
}
