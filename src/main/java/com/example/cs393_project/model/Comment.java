package com.example.cs393_project.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_COMMENT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String comment_desc;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date(System.currentTimeMillis());
    @ManyToOne
    private User user;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Answer answer;

    @Column(name = "VOTE_COUNT")
    private int vote_count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
