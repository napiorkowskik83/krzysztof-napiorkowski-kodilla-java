package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.suppliers.OnlyBioShop;

public class Food2DoorMain {
    public static void main(String[] args){

        SupplyHandler sh = new SupplyHandler();
        sh.addSupplier(new OnlyBioShop());

        sh.checkProductAvailability("Carrot");

        sh.sendOrderRequest("ExtraFoodShop", "Carrot", 18);
        sh.sendOrderRequest("GlutenFreeShop", "Carrot", 70);
        sh.sendOrderRequest("HealthyShop", "Kohlrabi", 9);
        sh.sendOrderRequest("OnlyBioShop", "Papaya", 9);

    }
}
