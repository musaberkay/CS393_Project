package com.example.cs393_project.repository;
import com.example.cs393_project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>
{
    List<Question> getQuestionByQuestionTagsIn(List<String> tags);
    Question getQuestionById(int id);
}
