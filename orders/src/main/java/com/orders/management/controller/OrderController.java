package com.orders.management.controller;
import com.orders.management.model.Order;
import com.orders.management.repositories.OrderRepository;
import com.orders.management.service.OrderProducer;
import com.orders.management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.orders.management.constants.AppConstants.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    @Autowired
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path = "/produce")
    public String saveAndProduceOrder(@RequestBody Order order){
        Order ordersWithId = this.orderService.getOrders(order);
        System.out.println(ordersWithId);
        orderProducer.produceOrder(ordersWithId);
        return MESSAGE_SUCCESS;
    }

    @PutMapping("/update/{orderId}")
    public String updateOrder(@RequestBody Order order, @PathVariable("orderId") Long orderId){
        Order updateOrder = this.orderService.updateOrder(order,orderId);
        System.out.println(updateOrder);
        orderProducer.produceOrder(updateOrder);
        return ORDER_UPDATED;
    }
    
    public void updateOrder(Long orderId) {
        Order orders = this.orderService.getOrderUpdate(orderId);
        System.out.println(orders);
        System.out.println(ORDER_SHIPPED);
    }
}
