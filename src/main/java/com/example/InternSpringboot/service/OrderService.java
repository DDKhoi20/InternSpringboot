package com.example.InternSpringboot.service;

import com.example.InternSpringboot.dto.request.OrderCreationRequest;
import com.example.InternSpringboot.dto.response.OrderResponse;
import com.example.InternSpringboot.entity.Orders;
import com.example.InternSpringboot.entity.Product;
import com.example.InternSpringboot.entity.User;
import com.example.InternSpringboot.mapper.OrderMapper;
import com.example.InternSpringboot.mapper.ProductMapper;
import com.example.InternSpringboot.mapper.UserMapper;
import com.example.InternSpringboot.repository.OrderRepository;
import com.example.InternSpringboot.repository.ProductRepository;
import com.example.InternSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;

    public OrderResponse newOrder(String UserId, String ProductId, OrderCreationRequest request){
        User user = userRepository.findById(UserId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(ProductId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Orders order = new Orders();
        order.setProduct(product);
        order.setUser(user);
        order.setDob(request.getDob());
        order.setQuantity(request.getQuantity());
        order.setSumMoney(product.getPrice()* request.getQuantity());
        orderRepository.save(order);
        return orderMapper.toOrderResponse(order, userMapper.toUserResponse(user), productMapper.toProductResponse(product));
    }

    public List<OrderResponse> getAllOrder(){
        List<Orders> orders = orderRepository.findAll();
        return orderMapper.toOrderResponse(orders);
    }
}
