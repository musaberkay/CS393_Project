package com.example.cs393_project.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_QUESTION")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ask_date = new Date(System.currentTimeMillis());

    @Column(name = "QUESTION_DESC",nullable = false)
    private String question_desc;

    @Column(name = "VOTE_COUNT")
    private int vote_count;

    @Column(name = "ANSWER_COUNT")
    private int answer_count;

    @ElementCollection
    @CollectionTable(name = "T_QUESTION_TAGS", joinColumns = @JoinColumn(name = "QUESTION_ID"))
    private List<String> questionTags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID")
    private List<Answer> answers = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAsk_date(Date ask_date) {
        this.ask_date = ask_date;
    }

    public void setQuestion_desc(String question_desc) {
        this.question_desc = question_desc;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public void setQuestionTags(List<String> questionTags) {
        this.questionTags = questionTags;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getTitle() {
        return title;
    }

    public Date getAsk_date() {
        return ask_date;
    }

    public String getQuestion_desc() {
        return question_desc;
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

    public User getUser() {
        return user;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
