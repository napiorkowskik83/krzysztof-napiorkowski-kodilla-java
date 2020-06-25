package com.kodilla.good.patterns.challenges;

public class ProductOrderProcessor {
    private InformationService infoService;
    private ProductOrderService orderService;
    private ProductOrderRepository orderRepository;

    public ProductOrderProcessor(final InformationService infoService,
                                 final ProductOrderService orderService,
                                 final ProductOrderRepository orderRepository) {
        this.infoService = infoService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public ProductOrderDto process(final ProductOrderRequest orderRequest) {
        boolean isAccepted = orderService.order(orderRequest);
        infoService.inform(orderRequest, isAccepted);
        if (isAccepted) {
            orderRepository.createOrder(orderRequest);
        }
        return new ProductOrderDto(orderRequest, isAccepted);

    }
}
