package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentVoteMapper {
    CommentVoteMapper INSTANCE = Mappers.getMapper(CommentVoteMapper.class);

    Comment toObject(CommentVote_DTO dto);
    CommentVote_DTO toDto(Comment comment);
}
