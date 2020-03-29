package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    private int[] oneElementSeq = new int[]{1};

    @Test
    public void should_SetIsFound_When_ElementIsInSequence () {
        SearchResult result = BinarySearch.create().search(1, oneElementSeq);
        assertTrue(result.isFound());
        //assertEquals(1, oneElementSeq[0]);
        assertEquals(0, result.getPosition());
    }
}