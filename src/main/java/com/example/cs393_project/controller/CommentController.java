package com.example.cs393_project.controller;

import com.example.cs393_project.model.DTO.CommentDTO_Update;
import com.example.cs393_project.model.DTO.CommentVote_DTO;
import com.example.cs393_project.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @DeleteMapping("/{comment-id}")
    @Operation(summary = "Delete comment", description = "You can delete any specific comment.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public void deleteComment(@PathVariable("comment-id") int id)
    {
        commentService.deleteById(id);
    }

    @PutMapping("/{comment-id}")
    @Operation(summary = "Update comment", description = "You can update specific comment with comment id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public CommentDTO_Update updateComment(@PathVariable("comment-id") int id, @RequestBody CommentDTO_Update dto)
    {
        return commentService.updateComment(id,dto);
    }

    @PutMapping("/{comment-id}/vote/like")
    @Operation(summary = "Like comment", description = "You can like specific comment with comment id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public CommentVote_DTO likeQuestionComments(@PathVariable("comment-id") int id)
    {
        return commentService.likeComment(id);
    }

    @PutMapping("/{comment-id}/vote/dislike")
    @Operation(summary = "Dislike comment", description = "You can dislike specific comment with comment id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    public CommentVote_DTO dislikeQuestionComments(@PathVariable("comment-id") int id)
    {
        return commentService.dislikeComment(id);
    }

}
