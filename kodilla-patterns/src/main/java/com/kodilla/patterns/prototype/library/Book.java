package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

public record Book(String title, String author, LocalDate publicationDate) {

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
