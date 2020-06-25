package com.kodilla.good.patterns.challenges.food2door;

public interface OrderRepository {
    void createOrder(String vendorName, String productName, int quantity);
}
