package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.Product;
import com.kodilla.good.patterns.challenges.food2door.ProductOrderRequest;

import java.util.List;

public interface FoodSupplier {

    List<Product> getProductList();

    boolean process(ProductOrderRequest orderRequest);

    String getName();
}
