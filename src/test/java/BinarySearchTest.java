import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.*;
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

        int[] sequence;

        @BeforeEach
        void initializeSingleSequence(){
            sequence = new int[]{1};
        }

        @Test
        void shouldReturnPositiveResultForKeyInSequence() {
            int key = sequence[0];
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertTrue(searchResult.isFound()),
                    () -> assertThat(searchResult.getPosition(), equalTo(0))
            );
        }

        @Test
        void shouldReturnNegativeResultForKeyNotInSingleSequence() {
            int key =  -1;
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertFalse(searchResult.isFound()),
                    () -> assertThat(searchResult.getPosition(), equalTo(-1))
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
                    () -> assertThat(searchResult.getPosition(), equalTo(0))
            );
        }

        @Test
        void shouldFindKeyInTheLastIndex() {
            int lastIndex = sequence.length - 1;
            int key = sequence[lastIndex];
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertTrue(searchResult.isFound()),
                    () -> assertThat(searchResult.getPosition(), equalTo(lastIndex))
            );
        }

        @Test
        void shouldFindKeyInTheMiddle() {
            int middleIndex = sequence.length / 2;
            int key = sequence[middleIndex];
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertTrue(searchResult.isFound()),
                    () -> assertThat(searchResult.getPosition(), equalTo(middleIndex))
            );

        }

        @Test
        void shouldReturnNegativeResultForKeyNotInMultiSequence() {
            int key = -1;
            SearchResult searchResult = binarySearch.search(key, sequence);

            assertAll(
                    () -> assertFalse(searchResult.isFound()),
                    () -> assertThat(searchResult.getPosition(), equalTo(-1))
            );
        }
    }

    @Nested
    @DisplayName("Tests for incorrect arguments")
    class IncorrectArgumentsTest {

        @Test
        void shouldThrowIllegalNullPointerExceptionIfSequenceIsNull(){
            assertThrows(
                    NullPointerException.class,
                    () -> binarySearch.search(2, null)
            );
        }

        @Test
        void shouldThrowIllegalArgumentExceptionIfSequenceIsEmpty(){
            int[] emptySeq = new int[]{};
            assertThrows(
                    IllegalArgumentException.class,
                    () -> binarySearch.search(2, emptySeq)
            );
        }

    }
}
