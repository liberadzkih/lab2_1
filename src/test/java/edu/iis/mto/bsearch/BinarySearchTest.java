package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private int[] seqshort = {1};
    private int[] seqlong = {1,2,3,4,5};

    @Test
    void searchforelement_seqlen1_elementisinseq() {
        int elementToBeFound = seqshort[0];
        int i = 0;
        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqshort[i]);
    }
    @Test
    void searchforelement_seqlen1_elementisNOTotinseq() {
        int elementToBeFound = 4;
        int i = 0;
        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementisfirst() {
        int elementToBeFound = 1;
        int i = 0;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementislast() {
        int elementToBeFound = 5;
        int i = 4;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementiscenter() {
        int i = 2;
        int elementToBeFound = 3;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertTrue(searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementisNOTinsequence() {
        int elementToBeFound = 6;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}