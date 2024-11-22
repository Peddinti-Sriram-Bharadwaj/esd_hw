package com.sriram9217.esdtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerResponse(
        @JsonProperty("id")
        int id,
        @JsonProperty("first_name")
        String first_name,
        @JsonProperty("last_name")
        String last_name,
        @JsonProperty("email")
        String email,
        @JsonProperty("password")
        String password

)
{

}