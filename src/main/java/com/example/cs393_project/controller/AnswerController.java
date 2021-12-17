package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.service.AnswerService;
import com.example.cs393_project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController
{

    @Autowired
    AnswerService answerService;
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Answer> getAll()
    {
        return answerService.getAll();
    }

    @PostMapping("/{answer-id}/commentforanswer")
    public Answer createCommentforAnswer(@PathVariable("answer-id") int id, @RequestBody Comment data)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.getComments().add(data);

        return answerService.save(answer);
    }

    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") int id)
    {
        commentService.deleteById(id);
    }

    @PutMapping()
    public Answer updateQuestion(@RequestBody Answer data)
    {
        return answerService.save(data);
    }
}
