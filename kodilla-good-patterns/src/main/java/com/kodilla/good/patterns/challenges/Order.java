package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.Objects;

public record Order(User user, String product, int quantity, LocalDate orderDate) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Objects.equals(user, order.user) && Objects.equals(product, order.product) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product, quantity, orderDate);
    }
}

