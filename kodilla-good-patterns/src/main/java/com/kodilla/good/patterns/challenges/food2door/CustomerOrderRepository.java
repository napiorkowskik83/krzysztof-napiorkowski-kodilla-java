package com.kodilla.good.patterns.challenges.food2door;


public class CustomerOrderRepository implements OrderRepository {

    @Override
    public void createOrder(final String vendorName,final  String productName,final  int quantity) {
        System.out.println("Order for " + quantity + " of "
                + productName + " accepted by "
                + vendorName + " has been added to customer database.");
    }
}
