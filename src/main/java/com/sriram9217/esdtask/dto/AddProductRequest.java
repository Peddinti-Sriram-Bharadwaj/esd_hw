package com.sriram9217.esdtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sriram9217.esdtask.entity.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddProductRequest(

        @NotNull
        @NotBlank
        @NotEmpty
        @JsonProperty("name")
        String name,

        @NotNull
        @NotBlank
        @NotEmpty
        @JsonProperty("description")
        String description,


        @NotNull
        @JsonProperty("price")
        Double price,

        @JsonProperty("customer_id")
        Customer customer
) {
}
