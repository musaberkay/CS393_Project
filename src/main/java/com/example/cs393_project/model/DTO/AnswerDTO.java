package com.example.cs393_project.model.DTO;

public class AnswerDTO {
    private String answer_desc;
    private UserDTO_Save user;

    public String getAnswer_desc() {
        return answer_desc;
    }

    public void setAnswer_desc(String answer_desc) {
        this.answer_desc = answer_desc;
    }

    public UserDTO_Save getUser() {
        return user;
    }

    public void setUser(UserDTO_Save user) {
        this.user = user;
    }
}
