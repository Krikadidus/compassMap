package com.example.demo.model;

import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CustomerProfileInitializer implements CommandLineRunner {

    private final CustomerProfileRepository customerProfileRepository;

    public CustomerProfileInitializer(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    @Override
    public void run(String... args) {
        if (customerProfileRepository.count() == 0){
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Full-stack + AI expert",
                    "Already proficient in both fields and wants to deepen their knowledge of both",
                    "Full-stack + AI expert",
                    new Boolean[]{true, true, true,true,true}
            ));
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Senior developer who already knows ML",
                    "Wants to improve their programming skills, without learning more ML",
                    "Senior developer who already knows ML",
                    new Boolean[]{true, true, true, false}
            ));
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Programmer looking to get into ML",
                    "Strong coding skills and wants to learn Machine Learning in depth",
                    "Programmer looking to get into ML",
                    new Boolean[]{true, true, false, true}
            ));
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Improve programming skills",
                    "Wants to become a better developer/architect",
                    "Improve programming skills",
                    new Boolean[]{true, true, false, false}
            ));
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "ML engineer who doesn’t want to do more programming",
                    "Already knows programming and ML; wants to deepen their ML knowledge only",
                    "ML engineer who doesn’t want to do more programming",
                    new Boolean[]{true, false, true, true}
            ));//zdesi ostanovilsya
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Programmer looking to get into ML",
                    "Strong coding skills and wants to learn Machine Learning in depth",
                    "Programmer looking to get into ML",
                    new Boolean[]{true, true, false, true}
            ));
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Programmer looking to get into ML",
                    "Strong coding skills and wants to learn Machine Learning in depth",
                    "Programmer looking to get into ML",
                    new Boolean[]{true, true, false, true}
            ));
            customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Programmer looking to get into ML",
                    "Strong coding skills and wants to learn Machine Learning in depth",
                    "Programmer looking to get into ML",
                    new Boolean[]{true, true, false, true}
            ));customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Programmer looking to get into ML",
                    "Strong coding skills and wants to learn Machine Learning in depth",
                    "Programmer looking to get into ML",
                    new Boolean[]{true, true, false, true}
            ));customerProfileRepository.save( new CustomerProfile(
                    CodeProfile.ARCHITECT,
                    "Programmer looking to get into ML",
                    "Strong coding skills and wants to learn Machine Learning in depth",
                    "Programmer looking to get into ML",
                    new Boolean[]{true, true, false, true}
            ));



        }
}
