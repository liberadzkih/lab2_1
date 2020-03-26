package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchResultTest {

    BinarySearch binarySearch = BinarySearch.create();
    SearchResult searchResult;
    int[] sequenceWithOneElement = {1};

    @Test
    void shouldReturnTrueWhenFoundInLengthOne() {
        int searchedElement = 1;
        searchResult = binarySearch.search(searchedElement, sequenceWithOneElement);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
        assertEquals(searchedElement, sequenceWithOneElement[searchResult.getPosition()]);
    }

    @Test
    void shouldReturnFalseWhenNotFoundInLengthOne() {
        int searchedElement = 2;
        searchResult = binarySearch.search(searchedElement, sequenceWithOneElement);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}
