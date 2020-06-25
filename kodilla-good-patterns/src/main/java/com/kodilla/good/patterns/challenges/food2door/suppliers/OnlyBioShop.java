package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.*;

import java.util.ArrayList;
import java.util.List;

public class OnlyBioShop implements FoodSupplier {

    private final String name = "OnlyBioShop";

    private final List<Product> productList = new ArrayList<>();
    private final OrderService orderService = new OrderService();
    private final InformationService infoService = new SMSService();
    private final OrderRepository orderRepository = new SupplierPlusOrderRepository();

    public OnlyBioShop() {
        productList.add(new Product("Carrot", 1.99, 76));
        productList.add(new Product("Durian", 7.69, 31));
        productList.add(new Product("Papaya", 2.03, 83));

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

        OnlyBioShop that = (OnlyBioShop) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
