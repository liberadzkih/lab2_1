package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class SearchResultTest {

    BinarySearch binarySearch = BinarySearch.create();
    SearchResult searchResult;
    int[] emptySequence = {};
    int[] sequenceWithOneElement = { 1 };
    int[] sequenceWithMultipleElements = { 10, 20, 30, 40, 50 };
    String expectedEmptyOrNullSeqException = "Empty or null sequence";

    @Test
    void shouldReturnTrueWhenFoundInLengthOne() {
        int searchedElement = 1;
        searchResult = binarySearch.search(searchedElement, sequenceWithOneElement);
        assertThat(true, is(searchResult.isFound()));
        assertThat(0, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(sequenceWithOneElement[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnFalseWhenNotFoundInLengthOneSeq() {
        int searchedElement = 2;
        searchResult = binarySearch.search(searchedElement, sequenceWithOneElement);
        assertThat(false, is(searchResult.isFound()));
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test
    void shouldReturnFirstPositionWhenFoundInMultipleElementsSeq() {
        int searchedElement = 10;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertThat(true, is(searchResult.isFound()));
        assertThat(0, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(sequenceWithMultipleElements[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnLastElementWhenFoundInMultipleElementsSeq() {
        int searchedElement = 50;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertThat(true, is(searchResult.isFound()));
        assertThat(4, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(sequenceWithMultipleElements[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnMiddleElementWhenFoundInMultipleElementSeq() {
        int searchedElement = 30;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertThat(true, is(searchResult.isFound()));
        assertThat(2, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(sequenceWithMultipleElements[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnFalseWhenNotFoundInMultipleElementSeq() {
        int searchedElement = 60;
        searchResult = binarySearch.search(searchedElement, sequenceWithMultipleElements);
        assertThat(false, is(searchResult.isFound()));
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test
    void shouldThrowIllegalArgExceptionWhenEmptySeq() {
        int searchedElemet = 0;
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> binarySearch.search(searchedElemet, emptySequence));
        assertThat(expectedEmptyOrNullSeqException, equalTo(thrown.getMessage()));
    }

    @Test
    void shouldThrowIllegarArgrumenExcetpionWhenNullSeq() {
        int searchedElemet = 0;
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> binarySearch.search(searchedElemet, null));
        assertThat(expectedEmptyOrNullSeqException, equalTo(thrown.getMessage()));
    }
}
