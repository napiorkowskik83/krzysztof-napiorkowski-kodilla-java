package com.kodilla.good.patterns.challenges.food2door.suppliers;


import com.kodilla.good.patterns.challenges.food2door.ProductOrderRequest;

public class MailService implements InformationService {
    @Override
    public void inform(final ProductOrderRequest request, final boolean isAccepted) {
        System.out.print("Email sent to " + request.getCustomerName() + " that her/his order for " +
                request.getQuantity() + " " + request.getProductName() + "(s) is ");
        if (isAccepted) {
            System.out.println("accepted.");
        } else {
            System.out.println("rejected.");
        }
    }
}
