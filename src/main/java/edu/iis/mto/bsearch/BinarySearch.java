/**
 *
 */
package edu.iis.mto.bsearch;

import java.util.Arrays;

/**
 * Klasa dla wyszukiwania binarnego
 *
 */
public class BinarySearch {

    BinarySearch() {
    }

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public SearchResult search(int key, int[] seq) {
        if (seq == null) {
            throw new NullPointerException("seq can't be null ");
        } else if (seq.length == 0) {
            throw new IllegalArgumentException("seq can't be empty");
        } else if (!isSeqSorted(seq)) {
            throw new IllegalArgumentException("seq have to be sorted");
        }
        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }

        }
        return result;
    }

    private boolean isSeqSorted(int[] seq) {
        if (seq.length < 1)
            return true;
        for (int i = 1; i < seq.length; i++) {
            if (seq[i - 1] > seq[i])
                return false;
        }
        return true;
    }

    public static BinarySearch create() {
        return new BinarySearch();
    }
}
