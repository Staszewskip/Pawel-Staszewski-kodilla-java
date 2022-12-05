package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderProcessorMain {
    public static void main(String[] args) {
        InformationService informationService = new OrderInformationService();
        OrderService orderService = new ProductOrderService();
        OrderProcessor orderProcessor = new OrderProcessor(informationService,orderService);
        orderProcessor.process(new User("Johnny", "Bravo"),"toothbrush",1, LocalDate.now());
    }
}
