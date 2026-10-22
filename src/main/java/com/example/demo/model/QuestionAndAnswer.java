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
            String ans = scan.nextLine().trim().toLowerCase();
            Answer answer = new Answer(answerType, ans);
            if(answer.getValue()) {
                    Object userAnswer = true;
                    score = 1*question.getWeight();
                } else{
                    Object userAnswer = false;
                    score = 0*question.getWeight();
                }

            }
            listQuestionAndAnswer.add(new QuestionAndAnswer(question,userAnswer,answerType,score));
        }
    }
}