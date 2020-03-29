package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchResultTest {

    @Test
    public void searchingForElementInSeqWithZeroLength() {

        int[] seq = {};
        final int KEY = 5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> BinarySearch.create().search(KEY, seq));

    }
}