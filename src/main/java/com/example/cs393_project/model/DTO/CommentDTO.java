package com.example.cs393_project.model.DTO;

public class CommentDTO {
    private String comment_desc;
    private UserDTO_Save user;

    public String getComment_desc() {
        return comment_desc;
    }

    public void setComment_desc(String comment_desc) {
        this.comment_desc = comment_desc;
    }

    public UserDTO_Save getUser() {
        return user;
    }

    public void setUser(UserDTO_Save user) {
        this.user = user;
    }
}
