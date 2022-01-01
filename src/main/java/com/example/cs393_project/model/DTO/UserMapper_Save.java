package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper_Save {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO_Save toDto(User user);
    User toObject(UserDTO_Save dto);
}
