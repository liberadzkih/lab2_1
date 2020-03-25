import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class SearchTests {
    private BinarySearch binarySearch = BinarySearch.create();
    private int[] singleElementSequence = { 3 };
    private int[] multipleElementsSequence = { 1, 2, 3, 4, 5, 6, 7 };
    private int[] mixedElementsSequence = { -3, -2, -1, 0, 1 };

    @Test
    public void nullSequenceTest() {
        Exception exception = null;
        try {
            binarySearch.search(3, null);
        } catch (Exception e) {
            exception = e;
        }
        assertThat(exception, instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void emptySequenceTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> binarySearch.search(3, new int[0]));
    }

    @Test
    public void keyInSingleElementSequenceTest() {
        int key = 3;
        SearchResult searchResult = binarySearch.search(key, singleElementSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertNotEquals(-1, searchResult.getPosition());
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

    @Test
    public void neutralKeyInMixedElementsSequence() {
        int key = 0;
        SearchResult searchResult = binarySearch.search(key, mixedElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertNotEquals(-1, searchResult.getPosition());
        Assertions.assertEquals(key, mixedElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void negativeKeyInMixedElementsSequence() {
        int key = -2;
        SearchResult searchResult = binarySearch.search(key, mixedElementsSequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertNotEquals(-1, searchResult.getPosition());
        Assertions.assertEquals(key, mixedElementsSequence[searchResult.getPosition()]);
    }

    @Test
    public void keyInUnsortedSequence() {
        int key = 256;
        int[] sequence = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 256, 11 };
        SearchResult searchResult = binarySearch.search(key, sequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertNotEquals(-1, searchResult.getPosition());
        Assertions.assertEquals(key, sequence[searchResult.getPosition()]);
    }

    @Test
    public void keyInUnsortedSequence2() {
        int key = -10;
        int[] sequence = { -10, -20, 3, 4, 5, 6, 7, 8, 9, 256, 11 };
        SearchResult searchResult = binarySearch.search(key, sequence);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertNotEquals(-1, searchResult.getPosition());
        Assertions.assertEquals(key, sequence[searchResult.getPosition()]);
    }

    @Test
    public void keyNotInUnsortedSequence() {
        int key = 2;
        int[] sequence = { 1, 2, -30, 4, 5, 6, 7, 8, 9, 10, 11 };
        SearchResult searchResult = binarySearch.search(key, sequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void keyNotInUnsortedSequence2() {
        int key = 10;
        int[] sequence = { 1, 2, 3, 4, 5, 6, 7, 8, 256, 10, 11 };
        SearchResult searchResult = binarySearch.search(key, sequence);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(-1, searchResult.getPosition());
    }
}
