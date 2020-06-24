package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    @Override
    public void inform(ProductOrderRequest request, boolean isAccepted) {
        System.out.print("Email sent to " + request.getUser() + " that her/his order for " +
                request.getQuantity() + " " + request.getProductName() + "(s) is ");
        if (isAccepted) {
            System.out.println("accepted.");
        } else {
            System.out.println("rejected.");
        }
    }
}
