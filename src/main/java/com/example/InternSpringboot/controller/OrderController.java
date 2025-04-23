package com.example.InternSpringboot.controller;

import com.example.InternSpringboot.dto.request.OrderCreationRequest;
import com.example.InternSpringboot.dto.response.ApiResponse;
import com.example.InternSpringboot.dto.response.OrderResponse;
import com.example.InternSpringboot.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ApiResponse<OrderResponse> newOrder(@RequestParam String userId,
                                               @RequestParam String productId,
                                               @RequestBody OrderCreationRequest request){
        ApiResponse<OrderResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(orderService.newOrder(userId, productId, request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<OrderResponse>> getAllOrder(){
        ApiResponse<List<OrderResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(orderService.getAllOrder());
        return apiResponse;
    }
}
