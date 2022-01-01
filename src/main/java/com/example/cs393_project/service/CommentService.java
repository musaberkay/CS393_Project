package com.example.cs393_project.service;

import com.example.cs393_project.model.DTO.CommentDTO_Update;
import com.example.cs393_project.model.DTO.CommentVote_DTO;


public interface CommentService
{
     void deleteById(int id);
     CommentDTO_Update updateComment(int id, CommentDTO_Update commentDTO_update);
     CommentVote_DTO likeComment(int id);
     CommentVote_DTO dislikeComment(int id);
}
