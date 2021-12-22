package com.example.cs393_project.service;

import com.example.cs393_project.model.DTO.QuestionDTO;
import com.example.cs393_project.model.Question;

import java.util.List;

public interface QuestionService {
     List<QuestionDTO> getAll();
     List<Question> getAllbyTags(List<String> tags);
     Question getQuestionById(int id);
     Question save(Question question);

}
