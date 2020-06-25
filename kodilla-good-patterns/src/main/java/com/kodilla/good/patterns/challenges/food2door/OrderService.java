package com.kodilla.good.patterns.challenges.food2door;

import java.util.List;

public class OrderService {


    public boolean order(final ProductOrderRequest request, final List<Product> productList) {
        for (Product product : productList) {
            if (request.getProductName().equals(product.getName()) &&
                    request.getQuantity() <= product.getQuantity()) {
                System.out.println("\nOrder is accepted");
                return true;
            }
        }
        System.out.println("\nOrder is rejected");
        return false;
    }
}
