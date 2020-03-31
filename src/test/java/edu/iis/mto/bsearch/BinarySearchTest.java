package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void searchforelement_seqlen1_elementisinseq() {
        int elementToBeFound = 4;
        int i = 0;
        int[] seq = new int[1];
        seq[i] = elementToBeFound;
        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seq[i]);

    }
    @Test
    void searchforelement_seqlen1_elementisNOTotinseq() {
        int elementToBeFound = 4;
        int i = 0;
        int[] seq = new int[1];
        seq[i] = 3;
        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seq);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}