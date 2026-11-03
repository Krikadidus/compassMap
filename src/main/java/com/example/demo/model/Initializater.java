package com.example.demo.model;

import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.RoadMapRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializater implements CommandLineRunner {
    private final CustomerProfileInitializer customerProfileInitializer;
    private final RoadMapInitializer roadMapInitializer;
    private final RelationsProfileAndRoadmapInitializer relationsProfileAndRoadmapInitializer;
    private final RoadMapRepository roadMapRepository;
    private final CustomerProfileRepository customerProfileRepository;

    public Initializater(CustomerProfileInitializer customerProfileInitializer,RelationsProfileAndRoadmapInitializer relationsProfileAndRoadmapInitializer, RoadMapInitializer roadMapInitializer, RoadMapRepository roadMapRepository, CustomerProfileRepository customerProfileRepository) {
        this.customerProfileInitializer = customerProfileInitializer;
        this.roadMapInitializer = roadMapInitializer;
        this.roadMapRepository = roadMapRepository;
        this.customerProfileRepository = customerProfileRepository;
        this.relationsProfileAndRoadmapInitializer = relationsProfileAndRoadmapInitializer;
    }

    @Override
    public void run(String... args) {
        customerProfileInitializer.initialize();
        roadMapInitializer.initialize();
        relationsProfileAndRoadmapInitializer.initializeRelations(roadMapRepository, customerProfileRepository);

    }
}
