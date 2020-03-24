package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int[] seq1 = {4};
    private int[] seq2 = {1, 2, 3, 4, 5};

    @Test
    void jestWSekwencji() {
        int index = 0;
        SearchResult searchResult = BinarySearch.create().search(4, seq1);
        assertEquals(true, searchResult.isFound());
        assertEquals(4, seq1[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    void nieMaWSekwencji() {
        SearchResult searchResult = BinarySearch.create().search(1, seq1);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void jestPierwszymElementem() {
        int index = 0;
        SearchResult searchResult = BinarySearch.create().search(1, seq2);
        assertEquals(true, searchResult.isFound());
        assertEquals(1, seq2[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    void jestOstatnimElementem() {
        int index = seq2.length - 1;
        SearchResult searchResult = BinarySearch.create().search(5, seq2);
        assertEquals(true, searchResult.isFound());
        assertEquals(5, seq2[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    void jestSrodkowymElementem() {
        int index = seq2.length / 2;
        SearchResult searchResult = BinarySearch.create().search(3, seq2);
        assertEquals(true, searchResult.isFound());
        assertEquals(3, seq2[index]);
        assertEquals(index, searchResult.getPosition());
    }

    @Test
    void nieMaWSekwencji2() {
        SearchResult searchResult = BinarySearch.create().search(8, seq2);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}