package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class SuppliersPortfolio {
    Map<String, Supplier> suppliersOffer = new HashMap<>();

    public SuppliersPortfolio() {
        fillMap();
    }

    private void fillMap() {
        Supplier extraFoodShop = new ExtraFoodShop();
        Supplier healthyShop = new HealthyShop();
        Supplier glutenFreeShop = new GlutenFreeShop();

        suppliersOffer.put("Carrots", extraFoodShop);
        suppliersOffer.put("Apples", extraFoodShop);
        suppliersOffer.put("Plums", extraFoodShop);
        suppliersOffer.put("Tofu", healthyShop);
        suppliersOffer.put("Feta cheese", healthyShop);
        suppliersOffer.put("Halloumi cheese", healthyShop);
        suppliersOffer.put("Beef", glutenFreeShop);
        suppliersOffer.put("Pork", glutenFreeShop);
        suppliersOffer.put("Veal", glutenFreeShop);
    }
    public void process (Order order){
        if (suppliersOffer.containsKey(order.getProductType())){
            suppliersOffer.get(order.getProductType()).process(order);
        } else {
            System.out.println("Product not available, please contact us");
        }
    }


}
