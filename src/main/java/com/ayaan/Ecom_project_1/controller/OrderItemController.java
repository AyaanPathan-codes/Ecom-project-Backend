package com.ayaan.Ecom_project_1.controller;

import com.ayaan.Ecom_project_1.model.OrderItem;
import com.ayaan.Ecom_project_1.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/{orderId}")
    public OrderItem addItem(@PathVariable Long orderId,
                             @RequestBody OrderItem item) {
        return orderItemService.addItem(orderId, item);
    }
}