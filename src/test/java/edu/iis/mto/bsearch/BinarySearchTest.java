package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchTest {

    @Test
    public void singleElementSequence_withKeyInside_isFoundMethod() {
        int seq[] = {8};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(true, equalTo(searchResult.isFound()));
    }

    @Test
    public void singleElementSequence_withKeyInside_getPositionMethod() {
        int seq[] = {8};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(0, equalTo(searchResult.getPosition()));
    }

    @Test
    public void singleElementSequence_noKeyInside_isFoundMethod() {
        int seq[] = {8};
        int key = 7;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(false, equalTo(searchResult.isFound()));
    }

    @Test
    public void singleElementSequence_noKeyInside_getPositionMethod() {
        int seq[] = {8};
        int key = 7;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test
    public void fewElementsSequence_withKeyAtFirstPosition_getPositionMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(0, equalTo(searchResult.getPosition()));
    }

    @Test
    public void fewElementsSequence_withKeyAtFirstPosition_isFoundMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 8;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(true, equalTo(searchResult.isFound()));
    }

    @Test
    public void fewElementsSequence_withKeyAtLastPosition_getPositionMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 162;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(seq.length - 1, equalTo(searchResult.getPosition()));
    }

    @Test
    public void fewElementsSequence_withKeyAtLastPosition_isFoundMethod() {
        int seq[] = {8, 9, 55, 162};
        int key = 162;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(true, equalTo(searchResult.isFound()));
    }

    @Test
    public void fewElementsSequence_withKeyAtMiddlePosition_getPositionMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 55;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat((seq.length - 1) / 2, equalTo(searchResult.getPosition()));
    }

    @Test
    public void fewElementsSequence_withKeyAtMiddlePosition_isFoundMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 55;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(true, equalTo(searchResult.isFound()));
    }

    @Test
    public void fewElementsSequence_noKeyInside_isFoundMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 17;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(false, equalTo(searchResult.isFound()));
    }

    @Test
    public void fewElementsSequence_noKeyInside_getPositionMethod() {
        int seq[] = {8, 9, 55, 162, 199};
        int key = 17;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test
    public void zeroElementsSequence_testForException() {
        int seq[] = {};
        int key = 17;
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.create().search(key, seq));
    }

    @Test
    public void fewNegativeElementsInSequence_keyInside_getPositionMethod() {
        int seq[] = {-13, -11, -9, -4, -2};
        int key = -2;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(4, equalTo(searchResult.getPosition()));
    }

    @Test
    public void fewNegativeElementsInSequence_noKeyInside_getPositionMethod() {
        int seq[] = {-13, -11, -9, -4, -2};
        int key = -6;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(-1, equalTo(searchResult.getPosition()));
    }

    @Test
    public void fewNegativeElementsInSequence_keyInside_isFoundMethod() {
        int seq[] = {-13, -11, -9, -4, -2};
        int key = -4;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(true, equalTo(searchResult.isFound()));
    }

    @Test
    public void fewNegativeElementsInSequence_noKeyInside_isFoundMethod() {
        int seq[] = {-13, -11, -9, -4, -2};
        int key = -6;
        SearchResult searchResult = BinarySearch.create().search(key, seq);
        assertThat(false, equalTo(searchResult.isFound()));
    }

}
