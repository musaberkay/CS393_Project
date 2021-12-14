package com.example.cs393_project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String answer_desc;
    @Temporal(TemporalType.DATE)
    private Date answer_date;
    @Column(nullable = false)
    private int vote_count;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "answer")
    @JoinColumn(name = "ANSWER_ID")
    private List<Comment> comments = new ArrayList<>();
}
