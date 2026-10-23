package com.example.demo.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Answer {
    @Enumerated(EnumType.STRING)
    private AnswerType expectedType;
    private Object value;

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
    public String toString() {
        return value == null ? "" : value.toString();
    }

}
