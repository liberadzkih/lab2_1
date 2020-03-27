import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {

    private BinarySearch binarySearch =  BinarySearch.create();

    @Test
    void elementExistInSequenceTest() {
        int[] seq = {0};
        SearchResult searchResult = binarySearch.search(0, seq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
    }

    @Test
    void elementDoesNotExistInSequenceTest(){
        int[] seq = {0};
        SearchResult searchResult = binarySearch.search(1, seq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void  elementExistOnFirstPositionTest(){
        int[] seq = {0, 1, 2 ,3 , 4};
        SearchResult searchResult = binarySearch.search(0, seq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
    }

    @Test
    void  elementExistOnLastPositionTest(){
        int[] seq = {0, 1, 2 ,3 , 4};
        SearchResult searchResult = binarySearch.search(4, seq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(4, searchResult.getPosition());
    }

    @Test
    void  elementExistOnMiddlePositionTest(){
        int[] seq = {0, 1, 2 ,3 , 4};
        SearchResult searchResult = binarySearch.search(2, seq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(2, searchResult.getPosition());
    }

    @Test
    void  elementDoesNotExistInSequenceTest2(){
        int[] seq = {0, 1, 2 ,3 , 4};
        SearchResult searchResult = binarySearch.search(5, seq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

}
