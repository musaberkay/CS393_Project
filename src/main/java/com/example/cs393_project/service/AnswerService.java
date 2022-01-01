package com.example.cs393_project.service;

import com.example.cs393_project.model.DTO.AnswerDTO_Update;
import com.example.cs393_project.model.DTO.AnswerVote_DTO;
import com.example.cs393_project.model.DTO.CommentDTO;


public interface AnswerService
{
     CommentDTO createComment(int id, CommentDTO commentDTO);
     AnswerDTO_Update updateAnswer(int id, AnswerDTO_Update answerDTO_update);
     AnswerVote_DTO likeAnswer(int id);
     AnswerVote_DTO dislikeAnswer(int id);
}
