package com.example.cs393_project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany()
    @JoinColumn(name = "USER_ID")
    private List<Question> questions = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<Answer> answers = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<Comment> comments = new ArrayList<>();
}
