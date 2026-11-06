package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.RoadMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerProfileService {
    @Autowired
    private CustomerProfileRepository customerProfileRepository;
    @Autowired
    private RoadMapRepository roadMapRepository;

    //------------------ CREATE ----------------------
    public CustomerProfile createCustomerProfile(CustomerProfile customerProfile) {
        if(customerProfile == null ){
            System.out.println("Customer profile is null");
        }
        if (customerProfile.getId()==null){
            customerProfile.setId(UUID.randomUUID().toString());
        }
        if (!customerProfile.getRoadMaps().isEmpty()) {
        customerProfile.getRoadMaps()
                .forEach(roadMap ->
                    roadMapRepository.findById(roadMap.getId()).orElseThrow(() ->
                            new IllegalArgumentException("Roadmap not found: " + roadMap.getId())));
        }

        // call repository to use SAVE operation to save data to h2 db
        CustomerProfile createdCustomerProfile = customerProfileRepository.save(customerProfile);
        System.out.println("Service created customerProfile: " +  createdCustomerProfile);
        return createdCustomerProfile;
    }
    public Iterable<CustomerProfile> saveAll(Iterable<CustomerProfile> customerProfiles) {
        return customerProfileRepository.saveAll(customerProfiles);
    }
    //------------------ DELETE ----------------------
    public void deleteCustomerProfile (String id){
        customerProfileRepository.deleteById(id);

    }
    public void deleteAllCustomerProfiles() {
        customerProfileRepository.deleteAll();
    }

    //------------------ GET  ----------------------
    public CustomerProfile getCustomerProfileById(String id){

        Optional<CustomerProfile> foundCustomerProfile = customerProfileRepository.findById(id);

        return foundCustomerProfile.orElse(null);
    }

    public Iterable<CustomerProfile> getAllCustomerProfiles(){
        return customerProfileRepository.findAll();
    }

    //------------------ COUNT  ----------------------
    public long countCustomerProfiles() {
        return customerProfileRepository.count();
    }

    //------------------ UPDATE  ----------------------
      public CustomerProfile updateCustomerProfile(CustomerProfile incoming) {
        CustomerProfile existing = getCustomerProfileById(incoming.getId());
       // merge only non-null fields from incoming (partial update semantics)
        if (incoming.getCodeProfile() != null ) {
            existing.setCodeProfile(incoming.getCodeProfile());
        }
        if (incoming.getName() != null && !incoming.getName().trim().isEmpty()) {
            existing.setName(incoming.getName());
        }
        if (incoming.getDescription() != null) {
            existing.setDescription(incoming.getDescription());
        }
        if (incoming.getGoal() != null) {
            existing.setGoal(incoming.getGoal());
        }
        if (incoming.getProfilesAnswers() != null) {
            existing.setProfilesAnswers(incoming.getProfilesAnswers());
        }
        return customerProfileRepository.save(existing);
    }
}

