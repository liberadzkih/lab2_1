
import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    @Test
    void elemntIsInTheSeq() {
        int[] seq = {1};
        int positionExpected = 0;
        SearchResult searchResult = BinarySearch.create().search(1, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(positionExpected, searchResult.getPosition());
    }

    @Test
    void elementIsNotInTheSeq() {
        int[] seq = {1};
        int positionExpected = -1;
        SearchResult searchResult = BinarySearch.create().search(2, seq);
        assertEquals(false, searchResult.isFound());
        assertEquals(positionExpected, searchResult.getPosition());
    }

    @Test
    void elementIsTheFirstInTheSeq() {
        int[] seq = {1, 2, 3, 4};
        int positionExpected = 0;
        SearchResult searchResult = BinarySearch.create().search(1, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(positionExpected, searchResult.getPosition());
    }

    @Test
    void elementIsTheLastInTheSeq() {
        int[] seq = {1, 2, 3, 4};
        int positionExpected = 3;
        SearchResult searchResult = BinarySearch.create().search(4, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(positionExpected, searchResult.getPosition());
    }

    @Test
    void elementIsTheMiddleInTheSeq() {
        int[] seq = {1, 2, 3, 4, 5};
        int positionExpected = 2;
        SearchResult searchResult = BinarySearch.create().search(3, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(positionExpected, searchResult.getPosition());
    }
   

}
