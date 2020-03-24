
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

}
