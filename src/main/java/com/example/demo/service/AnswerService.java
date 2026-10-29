package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    //------------------ CREATE ----------------------
    public Answer createAnswer(Answer answer) {

        // call repository to use SAVE operation to save data to h2 db
        Answer createdAnswer = answerRepository.save(answer);
        System.out.println("Service created question: " + createdAnswer);
        return createdAnswer;
    }
}
