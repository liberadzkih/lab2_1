package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    private int[] oneElementSeq = new int[]{1};
    private int[] multiElementSeq = new int[]{1, 2, 3};
    private int[] emptySeq = new int[]{};
    private int[] notSortedSeq = new int[]{2, 1, 3};

    @Test
    public void should_FindElement_When_ElementIsInOneElemSequence() {
        SearchResult result = BinarySearch.create().search(1, oneElementSeq);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), equalTo(0));
    }

    @Test
    public void should_FindNoElement_When_ElementIsNotInSequence() {
        SearchResult result = BinarySearch.create().search(2, oneElementSeq);
        assertFalse(result.isFound());
        assertThat(result.getPosition(), equalTo(-1));
    }

    @Test
    public void should_FindElement_When_ElementIsFirstInMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(1, multiElementSeq);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), equalTo(0));
    }

    @Test
    public void should_FindElement_When_ElementIsLastInMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(3, multiElementSeq);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), equalTo(2));
    }

    @Test
    public void should_FindElement_When_ElementIsCentreOfMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(2, multiElementSeq);
        assertTrue(result.isFound());
        assertThat(result.getPosition(), equalTo(1));
    }

    @Test
    public void should_FindNoElement_When_ElementIsNotInMultiElemSequence() {
        SearchResult result = BinarySearch.create().search(4, multiElementSeq);
        assertFalse(result.isFound());
        assertThat(result.getPosition(), equalTo(-1));
    }

    @Test (expected = NullPointerException.class)
    public void should_ThrowNullPointerException_When_SequenceLenIsZero () {
        BinarySearch.create().search(1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_When_SequenceIsNull () {
        BinarySearch.create().search(1, emptySeq);
    }

    @Test (expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_When_SequenceIsNotSorted () {
        BinarySearch.create().search(1, notSortedSeq);
    }
}