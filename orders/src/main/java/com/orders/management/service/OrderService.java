package com.orders.management.service;
import com.orders.management.model.Order;
import com.orders.management.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrders(Order order){
        return this.orderRepository.save(order);
    }

    public Order getOrderUpdate(Long orderId) {
        Order order = this.orderRepository.findById(orderId).get();
        order.setShipped(true);
        return this.orderRepository.save(order);

    }

    public Order updateOrder(Order order, Long orderId) {
        Order newOrder = new Order();
        newOrder.setShipped(order.isShipped());
        newOrder.setAddress(order.getAddress());
        newOrder.setTotalCost(order.getTotalCost());
        newOrder.setCustomerName(order.getCustomerName());
        newOrder.setItem(order.getItem());
        newOrder.setId(orderId);
        return this.orderRepository.save(newOrder);
    }
}
