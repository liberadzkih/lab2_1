package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int[] seq1 = {4};
    private int[] seq2 = {1, 2, 3, 4, 5};

    @Test
    public void chceckException_emptySequence_IllegalArgumentException() {
        try {
            SearchResult searchResult = BinarySearch.create().search(0, new int[0]);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void searchForExistingElem_singleElemSequence_itIsInSeq() {
        int index = 0;

        SearchResult searchResult = BinarySearch.create().search(4, seq1);
        assertTrue(searchResult.isFound());
        assertEquals(4, seq1[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    public void searchForNonExistingElem_singleElemSequence_itIsNotInSeq() {
        SearchResult searchResult = BinarySearch.create().search(1, seq1);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_multipleElemSequence_itIsFirst() {
        int index = 0;

        SearchResult searchResult = BinarySearch.create().search(1, seq2);
        assertTrue(searchResult.isFound());
        assertEquals(1, seq2[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_multipleElemSequence_itIsLast() {
        int index = seq2.length - 1;

        SearchResult searchResult = BinarySearch.create().search(5, seq2);
        assertTrue(searchResult.isFound());
        assertEquals(5, seq2[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_multipleElemSequence_itIsMiddle() {
        int index = seq2.length / 2;

        SearchResult searchResult = BinarySearch.create().search(3, seq2);
        assertTrue(searchResult.isFound());
        assertEquals(3, seq2[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_multipleElemSequence_itIsNotInSeq() {
        SearchResult searchResult = BinarySearch.create().search(8, seq2);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}
