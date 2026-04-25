package com.ayaan.Ecom_project_1.model;


import com.ayaan.Ecom_project_1.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String name;
    private String phone;

    private String email;
    private String password;

    private String address;
    private String city;
    private String pincode;

    private boolean isActive;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;


}
