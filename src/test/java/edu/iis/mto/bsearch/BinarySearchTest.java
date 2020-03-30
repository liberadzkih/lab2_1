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

}
