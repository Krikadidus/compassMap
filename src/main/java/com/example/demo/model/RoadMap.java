package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
    private int steps;
    private boolean completed;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "RoadMapAndCustomerProfile",
            joinColumns = @JoinColumn(name = "Roadmap_id"),
            inverseJoinColumns = @JoinColumn(name = "CustomerProfile_id"))
    private List<CustomerProfile> customerProfiles = new ArrayList<>();

    public RoadMap(String name, String description, int steps, boolean completed) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.completed = completed;
    }
}
