package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public Answer(AnswerType expectedType, Object value) {
        this.id = UUID.randomUUID().toString();
        this.expectedType = expectedType;
        switch (expectedType) {
            case BOOLEAN:
                this.answerValue = String.valueOf((Boolean) value);
                break;
            case INTEGER:
                this.answerValue = String.valueOf((Integer) value);
                break;
            case DOUBLE:
                this.answerValue = String.valueOf((Double) value);
                break;
            case TEXT:
                this.answerValue = (String) value;
                break;
            default:
                this.answerValue = null;
        }
    }
    public String toString() {
        return answerValue == null ? "" : answerValue;
    }

}
