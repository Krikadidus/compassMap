package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Answer {
    private AnswerType expectedType;
    private Object value;

    public Answer() {
    }
    public Answer(AnswerType expectedType, Object value) {
        this.expectedType = expectedType;
        switch (expectedType) {
            case BOOLEAN:
                this.value = (Boolean) value;
                break;
            case INTEGER:
                this.value = (Integer) value;
                break;
            case DOUBLE:
                this.value = (Double) value;
                break;
            case TEXT:
                this.value = (String) value;
                break;
            default:
                this.value = null;
        }
    }

}
