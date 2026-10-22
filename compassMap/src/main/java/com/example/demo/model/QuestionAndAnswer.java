package com.example.demo.model;

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
    private Object answer;
    private AnswerType answerType;
    private Double scoreContribution;

    public void Survey(Scanner scan){
        ArrayList<QuestionAndAnswer> listQuestionAndAnswer = new ArrayList<>();
        ArrayList<Question> questions = SurveyInitializer.createQuestions();

        for(Question question :questions) {
            double score= 0;
            answerType =question.getExpectedType();
            System.out.println(question.getQuestionText());
            String userAnswer = scan.nextLine().trim().toLowerCase();
            Answer answer = new Answer(answerType, userAnswer);
            if(userAnswer.equals(question.getCorrectAnswer())) {
                score = question.getWeight();
            }
            listQuestionAndAnswer.add(new QuestionAndAnswer(question,answer,answerType,score));
        }
    }
}