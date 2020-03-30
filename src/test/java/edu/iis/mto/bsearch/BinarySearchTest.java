package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    void search_for_one_element_when_has_it_should_found_it(){
        int[] sampleSingleArray ={1};
        BinarySearch binarySearch = new BinarySearch();

        SearchResult searchResult=binarySearch.search(1, sampleSingleArray);

        assertTrue(searchResult.isFound());
        assertEquals(0,searchResult.getPosition());
    }

    @Test
    void search_for_one_element_when_has_not_it_should_return_negative_value(){
        int[] sampleSingleArray ={1};
        BinarySearch binarySearch = new BinarySearch();
        SearchResult searchResult=binarySearch.search(2, sampleSingleArray);

        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }

    @Test
    void search_for_many_elements_when_has_it_as_first_should_found_it(){
        int[] sampleMultiArray ={1,2,3};
        BinarySearch binarySearch = new BinarySearch();
        SearchResult searchResult=binarySearch.search(1, sampleMultiArray);

        assertTrue(searchResult.isFound());
        assertEquals(0,searchResult.getPosition());
    }

    @Test
    void search_for_many_elements_when_has_it_as_last_should_found_it(){
        int[] sampleMultiArray ={1,2,3};
        BinarySearch binarySearch = new BinarySearch();
        SearchResult searchResult=binarySearch.search(3, sampleMultiArray);

        assertTrue(searchResult.isFound());
        assertEquals(2,searchResult.getPosition());
    }

}
