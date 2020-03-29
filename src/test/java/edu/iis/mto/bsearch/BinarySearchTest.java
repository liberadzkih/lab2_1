package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    private int[] oneElementSeq = new int[]{1};
    private int[] multiElementSeq = new int[]{1, 2, 3};
    private int[] emptySeq = new int[]{};

    @Test
    public void should_FindElement_When_ElementIsInOneElemSequence() {
        SearchResult result = BinarySearch.create().search(1, oneElementSeq);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    public void should_FindNoElement_When_ElementIsNotInSequence() {
        SearchResult result = BinarySearch.create().search(2, oneElementSeq);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test
    public void should_FindElement_When_ElementIsFirstInMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(1, multiElementSeq);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    public void should_FindElement_When_ElementIsLastInMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(3, multiElementSeq);
        assertTrue(result.isFound());
        assertEquals(2, result.getPosition());
    }

    @Test
    public void should_FindElement_When_ElementIsCentreOfMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(2, multiElementSeq);
        assertTrue(result.isFound());
        assertEquals(1, result.getPosition());
    }

    @Test
    public void should_FindNoElement_When_ElementIsNotInMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(4, multiElementSeq);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test (expected = NullPointerException.class)
    public void should_ThrowNullPointerException_When_SequenceLenIsZero () {
        SearchResult result = BinarySearch.create().search(1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_When_SequenceIsNull () {
        SearchResult result = BinarySearch.create().search(1, emptySeq);
    }
}