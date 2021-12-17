package com.example.cs393_project.service;

import com.example.cs393_project.model.Answer;

import java.util.List;

public interface AnswerService
{
     Answer save(Answer answer);
     Answer getAnswerById(int id);
     List<Answer> getAll();
}
