package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public record Order(User user, String product, int quantity, LocalDate orderDate) {
    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                '}';
    }
}

