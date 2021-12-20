package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.Question;
import com.example.cs393_project.model.User;
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

    @Named("getUsername")
    public static UserDTO getUsername(User user){
        return UserMapper.INSTANCE.toDto(user);
    }

    @Mapping(source="question_desc", target="short_question_desc", qualifiedByName = "question_desc_Shorter")
    @Mapping(source="user", target="user", qualifiedByName = "getUsername")
    QuestionDTO toDto(Question question);
}
