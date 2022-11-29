package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {
    @Override
    public boolean order(Order order) {
        System.out.println("User " + order.getUser().getFirstName() + " " + order.getUser().getLastName()+ " ordered: " + order.getQuantity() + " "+ order.getProduct()   + "; date of the order: "+order.getOrderDate()) ;
        return true;
    }
}
