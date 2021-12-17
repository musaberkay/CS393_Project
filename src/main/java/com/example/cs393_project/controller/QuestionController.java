package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.service.AnswerService;
import com.example.cs393_project.service.CommentService;
import com.example.cs393_project.service.QuestionService;
import com.example.cs393_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController
{
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    AnswerService answerService;

    @GetMapping
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

    @PostMapping("/{question-id}/answers")
    public Question createAnswer(@PathVariable("question-id") int id,@RequestBody Answer data)
    {
        Question question = questionService.getQuestionById(id);
        question.getAnswers().add(data);

        return questionService.save(question);
    }

    @PostMapping("/{question-id}/comments")
    public Question createComments(@PathVariable("question-id") int id,@RequestBody Comment data)
    {
        Question question = questionService.getQuestionById(id);
        question.getComments().add(data);

        return questionService.save(question);
    }

    @DeleteMapping("/comments/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") int id)
    {
        commentService.deleteById(id);
    }

    @PutMapping()
    public Question updateQuestion(@RequestBody Question data)
    {
        return questionService.save(data);
    }

    @PutMapping("/{question-id}/vote")
    public Question voteQuestion(@PathVariable("question-id") int id)
    {
        Question question = questionService.getQuestionById(id);
        question.setVote_count(question.getVote_count() + 1);
        return questionService.save(question);
    }

    @PutMapping("/comments/{comment-id}/vote")
    public Comment voteQuestionComments(@PathVariable("comment-id") int id)
    {
        Comment comment = commentService.getCommentById(id);
        comment.setVote_count(comment.getVote_count() + 1);
        return commentService.save(comment);
    }

}