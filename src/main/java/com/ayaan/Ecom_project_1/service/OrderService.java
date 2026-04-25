package com.ayaan.Ecom_project_1.service;

import com.ayaan.Ecom_project_1.model.Order;
import com.ayaan.Ecom_project_1.model.User;
import com.ayaan.Ecom_project_1.repository.OrderRepo;
import com.ayaan.Ecom_project_1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private UserRepo userRepository;

    public Order createOrder(Long userId, Order order) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        order.setUser(user);

        return orderRepository.save(order);
    }
}