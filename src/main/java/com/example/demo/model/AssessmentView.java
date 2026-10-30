package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AssessmentView {
    @Id
    private String id;
    @OneToOne (mappedBy = "assessmentViewInCustomer", cascade = CascadeType.ALL)
    private Customer customer;
    private Instant timestep;
    @OneToMany(mappedBy = "assessmentViewInQandA")
    private ArrayList<QuestionAndAnswer> questionsAndAnswers;
    @OneToOne(mappedBy = "assessmentViewInProfile")
    private CustomerProfile profile;

}

