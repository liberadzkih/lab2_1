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
    @Test
    void searchforelement_seqlenlongerthen1_elementisfirst() {
        int elementToBeFound = 4;
        int i = 0;
        int[] seq = new int[5];
        seq[0] = elementToBeFound;
        seq[1] = 1;
        seq[2] = 2;
        seq[3] = 3;
        seq[4] = 4;


        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seq[i]);
    }
    @Test
    void searchforelement_seqlenlongerthen1_elementislast() {
        int elementToBeFound = 5;
        int i = 4;
        int[] seq = new int[5];
        seq[0] = 1;
        seq[1] = 2;
        seq[2] = 3;
        seq[3] = 4;
        seq[4] = elementToBeFound;


        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seq[i]);
    }
}