package com.sriram9217.esdtask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "Price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
