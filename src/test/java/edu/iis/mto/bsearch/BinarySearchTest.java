package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int[] sampleSingleArray ={1};
    private int[] sampleMultiArray ={1,2,3};
    private BinarySearch binarySearch = new BinarySearch();

    @Test
    void search_for_one_element_when_has_it_should_found_it(){
        SearchResult searchResult=binarySearch.search(1, sampleSingleArray);

        assertTrue(searchResult.isFound());
        assertEquals(0,searchResult.getPosition());
    }

    @Test
    void search_for_one_element_when_has_not_it_should_return_negative_value(){
        SearchResult searchResult=binarySearch.search(2, sampleSingleArray);

        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }

    @Test
    void search_for_many_elements_when_has_it_as_first_should_found_it(){
        SearchResult searchResult=binarySearch.search(1, sampleMultiArray);

        assertTrue(searchResult.isFound());
        assertEquals(0,searchResult.getPosition());
    }

    @Test
    void search_for_many_elements_when_has_it_as_last_should_found_it(){
        SearchResult searchResult=binarySearch.search(3, sampleMultiArray);

        assertTrue(searchResult.isFound());
        assertEquals(2,searchResult.getPosition());
    }

    //example with Hamcrest library
    @Test
    void search_for_many_elements_when_has_not_it_should_return_negative_value(){
        SearchResult searchResult=binarySearch.search(4, sampleMultiArray);

        assertTrue(searchResult.isFound());
        assertThat(searchResult.getPosition(),is(equalTo(-1)));
    }

}
