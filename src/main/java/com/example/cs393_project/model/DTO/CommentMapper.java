package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment toObject(CommentDTO dto);
}
