package com.kodilla.good.patterns.challenges.food2door.suppliers;


import com.kodilla.good.patterns.challenges.food2door.*;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements FoodSupplier {

    private final String name = "ExtraFoodShop";

    private final List<Product> productList = new ArrayList<>();
    private final OrderService orderService = new OrderService();
    private final InformationService infoService = new MailService();
    private final OrderRepository orderRepository = new SupplierOrderRepository();

    public ExtraFoodShop() {
        productList.add(new Product("Carrot", 1.49, 25));
        productList.add(new Product("Cheese", 3.15, 67));
        productList.add(new Product("Potato", 0.95, 329));
        productList.add(new Product("Watermelon", 5.635, 32));

    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean process(final ProductOrderRequest orderRequest) {
        boolean isAccepted = orderService.order(orderRequest, productList);
        infoService.inform(orderRequest, isAccepted);
        if (isAccepted) {
            orderRepository.createOrder(orderRequest.getCustomerName(),
                    orderRequest.getProductName(), orderRequest.getQuantity());
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraFoodShop that = (ExtraFoodShop) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {

        return name.hashCode();
    }
}
