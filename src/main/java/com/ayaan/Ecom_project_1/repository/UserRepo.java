package com.ayaan.Ecom_project_1.repository;


import com.ayaan.Ecom_project_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
