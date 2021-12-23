package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.DTO.*;
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
    public Question createQuestion(@RequestBody QuestionDTO_Save dto)
    {
        return questionService.save(QuestionMapper_Save.INSTANCE.toObject(dto));
    }

    @PostMapping("/{question-id}/answers")
    public Question createAnswer(@PathVariable("question-id") int id,@RequestBody AnswerDTO dto)
    {
        Question question = questionService.getQuestionById(id);
        question.getAnswers().add(AnswerMapper.INSTANCE.toObject(dto));
        question.setAnswer_count(question.getAnswer_count()+1);
        return questionService.save(question);
    }

    @PostMapping("/{question-id}/comments")
    public Question createComments(@PathVariable("question-id") int id,@RequestBody CommentDTO dto)
    {
        Question question = questionService.getQuestionById(id);
        question.getComments().add(CommentMapper.INSTANCE.toObject(dto));
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