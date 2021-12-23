package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    Answer toObject(AnswerDTO dto);
}
