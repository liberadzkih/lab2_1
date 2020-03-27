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
}
