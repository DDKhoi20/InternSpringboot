package com.example.InternSpringboot.controller;

import com.example.InternSpringboot.dto.request.ProductCreationRequest;
import com.example.InternSpringboot.dto.request.ProductUpdateRequest;
import com.example.InternSpringboot.dto.request.UserCreationRequest;
import com.example.InternSpringboot.dto.response.ApiResponse;
import com.example.InternSpringboot.dto.response.ProductResponse;
import com.example.InternSpringboot.entity.Product;
import com.example.InternSpringboot.entity.User;
import com.example.InternSpringboot.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    ApiResponse<ProductResponse> createUser(@RequestBody @Valid ProductCreationRequest request){
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<ProductResponse>> getAllProduct(){
        ApiResponse<List<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProduct());
        return apiResponse;
    }

    @PutMapping("/{productId}")
    ApiResponse<ProductResponse> updateProduct(@PathVariable("productId") String productId,
                                               @RequestBody ProductUpdateRequest request){
        productService.updateProduct(productId, request);
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.updateProduct(productId, request));
        return apiResponse;
    }
}
