package com.example.InternSpringboot.repository;

import com.example.InternSpringboot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
