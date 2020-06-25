package com.kodilla.good.patterns.challenges.food2door.suppliers;

import java.util.HashSet;
import java.util.Set;

public class SupplierDatabase {
    private final Set<FoodSupplier> suppliers = new HashSet<>();

    public SupplierDatabase() {
        suppliers.add(new ExtraFoodShop());
        suppliers.add(new GlutenFreeShop());
        suppliers.add(new HealthyShop());

    }

    public void addSupplier(final FoodSupplier supplier) {
        suppliers.add(supplier);
    }

    public Set<FoodSupplier> getSuppliers() {
        return suppliers;
    }
}
