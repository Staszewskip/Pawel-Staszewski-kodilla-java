package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {
    @Override
    public boolean order(Order order) {
        System.out.println("User " + order.user().firstName() + " " + order.user().lastName()+ " ordered: " + order.quantity() + " "+ order.product()   + "; date of the order: "+order.orderDate()) ;
        return true;
    }
}
