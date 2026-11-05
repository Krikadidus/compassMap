package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AssessmentView {
    @Id
    private String id;
    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name ="Customer_FK")
    private Customer customer;
    private Instant timestep;
    @OneToMany(mappedBy = "assessmentViewInQandA")
    private List<QuestionAndAnswer> questionsAndAnswers = new ArrayList<>();
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name = "profileID")
    private CustomerProfile customerProfile;


public void addQuestionAndAnswer(QuestionAndAnswer questionAndAnswer){
    questionsAndAnswers.add(questionAndAnswer);
}
}
