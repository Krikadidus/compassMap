package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "id",
        "codeProfile",
        "name",
        "description",
        "goal",
        "answers",
        "assessmentViewInProfile",
        "roadMaps",
})
public class CustomerProfile {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private CodeProfile codeProfile;
    private String name;
    private String description;
    private String goal;
    @ElementCollection
    private Map<Dimension, Boolean> answers;
    @OneToOne
    @JoinColumn (name = "Assessment_FK")
    private AssessmentView assessmentViewInProfile;
    @ManyToMany (mappedBy = "customerProfiles")
    private List<RoadMap> roadMaps = new ArrayList<>();

    public CustomerProfile(CodeProfile codeProfile, String name, String description, String goal, Boolean[] booleansAnswer) {
        this.id = UUID.randomUUID().toString();
        this.codeProfile = codeProfile;
        this.name = name;
        this.description = description;
        this.goal = goal;
        this.answers = new EnumMap<>(Dimension.class);
        for (int   j = 0; j < 4; j++) {
            answers.put(Dimension.values()[j], booleansAnswer[j]);
        }


    }
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerProfile customerProfile = (CustomerProfile) o;
        return this.id.equals(customerProfile.getId()) &&
                this.codeProfile == customerProfile.getCodeProfile() &&
                this.name.equals(customerProfile.getName()) &&
                this.description.equals(customerProfile.getDescription()) &&
                this.goal.equals(customerProfile.getGoal()) &&
                this.answers.equals(customerProfile.getAnswers());
    }
    public String toString(){
        return id==null? "" : "Profile: " +id + name;
    }

}

