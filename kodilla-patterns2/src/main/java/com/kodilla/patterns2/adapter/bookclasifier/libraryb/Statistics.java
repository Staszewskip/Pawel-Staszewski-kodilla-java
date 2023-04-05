package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.*;

public class Statistics implements BookStatistics {
    @Override
    public double averagePublicationYear(Map<BookSignature, Book> books) {
        if (books.size() == 0) return 0;
        int sum = 0;
        for (Map.Entry<BookSignature, Book> entry : books.entrySet()) {
            sum += entry.getValue().getYearOfPublication();
        }
        return sum / books.size();
    }

    @Override
    public double medianPublicationYear(Map<BookSignature, Book> books) {
        if (books.size() == 0) return 0;
        List<Integer> years = new ArrayList<>();

        for (Map.Entry<BookSignature, Book> entry : books.entrySet()) {
            years.add(entry.getValue().getYearOfPublication());
        }
        Collections.sort(years);
        double median;
        if (years.size() % 2 == 0) {
            median = (years.get(years.size()/2-1) + years.get(years.size()/2));
        } else {
            median =  years.get(years.size()/2);
        }
        return median;
    }
}

