package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int[] singleElementSequence = {5};
    private int[] multipleElementSequence = {1, 2, 3, 4, 5};

    @Test void checkIfElementExists_singleElementSequence() {
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(5, singleElementSequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test void checkIfElementDoesntExist_singleElementSequence() {
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(1, singleElementSequence);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test void checkIfElementIsAtFirstPosition_multipleElementsSequence() {
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(1, multipleElementSequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test void checkIfElementIsAtLastPosition_multipleElementsSequence() {
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(5, multipleElementSequence);
        assertTrue(result.isFound());
        assertEquals(multipleElementSequence.length - 1, result.getPosition());
    }

    @Test void checkIfElementIsAtMiddlePosition_multipleElementsSequence() {
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(3, multipleElementSequence);
        assertTrue(result.isFound());
        assertEquals(multipleElementSequence.length / 2, result.getPosition());
    }

    @Test void checkIfElementDoesntExist_multipleElementsSequence() {
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(10, multipleElementSequence);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test void checkWhenSequenceIsEmpty() {
        int[] emptySequence = {};
        BinarySearch seeker = new BinarySearch();
        assertThrows(IllegalArgumentException.class, () -> seeker.search(1, emptySequence));
    }

    @Test void checkNegativeIntegerSequenceBehaviour() {
        int[] negativeNumbersSequence = {-5, -4, -3, -2, -1};
        BinarySearch seeker = new BinarySearch();
        SearchResult result = seeker.search(-5, negativeNumbersSequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }
}
