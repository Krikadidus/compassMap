package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.model.AnswerType;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionAndAnswerRepository;

import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class QuestionAndAnswerService {
    @Autowired
    private QuestionAndAnswerRepository questionAndAnswerRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    //----------------------------- CREATE -----------------------------
    public QuestionAndAnswer createQuestionAndAnswer1(Question question, Answer answer) {
        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer(question, answer);
        // call repository to use SAVE operation to save data to h2 db
        QuestionAndAnswer createdQuestionAndAnswer = questionAndAnswerRepository.save(questionAndAnswer);
        System.out.println("Service created question and answer: " +  createdQuestionAndAnswer);
        return createdQuestionAndAnswer;
    }
    public QuestionAndAnswer createQuestionAndAnswer2(QuestionAndAnswer questionAndAnswer) {
        // call repository to use SAVE operation to save data to h2 db
        QuestionAndAnswer createdQuestionAndAnswer = questionAndAnswerRepository.save(questionAndAnswer);
        System.out.println("Service created question and answer: " +  createdQuestionAndAnswer);
        return createdQuestionAndAnswer;
    }
    //----------------------------- GET -----------------------------
    public Iterable<QuestionAndAnswer> getAllQuestionsAndAnswers() {
        return questionAndAnswerRepository.findAll();
    }
    public QuestionAndAnswer getQuestionAndAnswerById(String id) {
        Optional<QuestionAndAnswer> found= questionAndAnswerRepository.findById(id);
        return found.orElse(null);
    }


    //----------------------------- UPDATE -----------------------------
    public QuestionAndAnswer updateQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) {
        if (questionAndAnswer== null) {
            System.out.println("QuestionAndAnswer is empty");
            return null;
        }

        Answer answer = questionAndAnswer.getAnswer();
        Question question = questionAndAnswer.getQuestion();
        AnswerType  answerType = questionAndAnswer.getAnswerType();

        if(question == null){
            System.out.println("Question inside the " +questionAndAnswer + " is empty.");
            return null;
        }
        if(answer == null){
                System.out.println("Answer inside the " + questionAndAnswer + " is empty.");
        }
        if (answerType == null) {
            System.out.println("AnswerType inside the " + questionAndAnswer + " is empty.");
        }

        if (!questionRepository.existsById(question.getId()) && !answerRepository.existsById(answer.getId())) {
            System.out.println("Question and answer not found. Need to create a new question and answer firstly.");
            return null;
        };
        return questionAndAnswerRepository.save(questionAndAnswer);
    }
}


