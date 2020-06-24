package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository {

    public void createOrder(ProductOrderRequest request) {
        System.out.println("Order for " + request.getQuantity() + " of "
                + request.getProductName() + " from "
                + request.getUser() + " has been added to database.");
    }
}
