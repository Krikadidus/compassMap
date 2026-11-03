package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoadMap {


    @Id
    private String id;
    private String name;
    private String description;
    @ElementCollection
    Map<String,String> stepsItemsSummary;
    private int steps;
    private boolean completed;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "RoadMapAndCustomerProfile",
            joinColumns = @JoinColumn(name = "Roadmap_id"),
            inverseJoinColumns = @JoinColumn(name = "CustomerProfile_id"))
    private List<CustomerProfile> customerProfiles = new ArrayList<>();


    public void addCustomerProfile(CustomerProfile profile) {
        this.customerProfiles.add(profile);
        profile.getRoadMaps().add(this);
    }

    public RoadMap(String newId, String name, String description, Map <String,String> newMap, int steps, boolean completed) {
        this.id = newId;
        this.name = name;
        this.description = description;
        this.stepsItemsSummary = newMap;
        this.steps = steps;
        this.completed = completed;
    }
}
