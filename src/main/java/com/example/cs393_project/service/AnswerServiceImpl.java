package com.example.cs393_project.service;

import com.example.cs393_project.model.Answer;
import com.example.cs393_project.model.DTO.*;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService
{
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public CommentDTO createComment(int id, CommentDTO commentDTO){
        Answer answer = answerRepository.getAnswerById(id);
        answer.getComments().add(CommentMapper.INSTANCE.toObject(commentDTO));
        answerRepository.save(answer);
        return commentDTO;
    }

    @Override
    public AnswerDTO_Update updateAnswer(int id, AnswerDTO_Update answerDTO_update) {
        Answer answer = answerRepository.getAnswerById(id);
        answer.setAnswer_desc(answerDTO_update.getAnswer_desc());
        answerRepository.save(answer);
        return answerDTO_update;
    }

    @Override
    public AnswerVote_DTO likeAnswer(int id){
        Answer answer = answerRepository.getAnswerById(id);
        answer.setVote_count(answer.getVote_count() + 1);
        answerRepository.save(answer);
        return AnswerVoteMapper.INSTANCE.toDto(answer);
    }

    @Override
    public AnswerVote_DTO dislikeAnswer(int id) {
        Answer answer = answerRepository.getAnswerById(id);
        answer.setVote_count(answer.getVote_count() - 1);
        answerRepository.save(answer);
        return AnswerVoteMapper.INSTANCE.toDto(answer);
    }
}
