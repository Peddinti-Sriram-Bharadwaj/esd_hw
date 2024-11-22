package com.sriram9217.esdtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (

    @NotNull(message = "Customer id should not be null")
    @NotEmpty(message = "customer id should not be empty")
    @NotBlank(message = "customer id should not be blank")
    @JsonProperty("id")
    int id,

    @NotNull(message = "Customer id should not be null")
    @NotEmpty(message = "customer id should not be empty")
    @NotBlank(message = "customer id should not be blank")
    @JsonProperty("firstName")
    String firstName,


    @JsonProperty("lastName")
    String lastName,

    @NotNull(message = "Customer id should not be null")
    @Email(message = "email should be in valid format")
    @JsonProperty("email")
    String email,

    @NotNull(message = "Customer id should not be null")
    @NotEmpty(message = "customer id shold not be empty")
    @NotBlank(message = "customer id should not be blank")
    @JsonProperty("id")
    String password
)
{

}
