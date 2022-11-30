package com.kodilla.good.patterns.food2door;

public interface Supplier {
    String getName();
    void process(Order order);

    void putProductInStock();

    void updateStockQty(String product, Integer orderedQty);

}
