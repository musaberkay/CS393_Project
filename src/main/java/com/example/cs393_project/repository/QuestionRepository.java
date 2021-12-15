package com.example.cs393_project.repository;
import com.example.cs393_project.model.Question;
import com.example.cs393_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>
{
//    @Query()
//    public List<Question> getAll(List<String> questionTag);
//      @Query(INSERT INTO T_QUESTION (TITLE,))

}
