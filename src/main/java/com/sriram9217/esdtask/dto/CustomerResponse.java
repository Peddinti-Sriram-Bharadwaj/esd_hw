package com.sriram9217.esdtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sriram9217.esdtask.entity.Product;

import java.util.List;

public record CustomerResponse(
        @JsonProperty("id")
        long id,
        @JsonProperty("first_name")
        String first_name,
        @JsonProperty("last_name")
        String last_name,
        @JsonProperty("email")
        String email,
        @JsonProperty("password")
        String password,
        @JsonProperty("products")
        List<Product> products

)
{

}