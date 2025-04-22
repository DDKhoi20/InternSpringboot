package com.example.InternSpringboot.mapper;

import com.example.InternSpringboot.dto.request.OrderCreationRequest;
import com.example.InternSpringboot.dto.response.OrderResponse;
import com.example.InternSpringboot.dto.response.ProductResponse;
import com.example.InternSpringboot.dto.response.UserResponse;
import com.example.InternSpringboot.entity.Orders;
import com.example.InternSpringboot.entity.Product;
import com.example.InternSpringboot.entity.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", source = "orders.id")
    OrderResponse toOrderResponse(Orders orders, UserResponse userResponse, ProductResponse productResponse);
}
