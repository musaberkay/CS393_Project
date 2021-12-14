package com.example.cs393_project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=50, nullable = false)
    private String title;
    @Temporal(TemporalType.DATE)
    private Date ask_date;
    @Column(nullable = false)
    private String question_desc;
    @Column(nullable = false)
    private int view_count;
    @Column(nullable = false)
    private int vote_count;
    @Column(nullable = false)
    private int answer_count;
    @Transient
    private List<String> tags = new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany
    @JoinColumn(name = "QUESTION_ID")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "QUESTION_ID")
    private List<Answer> answers = new ArrayList<>();
}
