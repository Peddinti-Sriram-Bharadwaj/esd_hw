package com.sriram9217.esdtask.repo;

import com.sriram9217.esdtask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
