package com.kodilla.good.patterns.challenges.food2door;

public class Order {
    private int quantity;
    private String productType;
    private int orderNumber;

    public Order(int quantity, String productType, int orderNumber) {
        this.quantity = quantity;
        this.productType = productType;
        this.orderNumber = orderNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductType() {
        return productType;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
