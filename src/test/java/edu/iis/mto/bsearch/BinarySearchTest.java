package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void elementIsInSequenceLengthEqualsOne() {

        int[] seq = {1};
        final int KEY = 1;
        final int EXPECTED_VALUE = 0;

        SearchResult result = BinarySearch.create().search(KEY, seq);

        Assertions.assertEquals(true, result.isFound());
        Assertions.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test
    public void elementIsNotInSequenceLengthEqualsOne() {

        int[] seq = {3};
        final int KEY = 4;
        final int EXPECTED_VALUE = -1;

        SearchResult result = BinarySearch.create().search(KEY, seq);

        Assertions.assertEquals(false, result.isFound());
        Assertions.assertEquals(EXPECTED_VALUE, result.getPosition());

    }

    @Test
    public void elementIsFirstElementOfSeq() {

        int[] seq = {1, 2, 3, 4};
        final int KEY = 1;
        final int EXPECTED_VALUE = 0;

        SearchResult result = BinarySearch.create().search(KEY, seq);

        Assertions.assertEquals(true, result.isFound());
        Assertions.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test
    public void elementIsLastElementofSeq() {

        int[] seq = {1, 2, 3, 4};
        final int KEY = 4;
        final int EXPECTED_VALUE = seq.length - 1;

        SearchResult result = BinarySearch.create().search(KEY, seq);

        Assertions.assertEquals(true, result.isFound());
        Assertions.assertEquals(EXPECTED_VALUE, result.getPosition());

    }

    @Test
    public void elementIsInTheMiddleOfSeq() {

        int[] seq = {1, 2, 3, 4, 5};
        final int KEY = 3;
        final int EXPECTED_VALUE = seq.length / 2;

        SearchResult result = BinarySearch.create().search(KEY, seq);

        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(EXPECTED_VALUE, result.getPosition());

    }

    @Test
    public void elementIsNotInSequenceLengthEqualsMoreThanOne() {

        int[] seq = {1,2,3,4};
        final int KEY = 5;

        SearchResult result = BinarySearch.create().search(KEY,seq);

        Assertions.assertFalse(result.isFound());

    }

}