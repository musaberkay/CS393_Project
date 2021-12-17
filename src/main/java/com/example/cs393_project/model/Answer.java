package com.example.cs393_project.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ANSWER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String answer_desc;
    @Temporal(TemporalType.DATE)
    private Date answer_date;

    private int vote_count;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANSWER_ID")
   // @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
