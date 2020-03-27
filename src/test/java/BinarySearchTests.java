import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {

    private BinarySearch binarySearch =  BinarySearch.create();
    final int[] emptySeq = {};
    final int[] oneElemSeq = {0};
    final int[] multipleSeq = {0, 1, 2 ,3 , 4};

    @Test
    void elementExistInSequenceTest() {
        SearchResult searchResult = binarySearch.search(0, oneElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
    }

    @Test
    void elementDoesNotExistInSequenceTest(){
        SearchResult searchResult = binarySearch.search(1, oneElemSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void  elementExistOnFirstPositionTest(){
        SearchResult searchResult = binarySearch.search(0, multipleSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
    }

    @Test
    void  elementExistOnLastPositionTest(){
        SearchResult searchResult = binarySearch.search(4, multipleSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(4, searchResult.getPosition());
    }

    @Test
    void  elementExistOnMiddlePositionTest(){
        SearchResult searchResult = binarySearch.search(2, multipleSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(2, searchResult.getPosition());
    }

    @Test
    void  elementDoesNotExistInSequenceTest2(){
        SearchResult searchResult = binarySearch.search(5, multipleSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void illegalArgumentExceptionTest(){
        try{
            binarySearch.search(0, emptySeq);
            Assertions.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e){

        }
    }

}
