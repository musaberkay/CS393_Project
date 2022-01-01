package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Question;
import com.example.cs393_project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper_Save {
    QuestionMapper_Save INSTANCE = Mappers.getMapper(QuestionMapper_Save.class);

    Question toObject(QuestionDTO_Save dto);
    QuestionDTO_Save toDto(Question question);
}
