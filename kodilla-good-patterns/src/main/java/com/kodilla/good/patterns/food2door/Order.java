package com.kodilla.good.patterns.food2door;

public class Order {
    private int quantity;
    private String productType;
    private int orderNumber;


    public Order(int orderNumber,String productType, int quantity) {
        this.orderNumber = orderNumber;
        this.productType = productType;
        this.quantity = quantity;
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
