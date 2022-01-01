package com.example.cs393_project.repository;
import com.example.cs393_project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cs393_project.model.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer>
{
    Answer getAnswerById(int id);
}
