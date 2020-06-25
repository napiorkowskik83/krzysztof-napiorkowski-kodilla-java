package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.ProductOrderRequest;

public interface InformationService {

    void inform(ProductOrderRequest request, boolean isAccepted);
}
