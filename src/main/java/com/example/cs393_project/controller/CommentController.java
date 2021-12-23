package com.example.cs393_project.controller;

import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.DTO.CommentDTO;
import com.example.cs393_project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") int id)
    {
        commentService.deleteById(id);
    }

    @PutMapping("/{comment-id}")
    public Comment updateComment(@PathVariable("comment-id") int id, @RequestBody CommentDTO dto)
    {
        Comment comment = commentService.getCommentById(id);
        comment.setComment_desc(dto.getComment_desc());
        comment.setUser(dto.getUser());
        return commentService.save(comment);
    }

    @PutMapping("/{comment-id}/vote/like")
    public Comment likeQuestionComments(@PathVariable("comment-id") int id)
    {
        Comment comment = commentService.getCommentById(id);
        comment.setVote_count(comment.getVote_count() + 1);
        return commentService.save(comment);
    }
    @PutMapping("/{comment-id}/vote/dislike")
    public Comment dislikeQuestionComments(@PathVariable("comment-id") int id)
    {
        Comment comment = commentService.getCommentById(id);
        comment.setVote_count(comment.getVote_count() - 1);
        return commentService.save(comment);
    }

}
