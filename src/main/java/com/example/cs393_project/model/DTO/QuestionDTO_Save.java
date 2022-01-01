package com.example.cs393_project.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO_Save {
    private String title;
    private String question_desc;
    private List<String> questionTags = new ArrayList<>();
    private UserDTO_Save user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion_desc() {
        return question_desc;
    }

    public void setQuestion_desc(String question_desc) {
        this.question_desc = question_desc;
    }

    public List<String> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(List<String> questionTags) {
        this.questionTags = questionTags;
    }

    public UserDTO_Save getUser() {
        return user;
    }

    public void setUser(UserDTO_Save user) {
        this.user = user;
    }
}
