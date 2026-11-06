package com.example.demo.service;


import com.example.demo.model.AnswerType;
import com.example.demo.model.Dimension;
import com.example.demo.model.Question;
import com.example.demo.repository.QuestionAndAnswerRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionAndAnswerRepository questionAndAnswerRepository;

//------------------ CREATE ----------------------
    public Question createQuestion(Question question) {
        if (question == null) {
            System.out.println("question not created,because it is null");
            return null;
        }
        if (question.getId() == null) {
            question.setId(UUID.randomUUID().toString());
        }
        if(!question.getListQuestionAndAnswer().isEmpty()){
                question.getListQuestionAndAnswer().forEach(questionAndAnswer ->
                questionAndAnswerRepository.findById(questionAndAnswer.getId()).orElseThrow(() ->
                        new IllegalArgumentException("QuestionAndAnswer not found: " + questionAndAnswer.getId())));
        }

        // call repository to use SAVE operation to save data to h2 db
        Question createdQuestion = questionRepository.save(question);
        System.out.println("Service created question: " +  createdQuestion);
        return createdQuestion;
    }
    public Iterable<Question> saveAll(Iterable<Question> questions) {
        return questionRepository.saveAll(questions);
    }
//------------------ DELETE ----------------------
    public void deleteQuestion (String id){
        questionRepository.deleteById(id);

    }
    public void deleteAllQuestions() {
        questionRepository.deleteAll();
    }

//------------------ GET  ----------------------
    public Question getQuestionById(String id){

        Optional<Question> foundQuestion = questionRepository.findById(id);

        return foundQuestion.orElse(null);
    }

    public Iterable<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

//------------------ COUNT  ----------------------
    public long countQuestions() {
        return questionRepository.count();
    }

 //------------------ UPDATE  ----------------------
    public Question updateQuestion(Question incoming) {
        Question existing = getQuestionById(incoming.getId());
        // merge only non-null fields from incoming (partial update semantics)
        if (incoming.getQuestionText() != null && !incoming.getQuestionText().trim().isEmpty()) {
            existing.setQuestionText(incoming.getQuestionText());
        }
        if (incoming.getName() != null && !incoming.getName().trim().isEmpty()) {
            existing.setName(incoming.getName());
        }
       if (incoming.getAnswerText() != null) {
            existing.setAnswerText(incoming.getAnswerText());
        }
        if (incoming.getCorrectAnswer() != null && !incoming.getCorrectAnswer().trim().isEmpty()) {
            existing.setCorrectAnswer(incoming.getCorrectAnswer());
        }
        if (incoming.getDimension() != null && List.of(Dimension.values()).contains(incoming.getDimension())) {
            existing.setDimension(incoming.getDimension());
        }
        if (incoming.getQuestionOrder() != 0 ) {
            existing.setQuestionOrder(incoming.getQuestionOrder());
        }
        if (incoming.getWeight() != 0) {
            existing.setWeight(incoming.getWeight());
        }
        if (incoming.getExpectedType() != null && List.of(AnswerType.values()).contains(incoming.getExpectedType())) {
            existing.setExpectedType(incoming.getExpectedType());
        }
        return questionRepository.save(existing);
    }
}
