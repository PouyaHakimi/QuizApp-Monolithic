package com.pouya.QuizApp.controller;

import com.pouya.QuizApp.Model.Question;
import com.pouya.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")

public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("AllQuestions")
    public List<Question> getAllQuestions(){

        System.out.println("heeerreeeeee");
        List<Question> test = questionService.getAllQuestions();
        System.out.println("*************"+test);
        return test;
    }


}
