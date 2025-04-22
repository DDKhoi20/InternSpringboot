package com.example.InternSpringboot.mapper;

import com.example.InternSpringboot.dto.request.ProductCreationRequest;
import com.example.InternSpringboot.dto.request.ProductUpdateRequest;
import com.example.InternSpringboot.dto.request.UserUpdateRequest;
import com.example.InternSpringboot.dto.response.ProductResponse;
import com.example.InternSpringboot.entity.Product;
import com.example.InternSpringboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreationRequest request);
    Product toProduct(ProductUpdateRequest request);
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponse(List<Product> product);
    void updateProduct(@MappingTarget Product product, ProductUpdateRequest request);
}
