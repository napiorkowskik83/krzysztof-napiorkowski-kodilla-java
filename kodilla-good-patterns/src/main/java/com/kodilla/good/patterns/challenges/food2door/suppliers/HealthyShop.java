package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.*;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements FoodSupplier {

    private final String name = "HealthyShop";

    private final List<Product> productList = new ArrayList<>();
    private final OrderService orderService = new OrderService();
    private final InformationService infoService = new MailService();
    private final OrderRepository orderRepository = new SupplierOrderRepository();

    public HealthyShop() {
        productList.add(new Product("Kohlrabi", 2.11, 37));
        productList.add(new Product("Rhubarb", 1.89, 52));
        productList.add(new Product("Potato", 0.77, 329));

    }

    @Override
    public List<Product> getProductList() {

        return productList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean process(ProductOrderRequest orderRequest) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HealthyShop that = (HealthyShop) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
