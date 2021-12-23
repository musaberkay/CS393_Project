package com.example.cs393_project.model.DTO;

import com.example.cs393_project.model.User;


public class CommentDTO {
    private String comment_desc;
    private User user;

    public String getComment_desc() {
        return comment_desc;
    }

    public void setComment_desc(String comment_desc) {
        this.comment_desc = comment_desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
