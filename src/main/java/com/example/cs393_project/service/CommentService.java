package com.example.cs393_project.service;

import com.example.cs393_project.model.Comment;

public interface CommentService
{
     Comment save(Comment comment);
     void deleteById(int id);
     Comment getCommentById(int id);
}
