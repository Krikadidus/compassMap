package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Question {
    private String id;
    private String questionText;
    private String[] answerText;
    private Dimension dimension;
    private int order;
    private double weight;
    private AnswerType expectedType;



}
