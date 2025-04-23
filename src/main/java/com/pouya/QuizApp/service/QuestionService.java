package com.pouya.QuizApp.service;

import com.pouya.QuizApp.DAO.QuestionDao;
import com.pouya.QuizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }


}
