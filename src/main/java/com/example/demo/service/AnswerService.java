package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.model.AnswerType;

import com.example.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    //------------------ CREATE ----------------------
    public Answer createAnswer(Answer answer) {

        // call repository to use SAVE operation to save data to h2 db
        Answer createdAnswer = answerRepository.save(answer);
        System.out.println("Service created answer: " + createdAnswer);
        return createdAnswer;
    }
    public Iterable<Answer> saveAll(Iterable<Answer> answers) {
        return answerRepository.saveAll(answers);
    }
    //------------------ DELETE ----------------------
    public void deleteAnswer (String id){
        answerRepository.deleteById(id);

    }
    public void deleteAllAnswers() {
        answerRepository.deleteAll();
    }

    //------------------ GET  ----------------------
    public Answer getAnswerById(String id){

        Optional<Answer> foundAnswer = answerRepository.findById(id);

        return foundAnswer.orElse(null);
    }

    public Iterable<Answer> getAllAnswers(){
        return answerRepository.findAll();
    }

    //------------------ COUNT  ----------------------
    public long countAnswers() {
        return answerRepository.count();
    }

    //------------------ UPDATE  ----------------------
    public Answer updateAnswer(Answer incoming) {
        Answer existing = getAnswerById(incoming.getId());
        if  (existing == null) {
            System.out.println("Answer not found");
            return null;
        }
        if (incoming.getAnswerValue() != null && !incoming.getAnswerValue().trim().isEmpty()) {
            existing.setAnswerValue(incoming.getAnswerValue());
        }
        if (incoming.getExpectedType() != null && List.of(AnswerType.values()).contains(incoming.getExpectedType())) {
            existing.setExpectedType(incoming.getExpectedType());
        }
        return answerRepository.save(existing);
    }
}
