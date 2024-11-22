package com.sriram9217.esdtask.service;


import com.sriram9217.esdtask.dto.CustomerRequest;
import com.sriram9217.esdtask.dto.CustomerResponse;
import com.sriram9217.esdtask.entity.Customer;
import com.sriram9217.esdtask.exception.CustomerNotFoundException;
import com.sriram9217.esdtask.mapper.CustomerMapper;
import com.sriram9217.esdtask.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

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








}
