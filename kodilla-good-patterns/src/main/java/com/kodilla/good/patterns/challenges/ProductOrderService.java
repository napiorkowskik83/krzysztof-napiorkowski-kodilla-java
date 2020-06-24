package com.kodilla.good.patterns.challenges;

import java.util.List;

public class ProductOrderService {

    private List<Product> productList = ProductStore.getProducts();

    public boolean order(ProductOrderRequest request) {
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
