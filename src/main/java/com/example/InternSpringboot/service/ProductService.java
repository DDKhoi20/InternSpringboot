package com.example.InternSpringboot.service;

import com.example.InternSpringboot.dto.request.ProductCreationRequest;
import com.example.InternSpringboot.dto.request.ProductUpdateRequest;
import com.example.InternSpringboot.dto.response.ProductResponse;
import com.example.InternSpringboot.entity.Product;
import com.example.InternSpringboot.mapper.ProductMapper;
import com.example.InternSpringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ProductResponse> getAllProduct(){
        return productMapper.toProductResponse(productRepository.findAll());
    }

    public ProductResponse updateProduct(String productId, ProductUpdateRequest request){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Not found the product."));
        productMapper.updateProduct(product, request);
        return productMapper.toProductResponse(productRepository.save(product));
    }
}
