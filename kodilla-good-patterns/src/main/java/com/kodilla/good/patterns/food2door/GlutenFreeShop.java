package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GlutenFreeShop implements Supplier {
    private final String name;
    Map<String, Integer> stockGFS = new HashMap<>();

    public GlutenFreeShop() {
        this.name = "GlutenFreeShop";
        putProductInStock();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void putProductInStock() {
        stockGFS.put("Beef", 50);
        stockGFS.put("Pork", 80);
        stockGFS.put("Veal", 90);
    }

    @Override
    public void updateStockQty(String product, Integer orderedQty) {
        Integer stockNewQty = stockGFS.get(product) - orderedQty;
        stockGFS.put(product, stockNewQty);
    }

    @Override
    public void process(Order order) {
        if (stockGFS.containsKey(order.getProductType()) && stockGFS.get(order.getProductType()) >= order.getQuantity()) {
            updateStockQty(order.getProductType(), order.getQuantity());
            System.out.println("Your order number is: " + order.getOrderNumber());
            System.out.println("You ordered " + order.getProductType() + " in quantity " + order.getQuantity());
            System.out.println("Order preparation in progress. Thank you for using our services");

        } else if (!(stockGFS.containsKey(order.getProductType()))) {
            System.out.println("Sorry, this product is currently not available");
        } else if (!(stockGFS.get(order.getQuantity()) >= order.getQuantity())) {
            System.out.println("Sorry, requested quantity is currently not available");
        }

    }
}
