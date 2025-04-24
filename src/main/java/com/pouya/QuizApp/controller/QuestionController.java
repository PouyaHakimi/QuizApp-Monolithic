package com.pouya.QuizApp.controller;

import com.pouya.QuizApp.Model.Question;
import com.pouya.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")

public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("AllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return  questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Question>> getQusetionByCategory(@PathVariable("cat") String category){
        return questionService.findByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }


}
