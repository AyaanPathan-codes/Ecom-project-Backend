package com.ayaan.Ecom_project_1.model;

import com.ayaan.Ecom_project_1.Enum.Category;
import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;

import java.time.LocalDate;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Category category;

    private boolean available;
    private int quantity;
    private String brand;

    private Double discountPercentage;
    private String tag;

    private String releaseDate;

    private String imageUrl;
}