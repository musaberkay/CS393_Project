package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerVoteMapper {
    AnswerVoteMapper INSTANCE = Mappers.getMapper(AnswerVoteMapper.class);

    Answer toObject(AnswerVote_DTO dto);
    AnswerVote_DTO toDto(Answer answer);
}
