package com.sriram9217.esdtask.repo;


import com.sriram9217.esdtask.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findById(long id);
}
