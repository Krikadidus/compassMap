package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Answer {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private AnswerType expectedType;
    private String answerValue;
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<QuestionAndAnswer> listQuestionAndAnswer = new ArrayList<>();

    public Answer(String idNew, AnswerType expectedType, Object value) {
        this.id = idNew;
        this.expectedType = expectedType;

        if (value == null) {
            throw new IllegalArgumentException("Answer cannot be null");
        }

        switch (expectedType) {
            case BOOLEAN:
                if (!(value instanceof Boolean)) {
                    throw new IllegalArgumentException("Expected Boolean");
                }
                break;

            case INTEGER:
                if (!(value instanceof Integer)) {
                    throw new IllegalArgumentException("Expected Integer");
                }
                break;

            case DOUBLE:
                if (!(value instanceof Double)) {
                    throw new IllegalArgumentException("Expected Double");
                }
                break;

            case TEXT:
                if (!(value instanceof String)) {
                    throw new IllegalArgumentException("Expected String");
                }
                break;
        }

        this.answerValue = String.valueOf(value);
    }

    public Object getConvertedValue() {
        switch (expectedType) {
            case BOOLEAN:
                return Boolean.valueOf(answerValue);

            case INTEGER:
                return Integer.valueOf(answerValue);

            case DOUBLE:
                return Double.valueOf(answerValue);

            case TEXT:
                return answerValue;

            default:
                throw new IllegalStateException("Unknown answer type");
        }
    }
    public void addQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) {
        this.listQuestionAndAnswer.add(questionAndAnswer);
    }
    public String toString() {
        return answerValue == null ? "" : answerValue;
    }

}
