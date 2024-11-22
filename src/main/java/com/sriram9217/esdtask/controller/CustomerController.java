package com.sriram9217.esdtask.controller;


import com.sriram9217.esdtask.dto.AddProductRequest;
import com.sriram9217.esdtask.dto.CustomerRequest;
import com.sriram9217.esdtask.dto.CustomerResponse;
import com.sriram9217.esdtask.entity.Customer;
import com.sriram9217.esdtask.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.retrieveCustomer(id));
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> addProduct(@RequestBody @Valid AddProductRequest request, @PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.addProduct(request, id));
    }

}