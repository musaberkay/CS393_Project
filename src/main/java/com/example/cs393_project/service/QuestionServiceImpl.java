package com.example.cs393_project.service;

import com.example.cs393_project.model.Question;
import com.example.cs393_project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAll()
    {
        List<Question> questionList = questionRepository.findAll();
        return questionList;
    }

    public Question getQuestionById(int id)
    {
        return questionRepository.findById(id).get();
    }

    public Question save(Question question)
    {
        return questionRepository.save(question);
    }


}
