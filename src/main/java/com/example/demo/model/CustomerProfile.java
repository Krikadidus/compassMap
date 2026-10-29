package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerProfile {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private CodeProfile codeProfile;
    private String name;
    private String description;
    private String goal;
    private HashMap<Dimension, Boolean> answers;
    @OneToOne
    @JoinColumn (name = "Assesment_FK")
    private AssessmentView assessmentViewInProfile;
    @ManyToMany (mappedBy = "customerProfiles",  cascade = CascadeType.ALL)
    private List<RoadMap> roadMaps = new ArrayList<>();

    public CustomerProfile(CodeProfile codeProfile, String name, String description, String goal, Boolean[] booleanAnswer) {
        this.id = UUID.randomUUID().toString();
        this.codeProfile = codeProfile;
        this.name = name;
        this.description = description;
        this.goal = goal;
        this.answers = new HashMap<>();
        for (int   j = 0; j < booleanAnswer.length; j++) {
            answers.put(Dimension.values()[j], booleanAnswer[j]);
        }


    }
    public String toString(){
        return id==null? "" : "Profile: " +id + name;
    }
}

