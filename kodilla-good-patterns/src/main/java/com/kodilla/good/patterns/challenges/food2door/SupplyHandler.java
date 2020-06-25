package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;
import com.kodilla.good.patterns.challenges.food2door.suppliers.SupplierDatabase;

public class SupplyHandler {

    private final String name = "Food2Door";
    private final OrderRepository orderRepository = new CustomerOrderRepository();
    private final SupplierDatabase supplierDatabase = new SupplierDatabase();
    private final AvailabilityChecker checker = new AvailabilityChecker();


    public void addSupplier(final FoodSupplier supplier){
        supplierDatabase.addSupplier(supplier);
    }

    public void checkProductAvailability(final String foodName){
        checker.verifyProductAvailability(foodName, supplierDatabase);
    }

    public void sendOrderRequest(final String supplierName, final String productName, final int quantity){
        for(FoodSupplier supplier: supplierDatabase.getSuppliers()){
            if(supplier.getName().equals(supplierName)){
                boolean isAccepted = supplier.process(new ProductOrderRequest(name, productName, quantity));
                if (isAccepted){
                    orderRepository.createOrder(supplierName, productName, quantity);
                }
            }
        }
    }
}
