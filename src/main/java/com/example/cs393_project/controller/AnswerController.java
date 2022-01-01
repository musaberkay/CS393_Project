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

    @PostMapping("/{answer-id}/comments")
    @Operation(summary = "Create comment to answer", description = "You can create comment to specific answer.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public CommentDTO createComment(@PathVariable("answer-id") int id, @RequestBody CommentDTO dto)
    {
        return answerService.createComment(id,dto);
    }

    @PutMapping("/{answer-id}")
    @Operation(summary = "Update answer", description = "You can update specific answer with answer id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public AnswerDTO_Update updateAnswer(@PathVariable("answer-id") int id, @RequestBody AnswerDTO_Update dto)
    {
        return answerService.updateAnswer(id,dto);
    }

    @PutMapping("/{answer-id}/vote/like")
    @Operation(summary = "Like answer", description = "You can like specific answer with answer id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public AnswerVote_DTO likeAnswer(@PathVariable("answer-id") int id)
    {
        return answerService.likeAnswer(id);
    }

    @PutMapping("/{answer-id}/vote/dislike")
    @Operation(summary = "Dislike answer", description = "You can dislike specific answer with answer id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public AnswerVote_DTO dislikeAnswer(@PathVariable("answer-id") int id)
    {
        return answerService.dislikeAnswer(id);
    }

}
