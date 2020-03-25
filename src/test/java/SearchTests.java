import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SearchTests {
    private BinarySearch binarySearch = BinarySearch.create();
    private int[] singleElementSequence = { 3 };
    private int[] multipleElementSequence = { 1, 2, 3, 4, 5, 6, 7 };

    @Test
    public void keyInSingleElementSequenceTest() {
        int key = 3;
        SearchResult searchResult = binarySearch.search(key, singleElementSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(singleElementSequence[searchResult.getPosition()], key);
    }

    @Test
    public void keyNotInSingleElementSequenceTest() {
        int key = 0;
        SearchResult searchResult = binarySearch.search(key, singleElementSequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), -1);
    }
}
