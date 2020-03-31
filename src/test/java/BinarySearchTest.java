import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    BinarySearch binarySearch;

    @BeforeEach
    void initializeBinarySearch() {
        binarySearch = BinarySearch.create();
    }

    @Nested
    @DisplayName("Tests for single sequence")
    class SingleSequenceTest {
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
        void shouldReturnNegativeResultForKeyNotInSingleSequence() {
            int key = 1;
            int[] sequence = new int[]{0};
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertFalse(searchResult.isFound()),
                    () -> assertEquals(-1, searchResult.getPosition())
            );
        }
    }

    @Nested
    @DisplayName("Tests for sequence with length > 1")
    class LongSequenceTest {
        int[] sequence;

        @BeforeEach
        void initializeSequence() {
            sequence = IntStream.rangeClosed(0, 100).toArray();
        }

        @Test
        void shouldFindKeyInTheFirstIndex() {
            int key = sequence[0];
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertTrue(searchResult.isFound()),
                    () -> assertEquals(0, searchResult.getPosition())
            );
        }

        @Test
        void shouldFindKeyInTheLastIndex() {
            int lastIndex = sequence.length - 1;
            int key = sequence[lastIndex];
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertTrue(searchResult.isFound()),
                    () -> assertEquals(lastIndex, searchResult.getPosition())
            );
        }

        @Test
        void shouldFindKeyInTheMiddle() {
            int middleIndex = sequence.length / 2;
            int key = sequence[middleIndex];
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertTrue(searchResult.isFound()),
                    () -> assertEquals(middleIndex, searchResult.getPosition())
            );

        }

        @Test
        void shouldReturnNegativeResultForKeyNotInMultiSequence() {
            int key = -1;
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertFalse(searchResult.isFound()),
                    () -> assertEquals(-1, searchResult.getPosition())
            );
        }

    }
}
