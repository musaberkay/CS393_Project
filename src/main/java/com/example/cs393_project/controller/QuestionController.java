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
    public SpecificQuestionDTO getQuestionById(@PathVariable("question-id") int id)
    {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    @Operation(summary = "Create question", description = "You can create question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public QuestionDTO_Save createQuestion(@RequestBody QuestionDTO_Save dto)
    {
        return questionService.save(dto);
    }

    @PostMapping("/{question-id}/answers")
    @Operation(summary = "Create answer to question", description = "You can create answer to specific question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public AnswerDTO createAnswer(@PathVariable("question-id") int id,@RequestBody AnswerDTO dto)
    {
        return questionService.createAnswer(id, dto);
    }

    @PostMapping("/{question-id}/comments")
    @Operation(summary = "Create comment to question", description = "You can create comment to specific question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public CommentDTO createComment(@PathVariable("question-id") int id,@RequestBody CommentDTO dto)
    {
        return questionService.createComment(id, dto);
    }


    @PutMapping("/{question-id}/vote/like")
    @Operation(summary = "Like question", description = "You can like specific question with question id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public QuestionDTO likeQuestion(@PathVariable("question-id") int id)
    {
        return questionService.likeQuestion(id);
    }

    @PutMapping("/{question-id}/vote/dislike")
    @Operation(summary = "Dislike question", description = "You can dislike specific question with question id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public QuestionDTO dislikeQuestion(@PathVariable("question-id") int id)
    {
        return questionService.dislikeQuestion(id);
    }

}