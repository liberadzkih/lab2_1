package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private int[] seqshort = {4};
    private int[] seqlong = {4, 5, 7, 9, 11};

    @Test
    void searchForElement_SeqLen1_ElementIsInSeq() {
        int i = 0;
        int elementToBeFound = seqshort[i];

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqshort[i]);

    }

    @Test
    void searchForElement_SeqLen1_ElementIsNototInSeq() {
        int elementToBeFound = 3;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void searchForElement_SeqLenLongerThan1_ElementIsFirst() {
        int i = 0;
        int elementToBeFound = 4;


        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }

    @Test
    void searchForElement_SeqLenLongerThen1_ElementIsLast() {
        int i = 4;
        int elementToBeFound = seqlong[i];

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }

    @Test
    void searchForElement_SeqLenLongerThan1_ElementIsCenter() {
        int i = 2;
        int elementToBeFound = seqlong[i];


        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }

    @Test
    void searchForElement_SeqLenLongerThan1_ElementIsNotInSequence() {
        int elementToBeFound = 15;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void searchForElement_testForSeqLenEqualToZero() {
        try {
            BinarySearch.create().search(4, new int[0]);
            fail("Expected IllegalArgumentExceptiom");
        } catch (IllegalArgumentException e) {
            //ignore this exception is expected
        }
    }
}