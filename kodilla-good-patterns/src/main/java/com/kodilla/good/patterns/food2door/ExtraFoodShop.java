package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExtraFoodShop implements Supplier {
    private final String name;
    private final Map<String, Integer> stockEFS = new HashMap<>();

    public ExtraFoodShop() {
        this.name = "ExtraFoodShop";
        putProductInStock();
    }

    @Override
    public void putProductInStock() {
        stockEFS.put("Carrots", 100);
        stockEFS.put("Apples", 200);
        stockEFS.put("Plums", 250);
    }

    @Override
    public void updateStockQty(String product, Integer orderedQty) {
        Integer stockNewQty = stockEFS.get(product) - orderedQty;
        stockEFS.put(product, stockNewQty);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void process(Order order) {


        if (stockEFS.containsKey(order.getProductType()) && stockEFS.get(order.getProductType()) >= order.getQuantity()) {
            updateStockQty(order.getProductType(), order.getQuantity());
            System.out.println("Your order number is: " + order.getOrderNumber());
            System.out.println("You ordered " + order.getProductType() + " in quantity " + order.getQuantity());
            System.out.println("Order preparation in progress. Thank you for using our services");

        } else if (!(stockEFS.containsKey(order.getProductType()))) {
            System.out.println("Sorry, this product is currently not available");
        } else if (!(stockEFS.get(order.getQuantity()) >= order.getQuantity())) {
            System.out.println("Sorry, requested quantity is currently not available");
        }

    }
}
