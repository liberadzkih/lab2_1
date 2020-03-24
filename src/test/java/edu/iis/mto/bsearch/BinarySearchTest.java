package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private int[] seqshort = {4};
    private int[] seqlong = {4,5,7,9,11};

    @Test
    void searchforelement_seqlen1_elementisinseq() {
        int i = 0;
        int elementToBeFound = seqshort[i];

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertEquals(true, searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqshort[i]);

    }

    @Test
    void searchforelement_seqlen1_elementisNOTotinseq() {
        int i = 0;
        int elementToBeFound = 3;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqshort);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void searchforelement_seqlenlongerthen1_elementisfirst() {
        int i = 0;
        int elementToBeFound = 4;


        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertEquals(true, searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }

    @Test
    void searchforelement_seqlenlongerthen1_elementislast() {
        int i = 4;
        int elementToBeFound = seqlong[i];

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertEquals(true, searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }

    @Test
    void searchforelement_seqlenlongerthen1_elementiscenter() {
        int i = 2;
        int elementToBeFound = seqlong[i];


        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertEquals(true, searchResult.isFound());
        assertEquals(i, searchResult.getPosition());
        assertEquals(elementToBeFound, seqlong[i]);
    }

    @Test
    void searchforelement_seqlenlongerthen1_elementisNOTinsequence() {
        int elementToBeFound = 15;

        SearchResult searchResult = BinarySearch.create().search(elementToBeFound, seqlong);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

}