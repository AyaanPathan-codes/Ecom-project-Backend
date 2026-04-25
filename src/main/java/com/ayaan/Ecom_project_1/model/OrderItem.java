package com.ayaan.Ecom_project_1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id") // FK
    private Order order;
}