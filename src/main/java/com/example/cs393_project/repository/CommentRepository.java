package com.example.cs393_project.repository;

import com.example.cs393_project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>
{
    Comment getCommentById(int id);
}
