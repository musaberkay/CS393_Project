package com.example.cs393_project.service;

import com.example.cs393_project.model.Question;
import com.example.cs393_project.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestQuestionService
{
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;

    @Test
    public void testCreateQuestion()
    {
        // creation of user1
        User user = new User();
        user.setName("Ali Şaşal");
        userService.save(user);

        //creation of user2
        User user2 = new User();
        user2.setName("İrfancan Eğribayat");
        userService.save(user2);

        // creation of questionTags
        List<String> q_tags = new ArrayList<>();
        q_tags.add("JAVA");
        q_tags.add("SPRING");
        q_tags.add("SQL");

        // creation of question
        Question question = new Question();
        question.setTitle("SPRINGBOOT BEAN PROBLEM");
        question.setQuestionTags(q_tags);
        question.setQuestion_desc("How will i use insert statement in native sql structure in my Springboot project?");
        question.setUser(user);
        user.getQuestions().add(question);


        questionService.save(question);



    }
}
