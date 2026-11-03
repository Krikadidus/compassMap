package com.example.demo.model;

import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.RoadMapRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class RelationsProfileAndRoadmapInitializer {

    public void initializeRelations(RoadMapRepository roadMapRepository, CustomerProfileRepository customerProfileRepository) {
        List<CustomerProfile> customerProfilesForCodingBasic = new ArrayList<>();
        List<CustomerProfile> customerProfilesForCodingAdvance = new ArrayList<>();

        List<CustomerProfile> customerProfilesForMLBasic = new ArrayList<>();
        List<CustomerProfile> customerProfilesForMLAdvance = new ArrayList<>();

        for (CustomerProfile profile : customerProfileRepository.findAll()) {
            if (profile.getProfilesAnswers().get(Dimension.WANTS_TO_LEARN)) {
                if (profile.getProfilesAnswers().get(Dimension.KWOWS_CODE)) {
                    customerProfilesForCodingAdvance.add(profile);
                } else {
                    customerProfilesForCodingBasic.add(profile);
                }
            }
            if (profile.getProfilesAnswers().get(Dimension.WANTS_TO_LEARN_ML)) {
                if (profile.getProfilesAnswers().get(Dimension.KNOWS_ML)) {
                    customerProfilesForMLAdvance.add(profile);
                } else {
                    customerProfilesForMLBasic.add(profile);
                }
            }
        }
        for (RoadMap roadMap : roadMapRepository.findAll()) {
            if (roadMap.getId().matches ("RM0[1-5]")){
                customerProfilesForCodingAdvance.forEach(roadMap::addCustomerProfile);
            }
            if (roadMap.getId().matches ("((RM0[6-9])|RM10)")){
                customerProfilesForCodingBasic.forEach(roadMap::addCustomerProfile);
            }
            if (roadMap.getId().matches ("(RM1[1-5])")){
                customerProfilesForMLAdvance.forEach(roadMap::addCustomerProfile);
            }
            if (roadMap.getId().matches ("((RM1[6-9])|RM20)")){
                customerProfilesForMLBasic.forEach(roadMap::addCustomerProfile);
            }
            roadMapRepository.saveAll(roadMapRepository.findAll());
        }
    }
}
