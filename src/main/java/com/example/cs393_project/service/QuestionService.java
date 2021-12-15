package com.example.cs393_project.service;

import com.example.cs393_project.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {
    public List<Question> getAll();
    public Question getQuestionById(int id);
    public Question save(Question question);
//    public List<Question> getAll(List<String> questionTag);
}
