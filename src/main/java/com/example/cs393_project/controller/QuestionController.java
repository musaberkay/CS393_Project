package com.example.cs393_project.controller;

import com.example.cs393_project.model.Question;
import com.example.cs393_project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    public List<Question> getAll()
    {
        return questionService.getAll();
    }

    @GetMapping("/{question-id}")
    public Question getQuestionById(@PathVariable("question-id") int id)
    {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question data)
    {
        return questionService.save(data);
    }


}