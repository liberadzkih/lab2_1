import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTests {
    private BinarySearch binarySearch = BinarySearch.create();
    private int[] singleElementSequence = { 3 };
    private int[] multipleElementsSequence = { 1, 2, 3, 4, 5, 6, 7 };

    @Test
    public void keyInSingleElementSequenceTest() {
        int key = 3;
        SearchResult searchResult = binarySearch.search(key, singleElementSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(key, singleElementSequence[searchResult.getPosition()]);
    }

    @Test
    public void keyNotInSingleElementSequenceTest() {
        int key = 0;
        SearchResult searchResult = binarySearch.search(key, singleElementSequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void keyAsFirstElementInMultipleElementsSequenceTest() {
        int key = 1;
        SearchResult searchResult = binarySearch.search(key, multipleElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(0, searchResult.getPosition());
        Assertions.assertEquals(key, multipleElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void keyAsLastElementInMultipleElementsSequenceTest() {
        int key = 7;
        SearchResult searchResult = binarySearch.search(key, multipleElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(multipleElementsSequence.length - 1, searchResult.getPosition());
        Assertions.assertEquals(key, multipleElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void keyAsMiddleElementInMultipleElementsSequenceTest() {
        int key = 4;
        SearchResult searchResult = binarySearch.search(key, multipleElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(multipleElementsSequence.length / 2, searchResult.getPosition());
        Assertions.assertEquals(key, multipleElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void keyNotInMultipleElementsSequenceTest() {
        int key = 0;
        SearchResult searchResult = binarySearch.search(key, multipleElementsSequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }
}
