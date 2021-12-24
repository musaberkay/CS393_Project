package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.DTO.*;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.service.AnswerService;
import com.example.cs393_project.service.CommentService;
import com.example.cs393_project.service.QuestionService;
import com.example.cs393_project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get all questions", description = "You can read information about questions.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public List<QuestionDTO> getAll()
    {
        return questionService.getAll();
    }

    @GetMapping("/tags/{tags}")
    @Operation(summary = "Get related questions by tags", description = "You can read information about related questions.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public List<QuestionDTO> getAllbyTags(@PathVariable("tags") List<String> tags){
        return questionService.getAllbyTags(tags);
    }

    @GetMapping("/{question-id}")
    @Operation(summary = "Get question by id", description = "You can read all information about question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Question getQuestionById(@PathVariable("question-id") int id)
    {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    @Operation(summary = "Create question", description = "You can create question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Question createQuestion(@RequestBody QuestionDTO_Save dto)
    {
        return questionService.save(QuestionMapper_Save.INSTANCE.toObject(dto));
    }

    @PostMapping("/{question-id}/answers")
    @Operation(summary = "Create answer to question", description = "You can create answer to specific question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Question createAnswer(@PathVariable("question-id") int id,@RequestBody AnswerDTO dto)
    {
        Question question = questionService.getQuestionById(id);
        question.getAnswers().add(AnswerMapper.INSTANCE.toObject(dto));
        question.setAnswer_count(question.getAnswer_count()+1);
        return questionService.save(question);
    }

    @PostMapping("/{question-id}/comments")
    @Operation(summary = "Create comment to question", description = "You can create comment to specific question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Question createComments(@PathVariable("question-id") int id,@RequestBody CommentDTO dto)
    {
        Question question = questionService.getQuestionById(id);
        question.getComments().add(CommentMapper.INSTANCE.toObject(dto));
        return questionService.save(question);
    }

    /*@PutMapping()
    public Question updateQuestion(@RequestBody Question data)
    {
        return questionService.save(data);
    }*/

    @PutMapping("/{question-id}/vote/like")
    @Operation(summary = "Like question", description = "You can like specific question with question id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Question likeQuestion(@PathVariable("question-id") int id)
    {
        Question question = questionService.getQuestionById(id);
        question.setVote_count(question.getVote_count() + 1);
        return questionService.save(question);
    }

    @PutMapping("/{question-id}/vote/dislike")
    @Operation(summary = "Dislike question", description = "You can dislike specific question with question id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Question dislikeQuestion(@PathVariable("question-id") int id)
    {
        Question question = questionService.getQuestionById(id);
        question.setVote_count(question.getVote_count() - 1);
        return questionService.save(question);
    }

}