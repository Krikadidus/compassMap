package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AssessmentView {
    private String id;
    private Customer customer;
    private Instant timestap;
    private ArrayList<QuestionAndAnswer> questions;
    private CustomerProfile profile;
}
