package com.sriram9217.esdtask.service;


import com.sriram9217.esdtask.dto.AddProductRequest;
import com.sriram9217.esdtask.dto.CustomerRequest;
import com.sriram9217.esdtask.dto.CustomerResponse;
import com.sriram9217.esdtask.dto.LoginRequest;
import com.sriram9217.esdtask.entity.Customer;
import com.sriram9217.esdtask.entity.Product;
import com.sriram9217.esdtask.exception.CustomerNotFoundException;
import com.sriram9217.esdtask.mapper.CustomerMapper;
import com.sriram9217.esdtask.mapper.ProductMapper;
import com.sriram9217.esdtask.repo.CustomerRepo;
import com.sriram9217.esdtask.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;

    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customerRepo.save(customer);
        return "customer created successfully";
    }

    public Customer getCustomer(long id) {
        return customerRepo.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with id " + id + " not found")
        );
    }

    public CustomerResponse retrieveCustomer(long id) {
        Customer customer = getCustomer(id);
        return customerMapper.toCustomerResponse(customer);

    }

    public String login(LoginRequest request) {
        Customer customer = getCustomer(request.id());
        if(request.password().equals(customer.getPassword())) {
            return "customer logged in successfully";
        }
        else{
            return "wrong password";
        }

    }

    public String addProduct(AddProductRequest request, long id) {
        Product product = productMapper.toProduct(request);
        productRepo.save(product);
        Customer customer = getCustomer(id);
        product.setCustomer(customer);
        customer.getProducts().add(product);
        return "product added successfully";
    }
}
