package com.sriram9217.esdtask.mapper;

import com.sriram9217.esdtask.dto.AddProductRequest;
import com.sriram9217.esdtask.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(AddProductRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .customer(request.customer())
                .build();
    }

}

