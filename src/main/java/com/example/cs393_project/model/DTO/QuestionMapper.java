package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Named("question_desc_Shorter")
    public static String question_desc_Shorter(String question_desc){
        return question_desc.substring(0, Math.min(question_desc.length(), 99));
    }

    @Mapping(source="question_desc", target="short_question_desc",
            qualifiedByName = "question_desc_Shorter")
    QuestionDTO toDto(Question question);
}
