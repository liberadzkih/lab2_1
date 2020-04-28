package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private int[] seqshort;
    private int[] seqlong;

    @Test
    void searchforelement_seqlen1_elementisinseq() {
        seqshort = new int[]{1};
        int elementToBeFound = seqshort[0];
        int i = 0;
        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqshort[i]);
    }
    @Test
    void searchforelement_seqlen1_elementisNOTotinseq() {
        seqshort = new int[]{1};
        int elementToBeFound = 4;
        int i = 0;
        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementisfirst() {
        seqlong = new int[]{1, 2, 3, 3, 3, 3, 3, 3, 4, 5, 9};
        int elementToBeFound = 1;
        int i = 0;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementislast() {
        seqlong = new int[]{1, 2, 3, 4, 1, 2, 3, 4, 5};
        int elementToBeFound = 5;
        int i = 8;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementiscenter() {
        seqlong = new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5};
        int i = 4;
        int elementToBeFound = 3;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementisNOTinsequence() {
        seqlong = new int[]{-1, 3, 3, 3, 3, 3, 9};
        int elementToBeFound = 6;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}