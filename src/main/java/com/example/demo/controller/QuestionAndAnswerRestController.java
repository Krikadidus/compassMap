package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.service.QuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/questionandanswer")

public class QuestionAndAnswerRestController {

    @Autowired
    private QuestionAndAnswerService questionAndAnswerService;

    //----------------------------- Create -----------------------------
    @PostMapping("/create_part")
    public QuestionAndAnswer createQuestionAndAnswer1(@RequestBody Question question, Answer answer) {
        QuestionAndAnswer newQuestionAndAnswer = questionAndAnswerService.createQuestionAndAnswer1(question,answer);
        System.out.println("Service createQuestionAndAnswer: " + newQuestionAndAnswer);
        return newQuestionAndAnswer;
    }
    @PostMapping("/create_full")
    public QuestionAndAnswer createQuestionAndAnswer2(@RequestBody QuestionAndAnswer questionAndAnswer) {
        QuestionAndAnswer newQuestionAndAnswer = questionAndAnswerService.createQuestionAndAnswer2(questionAndAnswer);
        System.out.println("Service createQuestionAndAnswer: " + newQuestionAndAnswer);
        return newQuestionAndAnswer;
    }
    //----------------------------- UPDATE -----------------------------
    @PutMapping("/byId")
    public QuestionAndAnswer updateQuestionAndAnswer(@RequestBody QuestionAndAnswer questionAndAnswer) {
        QuestionAndAnswer updatedQuestionAndAnswer = questionAndAnswerService.updateQuestionAndAnswer(questionAndAnswer);
        if (updatedQuestionAndAnswer == null){
            System.out.println("QuestionAndAnswer is empty");
            return null;
        }
        System.out.println("Service updateQuestion: " + updatedQuestionAndAnswer);
        return updatedQuestionAndAnswer;
    }
    //----------------------------- GET -----------------------------
    @GetMapping("/byId")
    public QuestionAndAnswer getQuestionAndAnswerById(@RequestParam("id") String id) {
        QuestionAndAnswer found = questionAndAnswerService.getQuestionAndAnswerById(id);
        if (found == null) {
            System.out.println("QuestionAndAnswer is not found");
            return null;
        }
        System.out.println("Service getQuestion: " + found);
        return found;
    }
    @GetMapping("/all")
    public Iterable<QuestionAndAnswer> getAllQuestionsAndAnswers(){
        Iterable<QuestionAndAnswer> questionsAndAnswers =  questionAndAnswerService.getAllQuestionsAndAnswers();
        System.out.println("Service getAllQuestions: " + questionsAndAnswers);
        return questionsAndAnswers;
    }
}