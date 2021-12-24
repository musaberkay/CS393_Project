package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.DTO.*;
import com.example.cs393_project.service.AnswerService;
import com.example.cs393_project.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController
{

    @Autowired
    AnswerService answerService;
    @Autowired
    CommentService commentService;

    /*@GetMapping
    @Operation(summary = "Get all answers", description = "You can read information about anwers.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public List<Answer> getAll()
    {
        return answerService.getAll();
    }*/

    @PostMapping("/{answer-id}/comments")
    @Operation(summary = "Create comment to answer", description = "You can create comment to specific answer.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Answer createComment(@PathVariable("answer-id") int id, @RequestBody CommentDTO dto)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.getComments().add(CommentMapper.INSTANCE.toObject(dto));
        return answerService.save(answer);
    }

    @PutMapping("/{answer-id}")
    @Operation(summary = "Update answer", description = "You can update specific answer with answer id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Answer updateAnswer(@PathVariable("answer-id") int id, @RequestBody AnswerDTO_Update dto)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.setAnswer_desc(dto.getAnswer_desc());
        return answerService.save(answer);
    }

    @PutMapping("/{answer-id}/vote/like")
    @Operation(summary = "Like answer", description = "You can like specific answer with answer id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Answer likeAnswer(@PathVariable("answer-id") int id)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.setVote_count(answer.getVote_count() + 1);
        return answerService.save(answer);
    }

    @PutMapping("/{answer-id}/vote/dislike")
    @Operation(summary = "Dislike answer", description = "You can dislike specific answer with answer id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public Answer dislikeAnswer(@PathVariable("answer-id") int id)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.setVote_count(answer.getVote_count() - 1);
        return answerService.save(answer);
    }

}
