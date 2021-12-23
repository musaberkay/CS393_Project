package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.User;


public class AnswerDTO {
    private String answer_desc;
    private User user;

    public String getAnswer_desc() {
        return answer_desc;
    }

    public void setAnswer_desc(String answer_desc) {
        this.answer_desc = answer_desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
