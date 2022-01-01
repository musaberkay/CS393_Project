package com.example.cs393_project.service;

import com.example.cs393_project.model.DTO.*;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.repository.QuestionRepository;
import com.example.cs393_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<QuestionDTO> getAll(){
        List<QuestionDTO> list = new ArrayList<>();
        for(Question question: questionRepository.findAll()){
            list.add(QuestionMapper.INSTANCE.toDto(question));
        }
        return list;
    }

    @Override
    public List<QuestionDTO> getAllbyTags(List<String> tags) {
        List<QuestionDTO> list = new ArrayList<>();
        for(Question question: questionRepository.getQuestionByQuestionTagsIn(tags)) {
            list.add(QuestionMapper.INSTANCE.toDto(question));
        }
        return list;
    }

    @Override
    public SpecificQuestionDTO getQuestionById(int id)
    {
        return SpecificQuestionMapper.INSTANCE.toDto(questionRepository.getQuestionById(id));
    }

    @Override
    public QuestionDTO_Save save(QuestionDTO_Save dto) {
        questionRepository.save(QuestionMapper_Save.INSTANCE.toObject(dto));
        return dto;
    }

    @Override
    public AnswerDTO createAnswer(int id, AnswerDTO answerDTO){
        Question question = questionRepository.getQuestionById(id);
        question.getAnswers().add(AnswerMapper.INSTANCE.toObject(answerDTO));
        question.setAnswer_count(question.getAnswer_count()+1);
        questionRepository.save(question);
        return answerDTO;
    }

    @Override
    public CommentDTO createComment(int id, CommentDTO commentDTO){
        Question question = questionRepository.getQuestionById(id);
        question.getComments().add(CommentMapper.INSTANCE.toObject(commentDTO));
        questionRepository.save(question);
        return commentDTO;
    }

    @Override
    public QuestionDTO likeQuestion(int id){
        Question question = questionRepository.getQuestionById(id);
        question.setVote_count(question.getVote_count() + 1);
        questionRepository.save(question);
        return QuestionMapper.INSTANCE.toDto(question);
    }

    @Override
    public QuestionDTO dislikeQuestion(int id) {
        Question question = questionRepository.getQuestionById(id);
        question.setVote_count(question.getVote_count() - 1);
        questionRepository.save(question);
        return QuestionMapper.INSTANCE.toDto(question);
    }
}
