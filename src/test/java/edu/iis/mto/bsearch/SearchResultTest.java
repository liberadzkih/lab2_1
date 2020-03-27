package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class SearchResultTest {

    final BinarySearch BINARY_SEARCH = BinarySearch.create();
    final int EXPECTED_FAILED_POSITION = -1;
    final int[] SEQUENCE_WITH_ONE_ELEMENT = { 1 };
    final int[] SEQUENCE_WITH_MULTIPLE_ELEMENTS = { 10, 20, 30, 40, 50 };
    final int[] UNSORTED_SEQ_1 = { 60, 10, 20, 30, 40 };
    final int[] UNSORTED_SEQ_2 = { 20, 30, 40, 10, 50 };
    final String EXPECTED_EMPTY_OR_NULL_SEQ_EXCEPTION = "Empty or null sequence";
    SearchResult searchResult;

    @Test
    void shouldReturnTrueWhenFoundInLengthOne() {
        int searchedElement = 1;
        int expectedPosition = 0;
        searchResult = BINARY_SEARCH.search(searchedElement, SEQUENCE_WITH_ONE_ELEMENT);
        assertThat(true, is(searchResult.isFound()));
        assertThat(expectedPosition, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(SEQUENCE_WITH_ONE_ELEMENT[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnFalseWhenNotFoundInLengthOneSeq() {
        int searchedElement = 2;
        searchResult = BINARY_SEARCH.search(searchedElement, SEQUENCE_WITH_ONE_ELEMENT);
        assertThat(false, is(searchResult.isFound()));
        assertThat(EXPECTED_FAILED_POSITION, equalTo(searchResult.getPosition()));
    }

    @Test
    void shouldReturnFirstPositionWhenFoundInMultipleElementsSeq() {
        int searchedElement = 10;
        int expectedPosition = 0;
        searchResult = BINARY_SEARCH.search(searchedElement, SEQUENCE_WITH_MULTIPLE_ELEMENTS);
        assertThat(true, is(searchResult.isFound()));
        assertThat(expectedPosition, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(SEQUENCE_WITH_MULTIPLE_ELEMENTS[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnLastElementWhenFoundInMultipleElementsSeq() {
        int searchedElement = 50;
        int expectedPosition = 4;
        searchResult = BINARY_SEARCH.search(searchedElement, SEQUENCE_WITH_MULTIPLE_ELEMENTS);
        assertThat(true, is(searchResult.isFound()));
        assertThat(expectedPosition, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(SEQUENCE_WITH_MULTIPLE_ELEMENTS[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnMiddleElementWhenFoundInMultipleElementSeq() {
        int searchedElement = 30;
        int expectedPosition = 2;
        searchResult = BINARY_SEARCH.search(searchedElement, SEQUENCE_WITH_MULTIPLE_ELEMENTS);
        assertThat(true, is(searchResult.isFound()));
        assertThat(expectedPosition, equalTo(searchResult.getPosition()));
        assertThat(searchedElement, equalTo(SEQUENCE_WITH_MULTIPLE_ELEMENTS[searchResult.getPosition()]));
    }

    @Test
    void shouldReturnFalseWhenNotFoundInMultipleElementSeq() {
        int searchedElement = 60;
        searchResult = BINARY_SEARCH.search(searchedElement, SEQUENCE_WITH_MULTIPLE_ELEMENTS);
        assertThat(false, is(searchResult.isFound()));
        assertThat(EXPECTED_FAILED_POSITION, equalTo(searchResult.getPosition()));
    }

    @Test
    void shouldThrowIllegalArgExceptionWhenEmptySeq() {
        int searchedElemet = 0;
        int[] emptySequence = {};
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> BINARY_SEARCH.search(searchedElemet, emptySequence));
        assertThat(EXPECTED_EMPTY_OR_NULL_SEQ_EXCEPTION, equalTo(thrown.getMessage()));
    }

    @Test
    void shouldThrowIllegarArgrumenExcetpionWhenNullSeq() {
        int searchedElemet = 0;
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> BINARY_SEARCH.search(searchedElemet, null));
        assertThat(EXPECTED_EMPTY_OR_NULL_SEQ_EXCEPTION, equalTo(thrown.getMessage()));
    }

    @Test
    void shouldReturnFalseWhenElementInUnsortedSeq1() {
        int searchedElement = 60;
        searchResult = BINARY_SEARCH.search(searchedElement, UNSORTED_SEQ_1);
        assertThat(false, is(searchResult.isFound()));
        assertThat(EXPECTED_FAILED_POSITION, equalTo(searchResult.getPosition()));
    }

    @Test
    void shouldReturnFalseWhenElementInUnsortedSeq2() {
        int searchedElement = 60;
        searchResult = BINARY_SEARCH.search(searchedElement, UNSORTED_SEQ_2);
        assertThat(false, is(searchResult.isFound()));
        assertThat(EXPECTED_FAILED_POSITION, equalTo(searchResult.getPosition()));
    }

    @Test
    void shouldReturnFalseWhenNoElementInUnsortedSeq1() {
        int searchedElement = 1;
        searchResult = BINARY_SEARCH.search(searchedElement, UNSORTED_SEQ_1);
        assertThat(false, is(searchResult.isFound()));
        assertThat(EXPECTED_FAILED_POSITION, equalTo(searchResult.getPosition()));
    }

    @Test
    void shouldReturnFalseWhenNoElementInUnsortedSeq2() {
        int searchedElement = 1;
        searchResult = BINARY_SEARCH.search(searchedElement, UNSORTED_SEQ_2);
        assertThat(false, is(searchResult.isFound()));
        assertThat(EXPECTED_FAILED_POSITION, equalTo(searchResult.getPosition()));
    }
}
