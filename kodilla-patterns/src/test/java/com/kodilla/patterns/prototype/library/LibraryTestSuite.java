package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {
    @Test
    void testBooks() {

//        given
        Library library = new Library("library1");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("tytuł" + n, "author" + n, LocalDate.of(2000, 10, 5))));
        Book book1 = new Book("autor", "tytuł",LocalDate.of(2000,2,22));
        library.getBooks().add(book1);
        //making a shallow clone of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
//        when
        library.getBooks().remove(book1);
        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(10, library.getBooks().size());
        assertEquals(10, clonedLibrary.getBooks().size());
        assertEquals(11, deepClonedLibrary.getBooks().size());
        assertEquals(library.getBooks(), clonedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }

}