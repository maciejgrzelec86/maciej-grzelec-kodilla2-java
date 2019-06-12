package com.kodilla.good.patterns.challenges;

import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService, final OrderService orderService, final OrderRepository orderRepository){
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = orderService.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());

        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDto(orderRequest, true);
        }else {
            return new OrderDto(orderRequest, false);
        }
    }
}
