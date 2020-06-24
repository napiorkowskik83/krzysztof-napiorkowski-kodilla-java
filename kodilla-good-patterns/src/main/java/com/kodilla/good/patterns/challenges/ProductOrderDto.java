package com.kodilla.good.patterns.challenges;

public class ProductOrderDto {
    ProductOrderRequest orderRequest;
    boolean isAccepted;

    public ProductOrderDto(final ProductOrderRequest orderRequest, final boolean isAccepted) {
        this.orderRequest = orderRequest;
        this.isAccepted = isAccepted;
    }

    public ProductOrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isAccepted() {
        return isAccepted;
    }
}
