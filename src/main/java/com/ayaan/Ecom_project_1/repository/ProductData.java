package com.ayaan.Ecom_project_1.repository;

import com.ayaan.Ecom_project_1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductData extends JpaRepository<Product, Integer> {
}
