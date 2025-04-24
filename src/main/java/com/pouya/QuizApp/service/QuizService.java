package com.pouya.QuizApp.service;

import com.pouya.QuizApp.DAO.QuestionDao;
import com.pouya.QuizApp.DAO.QuizDao;
import com.pouya.QuizApp.Model.Question;
import com.pouya.QuizApp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String tittle) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ,tittle);

        Quiz quiz = new Quiz();
        quiz.setTitle(tittle);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
