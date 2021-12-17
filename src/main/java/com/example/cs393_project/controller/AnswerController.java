package com.example.cs393_project.controller;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.service.AnswerService;
import com.example.cs393_project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController
{

    @Autowired
    AnswerService answerService;
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Answer> getAll()
    {
        return answerService.getAll();
    }

    @PostMapping("/{answer-id}/comments")
    public Answer createComment(@PathVariable("answer-id") int id, @RequestBody Comment data)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.getComments().add(data);

        return answerService.save(answer);
    }

    @DeleteMapping("/comments/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") int id)
    {
        commentService.deleteById(id);
    }

    @PutMapping()
    public Answer updateAnswer(@RequestBody Answer data)
    {
        return answerService.save(data);
    }

    @PutMapping("/{answer-id}/vote")
    public Answer voteAnswer(@PathVariable("answer-id") int id)
    {
        Answer answer = answerService.getAnswerById(id);
        answer.setVote_count(answer.getVote_count() + 1);
        return answerService.save(answer);
    }

    @PutMapping("/comments/{comment-id}/vote")
    public Comment voteAnswerComments(@PathVariable("comment-id") int id)
    {
        Comment comment = commentService.getCommentById(id);
        comment.setVote_count(comment.getVote_count() + 1);
        return commentService.save(comment);
    }
}
