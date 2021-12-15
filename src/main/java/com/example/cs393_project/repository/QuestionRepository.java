package com.example.cs393_project.repository;
import com.example.cs393_project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer>
{

}
