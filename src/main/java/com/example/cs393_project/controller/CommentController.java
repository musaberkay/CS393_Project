package com.example.cs393_project.controller;

import com.example.cs393_project.model.Comment;
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

    @PutMapping()
    public Comment updateComment(@RequestBody Comment data)
    {
        return commentService.save(data);
    }

    @PutMapping("{comment-id}/vote/like")
    public Comment likeQuestionComments(@PathVariable("comment-id") int id)
    {
        Comment comment = commentService.getCommentById(id);
        comment.setVote_count(comment.getVote_count() + 1);
        return commentService.save(comment);
    }
    @PutMapping("{comment-id}/vote/dislike")
    public Comment dislikeQuestionComments(@PathVariable("comment-id") int id)
    {
        Comment comment = commentService.getCommentById(id);
        comment.setVote_count(comment.getVote_count() - 1);
        return commentService.save(comment);
    }

}
