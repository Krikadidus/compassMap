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
    private String value;
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<QuestionAndAnswer> listQuestionAndAnswer = new ArrayList<>();

    public Answer(AnswerType expectedType, Object value) {
        this.id = UUID.randomUUID().toString();
        this.expectedType = expectedType;
        switch (expectedType) {
            case BOOLEAN:
                this.value = String.valueOf((Boolean) value);
                break;
            case INTEGER:
                this.value = String.valueOf((Integer) value);
                break;
            case DOUBLE:
                this.value = String.valueOf((Double) value);
                break;
            case TEXT:
                this.value = (String) value;
                break;
            default:
                this.value = null;
        }
    }
    public String toString() {
        return value == null ? "" : value;
    }

}
