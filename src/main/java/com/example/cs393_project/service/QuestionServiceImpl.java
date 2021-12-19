package com.example.cs393_project.service;

import com.example.cs393_project.model.DTO.QuestionDTO;
import com.example.cs393_project.model.DTO.QuestionMapper;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<QuestionDTO> getAll(){
        List<QuestionDTO> list = new ArrayList<>();
        List<Question> questionList = questionRepository.findAll();
        for(Question question: questionList){
            QuestionDTO dto = QuestionMapper.INSTANCE.toDto(question);
            list.add(dto);
        }
        return list;
    }

    @Override
    public List<QuestionDTO> getAllbyTags(List<String> tags) {
        List<QuestionDTO> list = new ArrayList<>();
        List<Question> questionList = questionRepository.findAll();
        for(String tag: tags){
            for(Question question: questionList){
                if(question.getQuestionTags().contains(tag)){
                    QuestionDTO dto = QuestionMapper.INSTANCE.toDto(question);
                    if(!list.contains(dto)){
                        list.add(dto);
                    }
                }
            }
        }
        return list;
    }


    public Question getQuestionById(int id)
    {
        return questionRepository.findById(id).get();
    }

    public Question save(Question question)
    {
        return questionRepository.save(question);
    }


}
