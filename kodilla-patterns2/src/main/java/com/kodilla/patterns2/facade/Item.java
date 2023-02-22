package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private final Long productId;
    private final double qty;

    public Item(Long productId, double qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public Long getProductId() { return productId; }

    public double getQty() { return qty; }

    @Service
    public static class ShopService {

        private final List<Order> orders = new ArrayList<>();
        private final Authenticator authenticator;
        private final ProductService productService;

        @Autowired
        public ShopService(Authenticator authenticator, ProductService productService) {
            this.authenticator = authenticator;
            this.productService = productService;
        }
    }
}