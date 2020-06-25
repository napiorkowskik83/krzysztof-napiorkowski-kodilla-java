package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;
import com.kodilla.good.patterns.challenges.food2door.suppliers.SupplierDatabase;

public class AvailabilityChecker {

    public void verifyProductAvailability(final String productName, final SupplierDatabase database){
        System.out.println("Availability of " + productName +" at suppliers:");
        for (FoodSupplier supplier: database.getSuppliers()){
            for(Product product: supplier.getProductList()){
                if(product.getName().equals(productName)){
                    System.out.println(supplier.getName() + ": " + product.getQuantity() +
                            " pcs, " + product.getPrice() + "$/pc");
                    //i++;
                }
            }
        }

    }
}
