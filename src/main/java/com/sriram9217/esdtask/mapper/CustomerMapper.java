package com.sriram9217.esdtask.mapper;


import com.sriram9217.esdtask.dto.CustomerRequest;
import com.sriram9217.esdtask.dto.CustomerResponse;
import com.sriram9217.esdtask.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .products(request.products())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                customer.getPassword(), customer.getProducts());
    }

}
