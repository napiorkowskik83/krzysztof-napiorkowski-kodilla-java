package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class ChallengesMain {
    public static void main(String[] args) {

        ProductOrderProcessor orderProcessor = new ProductOrderProcessor(new MailService(),
                new ProductOrderService(), new ProductOrderRepository());

        ProductOrderRequest orderRequest1 = new ProductOrderRequest(new User("Joe", "Doe"),
                "Carrot", 45);
        ProductOrderRequest orderRequest2 = new ProductOrderRequest(new User("John", "Liu"),
                "Laptop", 1);
        ProductOrderRequest orderRequest3 = new ProductOrderRequest(new User("Chad", "Bum"),
                "Fan", 49);

        orderProcessor.process(orderRequest1);
        orderProcessor.process(orderRequest2);
        orderProcessor.process(orderRequest3);


    }
}
