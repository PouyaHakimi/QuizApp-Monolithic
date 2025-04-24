package com.pouya.QuizApp.DAO;

import com.pouya.QuizApp.Model.Question;
import com.pouya.QuizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {


}
