package com.sriram9217.esdtask.service;


import com.sriram9217.esdtask.dto.AddProductRequest;
import com.sriram9217.esdtask.dto.CustomerRequest;
import com.sriram9217.esdtask.dto.CustomerResponse;
import com.sriram9217.esdtask.dto.LoginRequest;
import com.sriram9217.esdtask.entity.Customer;
import com.sriram9217.esdtask.entity.Product;
import com.sriram9217.esdtask.exception.CustomerNotFoundException;
import com.sriram9217.esdtask.helper.EncryptionService;
import com.sriram9217.esdtask.helper.JWTHelper;
import com.sriram9217.esdtask.helper.RequestInterceptor;
import com.sriram9217.esdtask.mapper.CustomerMapper;
import com.sriram9217.esdtask.mapper.ProductMapper;
import com.sriram9217.esdtask.repo.CustomerRepo;
import com.sriram9217.esdtask.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;
    private final RequestInterceptor requestInterceptor;

    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        String encryptedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encryptedPassword);
        customerRepo.save(customer);
        return "Customer created successfully";
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
        System.out.println("At the login service");
        Customer customer = getCustomer(request.id());
        if(! encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong password";
        }

        return jwtHelper.generateToken(customer.getEmail());

    }

    public String addProduct(AddProductRequest request, long customerId, String token) {
        // Validate the JWT token
        if (token == null || !jwtHelper.validateToken(token)) {
            return "Unauthorized: Invalid or expired token.";
        }

        String username = jwtHelper.extractUsername(token);
        if (username == null) {
            return "Unauthorized: Token does not contain a valid username.";
        }

        Product product = productMapper.toProduct(request);
        Customer customer = getCustomer(customerId);


        product.setCustomer(customer);
        customer.getProducts().add(product);
        productRepo.save(product);

        return "Product added successfully";
    }


}
