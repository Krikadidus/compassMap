package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class QuestionAndAnswer {
    @Id
    private String id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "Question_FK")
    private Question question;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "Answer_FK")
    private Answer answer;

    private AnswerType answerType;
    private Double scoreContribution;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "Assesment_FK")
    private AssessmentView assessmentViewInQandA;


    public QuestionAndAnswer(Question newQuestion, Answer newAnswer) {
        this.id = UUID.randomUUID().toString();

        this.question = newQuestion;
        this.answer = newAnswer;
        this.answerType = question.getExpectedType();
        this.scoreContribution = 0.0;
    }
    /*
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
    }*/
}