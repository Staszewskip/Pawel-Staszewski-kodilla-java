package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given

        Book book1 = new Book("Assassins' Creed the Book", "William Shakespeare", 2016, "5896421");
        Book book2 = new Book("Book of jungle", "Rudyard Kipling", 1894, "5896421");
        Book book3 = new Book("50 shades of gray – lexicon for graphicians", "Dante Alighieri", 1572, "5896421");
        Book book4 = new Book("The Sicilian", "Mario Puzo", 1996, "5964123");
        Book book5 = new Book("The Da Vinci Code", "Dan Brown", 2001, "4589647");
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(1996, median);
    }

}