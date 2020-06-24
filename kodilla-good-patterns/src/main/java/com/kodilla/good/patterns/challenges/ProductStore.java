package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class ProductStore {

    public static List<Product> getProducts() {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Tablet", 479, 23));
        productList.add(new Product("Brick", 5.99, 139));
        productList.add(new Product("Fan", 19.35, 48));
        productList.add(new Product("Carrot", 1.29, 206));

        return productList;
    }
}
