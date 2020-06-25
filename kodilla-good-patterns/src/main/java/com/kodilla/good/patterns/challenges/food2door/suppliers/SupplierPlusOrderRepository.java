package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.OrderRepository;

public class SupplierPlusOrderRepository implements OrderRepository {

    @Override
    public void createOrder(final String vendorName, final String productName, final int quantity) {
        System.out.println("Order for " + quantity + " of "
                + productName + " from "
                + vendorName + " has been added to sophisticated supplier database.");
    }
}
