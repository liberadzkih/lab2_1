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

    @Test
    public void fewElementSequence_withKeyAtFirstPosition() {
        int seq[] = {8, 9, 55, 162};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void fewElementSequence_withKeyAtLastPosition() {
        int seq[] = {8, 9, 55, 162};
        int key = 162;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(seq.length - 1, searchResult.getPosition());
    }

    @Test
    public void fewElementSequence_withKeyAtMiddlePosition() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 55;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals((seq.length - 1) / 2, searchResult.getPosition());
    }

    @Test
    public void fewElementSequence_noKeyInside() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 17;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(false, searchResult.isFound());
    }
}
