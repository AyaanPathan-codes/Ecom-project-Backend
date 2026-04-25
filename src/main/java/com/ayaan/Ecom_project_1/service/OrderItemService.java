package com.ayaan.Ecom_project_1.service;

import com.ayaan.Ecom_project_1.model.Order;
import com.ayaan.Ecom_project_1.model.OrderItem;
import com.ayaan.Ecom_project_1.repository.OrderItemRepo;
import com.ayaan.Ecom_project_1.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepository;

    @Autowired
    private OrderRepo orderRepository;

    public OrderItem addItem(Long orderId, OrderItem item) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        item.setOrder(order);

        return orderItemRepository.save(item);
    }
}