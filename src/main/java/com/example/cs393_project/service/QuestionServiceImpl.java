package com.example.cs393_project.service;

import com.example.cs393_project.model.DTO.QuestionDTO;
import com.example.cs393_project.model.DTO.QuestionMapper;
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
    public Question getQuestionById(int id)
    {
        return questionRepository.findById(id).get();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }



}
