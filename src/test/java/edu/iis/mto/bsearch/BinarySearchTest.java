package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test void checkIfElementExists_singleElementSequence() {
        int testValue = 5;
        int[] analyzedSequence = {5};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test void checkIfElementDoesntExist_singleElementSequence() {
        int testValue = 5;
        int[] analyzedSequence = {7};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test void checkIfElementIsAtFirstPosition_multipleElementsSequence() {
        int testValue = 5;
        int[] analyzedSequence = {5, 7, 9};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test void checkIfElementIsAtLastPosition_multipleElementsSequence() {
        int testValue = 5;
        int[] analyzedSequence = {1, 2, 3, 4, 5};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertTrue(result.isFound());
        assertEquals(analyzedSequence.length - 1, result.getPosition());
    }

    @Test void checkIfElementIsAtMiddlePosition_multipleElementsSequence() {
        int testValue = 3;
        int[] analyzedSequence = {1, 2, 3, 4, 5};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertTrue(result.isFound());
        assertEquals(analyzedSequence.length / 2, result.getPosition());
    }

    @Test void checkIfElementDoesntExist_multipleElementsSequence() {
        int testValue = 10;
        int[] analyzedSequence = {1, 2, 3, 4, 5};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(testValue, analyzedSequence);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }
}
