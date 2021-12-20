package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.DTO.QuestionDTO;
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
    public List<QuestionDTO> getAll()
    {
        return questionService.getAll();
    }

    @GetMapping("/tags/{tags}")
    public List<QuestionDTO> getAllbyTags(@PathVariable("tags") List<String> tags){
        return questionService.getAllbyTags(tags);
    }

    @GetMapping("/{question-id}")
    public Question getQuestionById(@PathVariable("question-id") int id)
    {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question)
    {
        return questionService.save(question);
    }

    @PostMapping("/{question-id}/answers")
    public Question createAnswer(@PathVariable("question-id") int id,@RequestBody Answer data)
    {
        Question question = questionService.getQuestionById(id);
        question.getAnswers().add(data);
        question.setAnswer_count(question.getAnswer_count()+1);
        return questionService.save(question);
    }

    @PostMapping("/{question-id}/comments")
    public Question createComments(@PathVariable("question-id") int id,@RequestBody Comment data)
    {
        Question question = questionService.getQuestionById(id);
        question.getComments().add(data);

        return questionService.save(question);
    }

    @PutMapping()
    public Question updateQuestion(@RequestBody Question data)
    {
        return questionService.save(data);
    }

    @PutMapping("/{question-id}/vote/like")
    public Question likeQuestion(@PathVariable("question-id") int id)
    {
        Question question = questionService.getQuestionById(id);
        question.setVote_count(question.getVote_count() + 1);
        return questionService.save(question);
    }

    @PutMapping("/{question-id}/vote/dislike")
    public Question dislikeQuestion(@PathVariable("question-id") int id)
    {
        Question question = questionService.getQuestionById(id);
        question.setVote_count(question.getVote_count() - 1);
        return questionService.save(question);
    }

}