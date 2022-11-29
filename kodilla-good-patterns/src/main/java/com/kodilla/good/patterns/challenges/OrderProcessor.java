package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderProcessor {
    private final InformationService informationService;
    private final OrderService productOrderService;

    public OrderProcessor(InformationService informationService, OrderService orderService) {
        this.informationService = informationService;
        this.productOrderService = orderService;
    }

    public Order process(User user, String product, int quantity, LocalDate dateOfOrder, boolean isOrdered) {
        boolean result = productOrderService.order(new Order(user, product, quantity, dateOfOrder, isOrdered));
        informationService.inform(user);
        return new Order(user, product, quantity, dateOfOrder, isOrdered);
    }
}
