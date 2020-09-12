package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchTest {

    @Test
    public void singleElementSequence_withKeyInside_isFoundMethod() {
        int seq[] = {8};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(true, searchResult.isFound());
    }

    @Test
    public void singleElementSequence_withKeyInside_getPositionMethod() {
        int seq[] = {8};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void singleElementSequence_noKeyInside_isFoundMethod() {
        int seq[] = {8};
        int key = 7;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(false, searchResult.isFound());
    }

    @Test
    public void singleElementSequence_noKeyInside_getPositionMethod() {
        int seq[] = {8};
        int key = 7;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void fewElementsSequence_withKeyAtFirstPosition_getPositionMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void fewElementsSequence_withKeyAtFirstPosition_isFoundMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(true, searchResult.isFound());
    }

    @Test
    public void fewElementsSequence_withKeyAtLastPosition_getPositionMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 162;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(seq.length - 1, searchResult.getPosition());
    }

    @Test
    public void fewElementsSequence_withKeyAtLastPosition_isFoundMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 162;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(true, searchResult.isFound());
    }

    @Test
    public void fewElementsSequence_withKeyAtMiddlePosition_getPositionMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 55;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals((seq.length - 1) / 2, searchResult.getPosition());
    }

    @Test
    public void fewElementsSequence_withKeyAtMiddlePosition_isFoundMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 55;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(true, searchResult.isFound());
    }

    @Test
    public void fewElementsSequence_noKeyInside_isFoundMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 17;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(false, searchResult.isFound());
    }

    @Test
    public void fewElementsSequence_noKeyInside_getPositionMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 17;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void zeroElementsSequence_testForException() {
        int seq[] = {};
        int key = 17;
        //SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.create().search(key, seq));
    }

}
