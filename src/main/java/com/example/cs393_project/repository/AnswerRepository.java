package com.example.cs393_project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cs393_project.model.Answer;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer>
{

}
