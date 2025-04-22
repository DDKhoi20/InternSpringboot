package com.example.InternSpringboot.mapper;

import com.example.InternSpringboot.dto.request.UserCreationRequest;
import com.example.InternSpringboot.dto.request.UserUpdateRequest;
import com.example.InternSpringboot.dto.response.UserResponse;
import com.example.InternSpringboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    @Mapping(target = "username", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
