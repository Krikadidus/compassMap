package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/question")
public class QuestionRestController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/create")
    public Question createQuestion(@RequestBody  Question question) {
        Question newQuestion = questionService.createQuestion(question);
        System.out.println("Service createQuestion: " + newQuestion);
        return newQuestion;
    }
    @PostMapping("/createAll")
    public Iterable<Question> createAllQuestion(@RequestBody Iterable<Question> questions) {
        Iterable<Question> newQuestions = questionService.saveAll(questions);
        System.out.println("Service createAllQuestions: " + questions);
        return newQuestions;
    }

   //----------------------------- UPDATE -----------------------------
    @PutMapping("/byId")
    public Question updateQuestion(@RequestBody Question question) {
        if (question.getId() == null || questionService.getQuestionById(question.getId()) == null) {
            return null;
        }
        Question updatedQuestion = questionService.updateQuestion(question);
        System.out.println("Service updateQuestion: " + updatedQuestion);
        return updatedQuestion;
    }
    //----------------------------- GET -----------------------------
    @GetMapping("/byId")
    public Question getQuestionById(@RequestParam("id") String id) {
        Question foundQuestion = questionService.getQuestionById (id);
        if (foundQuestion == null) {
            return null;
        }
        System.out.println("Service getQuestion: " + foundQuestion);
        return foundQuestion;
    }
    @GetMapping("/all")
    public Iterable<Question> getAllQuestions(){
        Iterable<Question> questions =  questionService.getAllQuestions();
        System.out.println("Service getAllQuestions: " + questions);
        return questions;
    }

    //------------------ DELETE ----------------------
    @DeleteMapping("/byId")
    public void deleteById(@RequestParam("id") String id){
        Question foundQuestion = questionService.getQuestionById (id);
        if (foundQuestion == null) {
            System.out.println( "Service getQuestionById: " + id + " not found");;
        }
        questionService.deleteQuestion(id);
        System.out.println("Service deleteQuestion: " + foundQuestion);
    }
    @DeleteMapping("/all")
    public void deleteAllQuestions() {
        questionService.deleteAllQuestions();
    }

}

