package com.example.cs393_project.service;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService
{
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Answer> getAll() {
        List<Answer> answerList = answerRepository.findAll();
        return answerList;
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer getAnswerById(int id) {
        return answerRepository.findById(id).get();
    }



}
