import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class BinarySearchTests {

    private BinarySearch binarySearch =  BinarySearch.create();

    @Test
    void elementExistInSequenceTest() {
        int[] seq = {0};
        SearchResult searchResult = binarySearch.search(0, seq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
    }


}
