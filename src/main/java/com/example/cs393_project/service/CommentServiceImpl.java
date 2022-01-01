package com.example.cs393_project.service;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.Comment;
import com.example.cs393_project.model.DTO.*;
import com.example.cs393_project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService
{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDTO_Update updateComment(int id, CommentDTO_Update commentDTO_update) {
        Comment comment = commentRepository.getCommentById(id);
        comment.setComment_desc(commentDTO_update.getComment_desc());
        commentRepository.save(comment);
        return commentDTO_update;
    }

    @Override
    public CommentVote_DTO likeComment(int id){
        Comment comment = commentRepository.getCommentById(id);
        comment.setVote_count(comment.getVote_count() + 1);
        commentRepository.save(comment);
        return CommentVoteMapper.INSTANCE.toDto(comment);
    }

    @Override
    public CommentVote_DTO dislikeComment(int id){
        Comment comment = commentRepository.getCommentById(id);
        comment.setVote_count(comment.getVote_count() - 1);
        commentRepository.save(comment);
        return CommentVoteMapper.INSTANCE.toDto(comment);
    }

}
