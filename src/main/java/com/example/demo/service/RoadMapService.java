package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.RoadMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoadMapService {

    @Autowired
    private RoadMapRepository roadMapRepository;
    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    //------------------ CREATE ----------------------
    public RoadMap createRoadMap(RoadMap roadMap) {

        // call repository to use SAVE operation to save data to h2 db
        RoadMap createdRoadMap = roadMapRepository.save(roadMap);
        System.out.println("Service created roadMap: " + createdRoadMap);
        return createdRoadMap;
    }

    public Iterable<RoadMap> saveAll(Iterable<RoadMap> roadMaps) {
        return roadMapRepository.saveAll(roadMaps);
    }
    //------------------ DELETE ----------------------
    public void deleteRoadMap (String id){
        roadMapRepository.deleteById(id);

    }
    public void deleteAllRoadMaps() {
        roadMapRepository.deleteAll();
    }

    //------------------ GET  ----------------------
    public RoadMap getRoadMapById(String id){

        Optional<RoadMap> foundRoadMap = roadMapRepository.findById(id);

        return foundRoadMap.orElse(null);
    }

    public Iterable<RoadMap> getAllRoadMaps(){
        return roadMapRepository.findAll();
    }

    //------------------ COUNT  ----------------------
    public long countRoadMaps() {
        return roadMapRepository.count();
    }

    //------------------ UPDATE  ----------------------
    public RoadMap updateRoadMap(RoadMap incoming) {
        if  (incoming != null) {
            System.out.println("Updating roadMap is empty");
            return null;
        }
        RoadMap existing = getRoadMapById(incoming.getId());
        if (existing == null) {
            System.out.println("RoadMap with id " + incoming.getId() + " does not exist");
            return null;
        }

        if (incoming.getName()!=null) {
            existing.setName(incoming.getName());
        }
        if (incoming.getDescription()!=null) {
                existing.setDescription(incoming.getDescription());
        }


        if (incoming.getSteps()!= 0) {
            existing.setSteps(incoming.getSteps());
        }
        if (incoming.isCompleted()) {
            existing.setCompleted(true);
        }

        List<CustomerProfile> cust = incoming.getCustomerProfiles();
        if (cust!=null) {
            if (!customerProfileRepository.findAll().equals(cust)) {
                System.out.println(cust + "don´t have in repository, so need to change it in CustomerProfile firstly");
                return null;
            }
        }
        return roadMapRepository.save(existing);
    }
}
