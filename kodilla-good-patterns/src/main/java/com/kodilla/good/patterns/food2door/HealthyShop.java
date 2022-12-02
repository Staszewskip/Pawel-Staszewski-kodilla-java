package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HealthyShop implements Supplier {
    private final String name;
    Map<String, Integer> stockHS = new HashMap<>();
    public HealthyShop(){
        this.name = "HealthyShop";
        putProductInStock();
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void putProductInStock() {
        stockHS.put("Tofu", 50);
        stockHS.put("Feta cheese", 60);
        stockHS.put("Halloumi cheese", 70);
    }


    @Override
    public void updateStockQty(String product, Integer orderedQty) {
        Integer stockNewQty = stockHS.get(product) - orderedQty;
        stockHS.put(product, stockNewQty);
    }

    @Override
    public void process(Order order) {
        if (stockHS.containsKey(order.getProductType()) && stockHS.get(order.getProductType()) >= order.getQuantity()) {
            updateStockQty(order.getProductType(), order.getQuantity());
            System.out.println("Your order number is: " + order.getOrderNumber());
            System.out.println("You ordered " + order.getProductType() + " in quantity " + order.getQuantity());
            System.out.println("Order preparation in progress. Thank you for using our services");

        } else if (!(stockHS.containsKey(order.getProductType()))) {
            System.out.println("Sorry, this product is currently not available");
        } else if (!(stockHS.get(order.getQuantity()) >= order.getQuantity())) {
            System.out.println("Sorry, requested quantity is currently not available");
        }

    }
}
