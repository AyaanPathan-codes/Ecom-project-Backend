package com.ayaan.Ecom_project_1.repository;

import com.ayaan.Ecom_project_1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
