package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test void testElementIsInsideSequenceLength1() {
        int testValue = 5;
        int[] analyzedSequence = {5};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test void testElementIsNotInsideSequenceLength1() {
        int testValue = 5;
        int[] analyzedSequence = {7};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test void testElementIsAtFirstPositionSequenceLengthOver1() {
        int testValue = 5;
        int[] analyzedSequence = {5, 7, 9};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }
}
