package com.orders.management.service;
import com.orders.management.constants.AppConstants;
import com.orders.management.controller.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ShippedOrderIdConsumer {

    @Autowired
    private OrderController orderController;

    @KafkaListener(topics = AppConstants.SHIPPED_ORDER_TOPIC)
    public void consumeOrderId(Long orderId) throws IOException{
        System.out.println(String.format("##########\nConsumed Order Id-> %s\n##########", orderId));
        orderController.updateOrder(orderId);
    }

}
