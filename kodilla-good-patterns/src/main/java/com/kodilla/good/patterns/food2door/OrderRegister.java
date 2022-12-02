package com.kodilla.good.patterns.food2door;



public class OrderRegister {
    public static void main(String[] args) {
SuppliersPortfolio supplier = new SuppliersPortfolio();
supplier.process(new Order(1,"Apples",10));
supplier.process(new Order(2,"Beef",20));
supplier.process(new Order(3,"Tofu",15));
supplier.process(new Order(4,"Orange",55));
    }
}
