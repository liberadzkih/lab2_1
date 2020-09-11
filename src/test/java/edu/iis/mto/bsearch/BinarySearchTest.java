package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
    public void singleElementSequence_withKeyInside() {
        int seq[] = {8};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(true, searchResult.isFound());
    }

    @Test
    public void singleElementSequence_noKeyInside() {
        int seq[] = {8};
        int key = 7;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(false, searchResult.isFound());
    }

}
