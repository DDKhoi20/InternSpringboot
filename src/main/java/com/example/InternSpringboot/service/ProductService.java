package com.example.InternSpringboot.service;

import com.example.InternSpringboot.dto.request.ProductCreationRequest;
import com.example.InternSpringboot.dto.response.ProductResponse;
import com.example.InternSpringboot.entity.Product;
import com.example.InternSpringboot.mapper.ProductMapper;
import com.example.InternSpringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    public ProductResponse createProduct(ProductCreationRequest request){
        if (productRepository.existsByName(request.getName())){
            throw new IllegalArgumentException("Product đã tồn tại");
        }
        return productMapper.toProductResponse(productRepository.save(productMapper.toProduct(request)));
    }
}
