package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class Order {
    private final User user;
    private final String product;
    private final int quantity;
    private final LocalDate orderDate;
    private final boolean isOrdered;

    public Order(User user, String product, int quantity, LocalDate orderDate, boolean isOrdered) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}

