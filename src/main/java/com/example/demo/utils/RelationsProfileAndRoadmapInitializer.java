package com.example.demo.utils;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.Dimension;
import com.example.demo.model.RoadMap;
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
        //Create lists for Customer Profiles with answers Code true/false, ML true/false
        List<CustomerProfile> customerProfilesForCodingBasic = new ArrayList<>(),
                customerProfilesForCodingBasicFinal = new ArrayList<>(),
                customerProfilesForCodingAdvance = new ArrayList<>(),
                customerProfilesForCodingAdvanceFinal = new ArrayList<>(),
                customerProfilesForMLBasic = new ArrayList<>(),
                customerProfilesForMLBasicFinal = new ArrayList<>(),
                customerProfilesForMLAdvance = new ArrayList<>(),
                customerProfilesForMLAdvanceFinal = new ArrayList<>();

        //Add profiles inside lists of profiles depends on true/false
    for (CustomerProfile customerProfile : customerProfileRepository.findAll()) {
        categorizeProfiles(
                customerProfile,
                Dimension.WANTS_TO_LEARN,
                Dimension.KWOWS_CODE,
                customerProfilesForCodingAdvance,
                customerProfilesForCodingBasic,
                customerProfilesForCodingAdvanceFinal,
                customerProfilesForCodingBasicFinal
        );

        categorizeProfiles(
                customerProfile,
                Dimension.WANTS_TO_LEARN_ML,
                Dimension.KNOWS_ML,
                customerProfilesForMLAdvance,
                customerProfilesForMLBasic,
                customerProfilesForMLAdvanceFinal,
                customerProfilesForMLBasicFinal
        );
    }
        // Add profiles inside roadmaps
        for (RoadMap roadMap : roadMapRepository.findAll()) {
            if (roadMap.getId().matches ("RM0[1-5]")){
                customerProfilesForCodingAdvance.forEach(roadMap::addCustomerProfile);
            } else if (roadMap.getId().matches ("((RM0[6-9])|RM10)")){
                customerProfilesForCodingBasic.forEach(roadMap::addCustomerProfile);
            } else if (roadMap.getId().matches ("(RM1[1-5])")){
                customerProfilesForMLAdvance.forEach(roadMap::addCustomerProfile);
            } else if (roadMap.getId().matches ("((RM1[6-9])|RM20)")){
                customerProfilesForMLBasic.forEach(roadMap::addCustomerProfile);
            } else if (roadMap.getId().matches ("(RM2[1-5])")) {
                customerProfilesForCodingAdvanceFinal.forEach(roadMap::addCustomerProfile);
            } else if (roadMap.getId().matches ("((RM2[6-9])|(R3[0-1]))")){
                customerProfilesForCodingBasicFinal.forEach(roadMap::addCustomerProfile);
            } else if (roadMap.getId().matches ("(RM3[2-7])")){
                customerProfilesForMLAdvanceFinal.forEach(roadMap::addCustomerProfile);
            } else if (roadMap.getId().matches ("((RM3[8-9])|(RM4[0-3]))")){
                customerProfilesForMLBasicFinal.forEach(roadMap::addCustomerProfile);
            }
            roadMapRepository.saveAll(roadMapRepository.findAll());
        }
    }

    //method for categorize Profiles depend on answers;
    private void categorizeProfiles(
            CustomerProfile profile,
            Dimension wantsToLearn,
            Dimension knows,
            List<CustomerProfile> advance,
            List<CustomerProfile> basic,
            List<CustomerProfile> advanceFinal,
            List<CustomerProfile> basicFinal
    ) {
        boolean wants = profile.getProfilesAnswers().get(wantsToLearn);
        boolean knowsSkill = profile.getProfilesAnswers().get(knows);

        if (wants) {
            (knowsSkill ? advance : basic).add(profile);
        } else {
            (knowsSkill ? advanceFinal : basicFinal).add(profile);
        }
    }
}
