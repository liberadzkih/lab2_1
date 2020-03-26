package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch binarySearch = BinarySearch.create();

    @Test
    void search_seqLen1SearchedInSeq_posEq0() {
        int[] seq = {1};
        SearchResult result = binarySearch.search(1,  seq);
        assertEquals(0,  result.getPosition());
    }

    @Test
    void search_seqLen1SearchedNotInSeq_posEqNeg1() {
        int[] seq = {1};
        SearchResult result = binarySearch.search(2,  seq);
        assertEquals(-1,  result.getPosition());
    }

    @Test
    void search_seqLenBiggerThan1SearchedInSeqOnBeginning_posEq0() {
        int[] seq = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SearchResult result = binarySearch.search(0,  seq);
        assertEquals(0, result.getPosition());
    }

    @Test
    void search_seqLenBiggerThan1SearchedInSeqOnEnd_posEq10() {
        int[] seq = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SearchResult result = binarySearch.search(10,  seq);
        assertEquals(10, result.getPosition());
    }

    @Test
    void search_seqLenBiggerThan1SearchedInSeqInMiddle_posEq5() {
        int[] seq = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SearchResult result = binarySearch.search(5,  seq);
        assertEquals(5, result.getPosition());
    }

    @Test
    void search_seqLenBiggerThan1SearchedNotInSeq_posEqNeg1() {
        int[] seq = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SearchResult result = binarySearch.search(2137,  seq);
        assertEquals(-1,  result.getPosition());
    }

    @Test
    void search_seqEmpty_IllegalArgumentException() {
        int[] seq = {};
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> binarySearch.search(2137, seq));
        assertThat(thrown.getCause(), instanceOf(IllegalArgumentException.class));
    }

    
}