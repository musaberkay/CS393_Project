package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController
{

    @Autowired
    AnswerService answerService;

    @PostMapping("/{answer-id}/commentforanswer")
    public Answer createCommentforAnswer(@PathVariable("answer-id") int id, @RequestBody Comment data)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.getComments().add(data);

        return answerService.save(answer);
    }
}
