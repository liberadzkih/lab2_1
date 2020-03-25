package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.MatcherAssert.assertThat;


class BinarySearchTest {

    int key=6;
    @Test void searchForExistingElem_singleElemSequence_ElemIsInSequence() { //nazwa odzwierciedla przypadek testowy
        int seq[]={6};//dlugosc sekwencji = jeden
        SearchResult sr = BinarySearch.create().search(key,seq);
        assertTrue(sr.isFound());//asercja sprawdzajaca prawdziwosc warunku
        assertEquals(seq.length-1,sr.getPosition()); //i = getPosition()
        assertEquals(key,seq[seq.length-1]); //key=seq[i]
    }

    @Test void searchForExistingElem_singleElemSequence_ElemIsNotInSequence() {
        int seq[]={4};//dlugosc sekwencji = jeden
        SearchResult sr = BinarySearch.create().search(key,seq);
        assertFalse(sr.isFound());
        assertEquals(-1,sr.getPosition());
    }

    @Test void searchForExistingElem_longerElemSequence_ElemIsTheFirstInSequence() { //liczac pozycje od 0
        int seq[]={6,7,8,9,10};
        SearchResult sr = BinarySearch.create().search(key,seq);
        assertTrue(sr.isFound()); //true
        assertEquals(0,sr.getPosition()); //i = getPosition()
        assertEquals(key,seq[0]); //key=seq[i]
    }
    @Test void searchForExistingElem_longerElemSequence_ElemIsTheLastInSequence() { //liczac pozycje od 0
        int seq[]={2,3,4,5,6};
        SearchResult sr = BinarySearch.create().search(key,seq);
        assertTrue(sr.isFound()); //true
        assertEquals(seq.length-1,sr.getPosition()); //i = getPosition()
        assertEquals(key,seq[seq.length-1]); //key=seq[i]
    }

    @Test void searchForExistingElem_longerElemSequence_ElemIsInTheMiddleOfSequence() {
        int seq[]={4,5,6,7,8,9};
        SearchResult sr = BinarySearch.create().search(key,seq);
        assertTrue(sr.isFound()); //true
        assertEquals((seq.length-1)/2,sr.getPosition()); //i = getPosition()
        assertEquals(key,seq[(seq.length-1)/2]); //key=seq[i]
    }

    @Test void searchForExistingElem_longerElemSequence_ElemIsNotInSequence() {
        int seq[]={7,8,9};
        SearchResult sr = BinarySearch.create().search(key,seq);
        assertFalse(sr.isFound()); //false
        assertEquals(-1,sr.getPosition()); //i = getPosition()
    }

   @Test void searchForExistingElem_emptyElemSequence_ElemIsNotInSequence() {
        int seq[]={}; //pusta sequence
        SearchResult sr = BinarySearch.create().search(key,seq);
        assertFalse(sr.isFound()); //false
        assertEquals(-1,sr.getPosition()); //i = getPosition()
    }

    @Test void searchForExistingElem_sequenceIsNull_ElemIsNotInSequence() {
        int seq[]=null;
        try{
           BinarySearch.create().search(key,seq);
        }
        catch(IllegalArgumentException e){}
    }
}
