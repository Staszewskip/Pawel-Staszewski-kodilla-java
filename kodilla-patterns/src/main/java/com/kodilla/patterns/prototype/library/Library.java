package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype<Library> {


    private  String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "Books: " + books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            Book clonedBook = new Book(book.title(), book.author(), book.publicationDate());
            clonedLibrary.getBooks().add(book);
        }
        return clonedLibrary;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
