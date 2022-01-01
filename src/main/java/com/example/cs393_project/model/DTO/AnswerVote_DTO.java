package com.example.cs393_project.model.DTO;


import java.util.Date;

public class AnswerVote_DTO {

    private String answer_desc;

    private Date answer_date = new Date(System.currentTimeMillis());

    private int vote_count;

    private UserDTO user;

    public String getAnswer_desc() {
        return answer_desc;
    }

    public void setAnswer_desc(String answer_desc) {
        this.answer_desc = answer_desc;
    }

    public Date getAnswer_date() {
        return answer_date;
    }

    public void setAnswer_date(Date answer_date) {
        this.answer_date = answer_date;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
