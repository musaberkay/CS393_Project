package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SpecificQuestionMapper {
    SpecificQuestionMapper INSTANCE = Mappers.getMapper(SpecificQuestionMapper.class);

    Question toObject(SpecificQuestionDTO dto);
    SpecificQuestionDTO toDto(Question question);
}
