package com.example.demo.model;

import com.example.demo.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class QuestionAndAnswer {
    private Question question;
    private Answer answer;
    private AnswerType answerType;
    private Double scoreContribution;

    public ArrayList<QuestionAndAnswer> Survey(Scanner scan, QuestionRepository questionRepository) {
        ArrayList<QuestionAndAnswer> listQuestionAndAnswer = new ArrayList<>();
        Iterable<Question> questions = questionRepository.findAll();;

        for(Question question :questions) {
            double score= 0;
            answerType =question.getExpectedType();
            System.out.println(question.getQuestionText());
            String userAnswer = scan.nextLine().trim().toLowerCase();
            Answer answerObj = new Answer(answerType, userAnswer);
            if(userAnswer.equals(question.getCorrectAnswer())) {
                score = question.getWeight();
            }
            listQuestionAndAnswer.add(new QuestionAndAnswer(question,answerObj,answerType,score));
        }
        return listQuestionAndAnswer;
    }
}