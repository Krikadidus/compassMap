package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@JsonPropertyOrder({
        "id",
        "name",
        "questionText",
        "answerText",
        "correctAnswer",
        "dimension",
        "questionOrder",
        "weight",
        "expectedType"
})
public class Question {
    @Id
    private String id;
    private String name;
    private String questionText;
    private String[] answerText;
    private String correctAnswer;
    @Enumerated(EnumType.STRING)
    private Dimension dimension;
    private int questionOrder;
    private double weight;
    @Enumerated(EnumType.STRING)
    private AnswerType expectedType;

    @OneToMany (mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionAndAnswer> listQuestionAndAnswer = new ArrayList<>();

    public Question(String qName, String text, String[] strings, String qCorrect, Dimension qDimension, int qOrder, double qWeight, AnswerType qAnswerType) {
        this.id = UUID.randomUUID().toString();
        this.name = qName;
        this.questionText = text;
        this.answerText = strings;
        this.correctAnswer = qCorrect;
        this.dimension = qDimension;
        this.questionOrder = qOrder;
        this.weight = qWeight;
        this.expectedType = qAnswerType;

    }

    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', questionText='%s', answerText='%s', correctAnswer='%s', dimension='%s',questionOrder='%s',weight='%s',expectedType='%s']",
                id, name, questionText, Arrays.toString(answerText), correctAnswer, dimension, questionOrder, weight, expectedType);
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        if(this.id.equals(question.getId()) &&
                this.name.equals(question.getQuestionText())&&
                this.questionText.equals(question.getQuestionText())&&
                this.answerText.equals(question.getAnswerText())&&
                this.dimension == question.getDimension() &&
                this.weight == question.getWeight()&&
                this.expectedType == question.getExpectedType()){
            return true;
        }
        return false;
    }
}
