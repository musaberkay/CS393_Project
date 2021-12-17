package com.example.cs393_project.service;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Question;

import java.util.List;

public interface AnswerService
{
    public Answer save(Answer answer);
    public Answer getAnswerById(int id);
    public List<Answer> getAll();
}
