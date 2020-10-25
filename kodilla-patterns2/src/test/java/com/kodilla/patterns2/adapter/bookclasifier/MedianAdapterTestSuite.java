package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMedian() {
        //Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Dylan Murphy", "Wolf of the mountain",
                2003, "0001"));
        books.add(new Book("Phoebe Pearson", "Slaves of dreams",
                2012, "0002"));
        books.add(new Book("Morgan Walsh", "Obliteration of heaven",
                2001, "0003"));
        books.add(new Book("Aimee Murphy", "Rejecting the night",
                2015, "0004"));
        books.add(new Book("Ryan Talley", "Gangsters and kings",
                2007, "0005"));
        books.add(new Book("Madelynn Carson", "Unity without duty",
                2007, "0006"));
        books.add(new Book("Giancarlo Guerrero", "Enemies of eternity",
                2009, "0007"));


        MedianAdapter adapter = new MedianAdapter();
        //When
        int median = adapter.publicationYearMedian(books);
        //Then
        assertEquals(2007, median);
    }
}