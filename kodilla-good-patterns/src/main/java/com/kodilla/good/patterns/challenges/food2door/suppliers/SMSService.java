package com.kodilla.good.patterns.challenges.food2door.suppliers;


import com.kodilla.good.patterns.challenges.food2door.ProductOrderRequest;

public class SMSService implements InformationService {

    @Override
    public void inform(ProductOrderRequest request, final boolean isAccepted) {
        System.out.print("SMS sent to " + request.getCustomerName() + " that it's order for " +
                request.getQuantity() + " " + request.getProductName() + "(s) is ");
        if (isAccepted) {
            System.out.println("accepted.");
        } else {
            System.out.println("rejected.");
        }
    }
}
