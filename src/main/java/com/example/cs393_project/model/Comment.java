package com.example.cs393_project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String comment_desc;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Answer answer;
}
