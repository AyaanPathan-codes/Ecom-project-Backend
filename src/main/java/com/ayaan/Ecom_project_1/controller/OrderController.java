package com.ayaan.Ecom_project_1.controller;

import com.ayaan.Ecom_project_1.model.Order;
import com.ayaan.Ecom_project_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public Order createOrder(@PathVariable Long userId,
                             @RequestBody Order order) {
        return orderService.createOrder(userId, order);
    }
}