import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    BinarySearch binarySearch;

    @BeforeEach
    void initializeBinarySearch() {
        binarySearch = BinarySearch.create();
    }

    @Test
    void shouldReturnPositiveResultForKeyInSequence() {
        int key = 1;
        int[] sequence = new int[]{key};
        SearchResult searchResult = binarySearch.search(key, sequence);

        assertAll(
                () -> assertTrue(searchResult.isFound()),
                () -> assertEquals(0, searchResult.getPosition())
        );
    }

    @Test
    void shouldReturnNegativeResultForKeyNotInSequence() {
        int key = 1;
        int[] sequence = new int[]{0};
        SearchResult searchResult = binarySearch.search(key, sequence);

        assertAll(
                () -> assertFalse(searchResult.isFound()),
                () -> assertEquals(-1, searchResult.getPosition())
        );
    }



}
