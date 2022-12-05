package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderProcessor {
    private final InformationService orderInformationService;
    private final OrderService productOrderService;

    public OrderProcessor(InformationService orderInformationService, OrderService productOrderService) {
        this.orderInformationService = orderInformationService;
        this.productOrderService = productOrderService;
    }

    public Order process(User user, String product, int quantity, LocalDate dateOfOrder) {
        boolean result = productOrderService.order(new Order(user, product, quantity, dateOfOrder));
        orderInformationService.inform(user);
        return new Order(user, product, quantity, dateOfOrder);
    }
}
