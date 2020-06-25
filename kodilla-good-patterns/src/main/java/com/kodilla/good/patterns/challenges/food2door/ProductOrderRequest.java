package com.kodilla.good.patterns.challenges.food2door;


public class ProductOrderRequest {
    private final  String customerName;
    private final  String productName;
    private final  int quantity;

    public ProductOrderRequest(String customerName, String productName, int quantity) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
