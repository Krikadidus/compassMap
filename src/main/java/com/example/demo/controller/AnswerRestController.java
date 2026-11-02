package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/answers")
public class AnswerRestController {

    @Autowired
    private AnswerService answerService;

    //----------------------------- CREATE -----------------------------
    @PostMapping("/create")
    public Answer createAnswer(@RequestBody Answer answer) {
        Answer newAnswer = answerService.createAnswer(answer);
        System.out.println("Service createAnswer: " + newAnswer);
        return newAnswer;
    }
    @PostMapping("/createAll")
    public Iterable<Answer> createAllAnswer(@RequestBody Iterable<Answer> answers) {
        Iterable<Answer> newAnswers = answerService.saveAll(answers);
        System.out.println("Service createAllAnswers: " + answers);
        return newAnswers;
    }

    //----------------------------- UPDATE -----------------------------
    @PutMapping("/byId")
    public Answer updateAnswer(@RequestBody Answer answer) {
        if (answerService.getAnswerById(answer.getId()) == null) {
            return null;
        }
        Answer updatedAnswer = answerService.updateAnswer(answer);
        System.out.println("Service updateAnswer: " + updatedAnswer);
        return updatedAnswer;
    }
    //----------------------------- GET -----------------------------
    @GetMapping("/byId")
    public Answer getAnswerById(@RequestParam("id") String id) {
        Answer foundAnswer = answerService.getAnswerById (id);
        if (foundAnswer == null) {
            return null;
        }
        System.out.println("Service getAnswer: " + foundAnswer);
        return foundAnswer;
    }
    @GetMapping("/all")
    public Iterable<Answer> getAllAnswers(){
        Iterable<Answer> answers =  answerService.getAllAnswers();
        System.out.println("Service getAllAnswers: " + answers);
        return answers;
    }
    @GetMapping("/count")
    public long getCountOfAnswers(){
        return answerService.countAnswers();
    }
    //------------------ DELETE ----------------------
    @DeleteMapping("/byId")
    public void deleteById(@RequestParam("id") String id){
        Answer foundAnswer = answerService.getAnswerById (id);
        if (foundAnswer == null) {
            System.out.println( "Service getAnswerById: " + id + " not found");
        }
        answerService.deleteAnswer(id);
        System.out.println("Service deleteAnswer: " + foundAnswer);
    }
    @DeleteMapping("/all")
    public void deleteAllAnswers() {
        answerService.deleteAllAnswers();
    }

}
