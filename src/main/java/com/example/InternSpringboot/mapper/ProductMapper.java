package com.example.InternSpringboot.mapper;

import com.example.InternSpringboot.dto.request.ProductCreationRequest;
import com.example.InternSpringboot.dto.response.ProductResponse;
import com.example.InternSpringboot.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreationRequest request);
    ProductResponse toProductResponse(Product product);
}
