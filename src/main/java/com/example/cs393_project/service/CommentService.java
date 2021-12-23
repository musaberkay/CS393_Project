package com.example.cs393_project.service;

import com.example.cs393_project.model.Comment;

import java.util.List;

public interface CommentService
{
     Comment save(Comment comment);
     void deleteById(int id);
     Comment getCommentById(int id);
}
