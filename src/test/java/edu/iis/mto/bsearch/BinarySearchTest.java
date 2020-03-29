package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void elementIsInSequenceLengthEqualsOne() {

        int[] seq = {1};
        final int KEY = 1;

        SearchResult result = BinarySearch.create().search(KEY, seq);

        Assertions.assertEquals(true, result.isFound());
        Assertions.assertEquals(0, result.getPosition());
    }

    @Test
    public void elementIsNotInSequenceLengthEqualsOne() {

    }

    @Test
    public void elementIsFirstElementOfSeq() {

    }

    @Test
    public void elementIsLastElementofSeq() {

    }

    @Test
    public void elementIsInTheMiddleOfSeq() {

    }

    @Test
    public void elementIsNotInSequenceLengthEqualsMoreThanOne() {

    }

}