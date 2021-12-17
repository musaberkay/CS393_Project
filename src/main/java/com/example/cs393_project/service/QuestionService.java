package com.example.cs393_project.service;

import com.example.cs393_project.model.Question;

import java.util.List;

public interface QuestionService {
     List<Question> getAll();
     Question getQuestionById(int id);
     Question save(Question question);

}
