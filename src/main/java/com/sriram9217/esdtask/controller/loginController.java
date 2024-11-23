package com.sriram9217.esdtask.controller;


import com.sriram9217.esdtask.dto.LoginRequest;
import com.sriram9217.esdtask.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("api/v1/auth")
public class loginController {

    private final CustomerService customerService;

    public loginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody @Valid LoginRequest request){
        System.out.println("at the controller");
        return ResponseEntity.ok(customerService.login(request));
    }


}
