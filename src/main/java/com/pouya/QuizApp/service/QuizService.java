package com.pouya.QuizApp.service;

import com.pouya.QuizApp.DAO.QuestionDao;
import com.pouya.QuizApp.DAO.QuizDao;
import com.pouya.QuizApp.Model.Question;
import com.pouya.QuizApp.Model.QuestionWraper;
import com.pouya.QuizApp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String tittle) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(tittle);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWraper>> getUserQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWraper> userQuestions = new ArrayList<>();

        for (Question q: questionFromDB){
            QuestionWraper qw =new QuestionWraper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
            userQuestions.add(qw);
        }

        return new ResponseEntity<>(userQuestions,HttpStatus.OK);

    }
}
