package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchResultTest {

    BinarySearch binarySearch = BinarySearch.create();
    SearchResult searchResult;
    int[] emptySequence = {};
    int[] sequenceWithOneElement = { 1 };
    int[] sequenceWithMultipleElements = { 10, 20, 30, 40, 50 };

    @Test
    void shouldReturnTrueWhenFoundInLengthOne() {
        int searchedElement = 1;
        searchResult = binarySearch.search(searchedElement, sequenceWithOneElement);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
        assertEquals(searchedElement, sequenceWithOneElement[searchResult.getPosition()]);
    }

    @Test
    void shouldReturnFalseWhenNotFoundInLengthOneSeq() {
        int searchedElement = 2;
        searchResult = binarySearch.search(searchedElement, sequenceWithOneElement);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void shouldReturnFirstPositionWhenFoundInMultipleElementsSeq() {
        int searchedElement = 10;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
        assertEquals(searchedElement, sequenceWithMultipleElements[searchResult.getPosition()]);
    }

    @Test
    void shouldReturnLastElementWhenFoundInMultipleElementsSeq() {
        int searchedElement = 50;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(4, searchResult.getPosition());
        assertEquals(searchedElement, sequenceWithMultipleElements[searchResult.getPosition()]);
    }

    @Test
    void shouldReturnMiddleElementWhenFoundInMultipleElementSeq() {
        int searchedElement = 30;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(2, searchResult.getPosition());
        assertEquals(searchedElement, sequenceWithMultipleElements[searchResult.getPosition()]);
    }

    @Test
    void shouldReturnFalseWhenNotFoundInMultipleElementSeq() {
        int searchedElement = 60;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void shouldThrowIllegalArgExceptionWhenEmptySeq() {
        int searchedElemet = 0;
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> binarySearch.search(searchedElemet, emptySequence));
        assertEquals("Empty or null sequence", thrown.getMessage());
    }

    @Test
    void shouldThrowIllegarArgrumenExcetpionWhenNullSeq() {
        int searchedElemet = 0;
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> binarySearch.search(searchedElemet, null));
        assertEquals("Empty or null sequence", thrown.getMessage());
    }
}
