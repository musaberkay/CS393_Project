package com.example.cs393_project.model.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionDTO {
    private String title;
    private Date ask_date = new Date(System.currentTimeMillis());
    private String short_question_desc;
    private int vote_count;
    private int answer_count;
    private List<String> questionTags = new ArrayList<>();
    private UserDTO user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAsk_date() {
        return ask_date;
    }

    public void setAsk_date(Date ask_date) {
        this.ask_date = ask_date;
    }

    public String getShort_question_desc() {
        return short_question_desc;
    }

    public void setShort_question_desc(String short_question_desc) {
        this.short_question_desc = short_question_desc;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public List<String> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(List<String> questionTags) {
        this.questionTags = questionTags;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
