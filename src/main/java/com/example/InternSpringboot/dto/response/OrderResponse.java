package com.example.InternSpringboot.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    String id;
    int quantity;
    double sumMoney;
    LocalDate dob;
    UserResponse userResponse;
    ProductResponse productResponse;
}
