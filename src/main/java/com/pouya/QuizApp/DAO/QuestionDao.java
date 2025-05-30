package com.pouya.QuizApp.DAO;

import com.pouya.QuizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


    List<Question> findByCategoryIgnoreCase(String category);

    @Query(value = "select * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ" ,nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
