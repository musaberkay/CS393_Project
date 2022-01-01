package com.example.cs393_project.service;

import com.example.cs393_project.model.DTO.*;
import com.example.cs393_project.model.Question;

import java.util.List;

public interface QuestionService {
     List<QuestionDTO> getAll();
     List<QuestionDTO> getAllbyTags(List<String> tags);
     SpecificQuestionDTO getQuestionById(int id);
     QuestionDTO_Save save(QuestionDTO_Save dto);
     AnswerDTO createAnswer(int id, AnswerDTO answerDTO);
     CommentDTO createComment(int id, CommentDTO commentDTO);
     QuestionDTO likeQuestion(int id);
     QuestionDTO dislikeQuestion(int id);

}
