package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.*;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShop implements FoodSupplier {

    private final String name = "GlutenFreeShop";

    private final List<Product> productList = new ArrayList<>();
    private final OrderService orderService = new OrderService();
    private final InformationService infoService = new SMSService();
    private final OrderRepository orderRepository = new SupplierPlusOrderRepository();

    public GlutenFreeShop() {
        productList.add(new Product("Carrot", 1.53, 69));
        productList.add(new Product("Cabbage", 7.37, 21));
        productList.add(new Product("Cherry", 0.05, 678));

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

        GlutenFreeShop that = (GlutenFreeShop) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
