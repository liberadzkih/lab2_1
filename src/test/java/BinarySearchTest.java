
import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    int[] seqWithOneelement = {1};
    int[] seq2 = {1, 2, 3, 4, 5};

    @Test
    void elemntIsInTheSeq() {
        int positionExpected = 0;
        SearchResult searchResult = BinarySearch.create().search(1, seqWithOneelement);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(positionExpected, equalTo(searchResult.getPosition()));

    }

    @Test
    void elementIsNotInTheSeq() {
        int positionExpected = -1;
        SearchResult searchResult = BinarySearch.create().search(2, seqWithOneelement);
        assertThat(false, equalTo(searchResult.isFound()));
        assertThat(positionExpected, equalTo(searchResult.getPosition()));
    }

    @Test
    void elementIsTheFirstInTheSeq() {
        int positionExpected = 0;
        SearchResult searchResult = BinarySearch.create().search(1, seq2);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(positionExpected, equalTo(searchResult.getPosition()));
    }

    @Test
    void elementIsTheLastInTheSeq() {
        int positionExpected = 4;
        SearchResult searchResult = BinarySearch.create().search(5, seq2);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(positionExpected, equalTo(searchResult.getPosition()));
    }

    @Test
    void elementIsTheMiddleInTheSeq() {
        int positionExpected = 2;
        SearchResult searchResult = BinarySearch.create().search(3, seq2);
        assertThat(true, equalTo(searchResult.isFound()));
        assertThat(positionExpected, equalTo(searchResult.getPosition()));
    }

    @Test
    void elementIsNotInTheSeq2() {
        int positionExpected = -1;
        SearchResult searchResult = BinarySearch.create().search(6, seq2);
        assertThat(false, equalTo(searchResult.isFound()));
        assertThat(positionExpected, equalTo(searchResult.getPosition()));
    }

    @Test
    void squenceIsEmptyException() {
        int[] seqEmpty = {};
        assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.create().search(2, seqEmpty);
        });
    }

    @Test
    void squenceIsNullException() {
        int[] seqEmpty = null;
        assertThrows(NullPointerException.class, () -> {
            BinarySearch.create().search(2, seqEmpty);
        });
    }
}
