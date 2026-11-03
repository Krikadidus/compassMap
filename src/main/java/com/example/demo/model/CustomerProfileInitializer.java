package com.example.demo.model;

import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CustomerProfileInitializer {

    private final CustomerProfileRepository customerProfileRepository;

    public CustomerProfileInitializer(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    public void initialize() {
        if (customerProfileRepository.count() == 0) {
            customerProfileRepository.save(new CustomerProfile(
                    "P01",
                    CodeProfile.AI_ML_EXPERT,
                    "Full-stack + AI expert",
                    "Already proficient in both fields and wants to deepen their knowledge of both",
                    "Full-stack + AI expert",
                    new Boolean[]{true, true, true, true, true}
            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P02",
                    CodeProfile.SENIOR_ML_DEVELOPER,
                    "Senior developer who already knows ML",
                    "Wants to improve their programming skills, without learning more ML",
                    "Senior developer who already knows ML",
                    new Boolean[]{true, true, true, false}
            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P03",
                    CodeProfile.ML_LEARNER,
                    "Programmer looking to get into ML",
                    "Strong coding skills and wants to learn Machine Learning in depth",
                    "Programmer looking to get into ML",
                    new Boolean[]{true, true, false, true}
            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P04",
                    CodeProfile.DEVELOPER_IMPROVER,
                    "Improve programming skills",
                    "Wants to become a better developer/architect",
                    "Improve programming skills",
                    new Boolean[]{true, true, false, false}
            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P05",
                    CodeProfile.ML_SPECIALIST,
                    "ML engineer who doesn’t want to do more programming",
                    "Already knows programming and ML; wants to deepen their ML knowledge only",
                    "ML engineer who doesn’t want to do more programming",
                    new Boolean[]{true, false, true, true}
            ));//zdesi ostanovilsya
            customerProfileRepository.save(new CustomerProfile(
                    "P06",
                    CodeProfile.AI_TOOL_EXPERT,
                    "Advanced user of AI/ML tools",
                    "Knows programming and ML, and prefers using tools without going deeper",
                    "Advanced user of AI/ML tools",
                    new Boolean[]{true, false, true, false}
            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P07",
                    CodeProfile.PRACTICAL_ML_DEVELOPER,
                    "Programmer who wants to use ML",
                    "Knows programming and wants to learn ML in a practical way",
                    "Programmer who wants to use ML",
                    new Boolean[]{true, false, false, true}
            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P08",
                    CodeProfile.AI_PRODUCTIVITY_USER,
                    "Use AI to create projects",
                    "Knows programming and only wants to boost productivity with AI",
                    "Use AI to create projects",
                    new Boolean[]{true, false, false, false}
            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P09",
                    CodeProfile.DATA_SCIENTIST_PROGRAMMING_LEARNER,
                    "Data scientist who wants to learn programming and ML",
                    "Already knows ML and wants to strengthen their programming fundamentals",
                    "Data scientist who wants to learn programmingand ML",
                    new Boolean[]{false, true, true, true}

            ));
            customerProfileRepository.save(new CustomerProfile(
                    "P10",
                    CodeProfile.DATA_SCIENTIST_DEVELOPER,
                    "Data scientist who wants to learn programming without ML",
                    "Knows ML and wants to become better at programming",
                    "Data scientist who wants to learn programming without ML",
                    new Boolean[]{false, true, true, false}
            ));
            ;
            customerProfileRepository.save(new CustomerProfile(
                    "P11",
                    CodeProfile.AI_ML_BEGINNER,
                    "Starting from scratch in everything",
                    "Knows neither programming nor ML and wants to learn both",
                    "Starting from scratch in everything",
                    new Boolean[]{false, true, false, true}
            ));
            ;
            customerProfileRepository.save(new CustomerProfile(
                    "P12",
                    CodeProfile.PROGRAMMING_BEGINNER,
                    "Starting from scratch in programming",
                    "Wants to learn programming in depth",
                    "Starting from scratch in programming",
                    new Boolean[]{false, true, false, false}
            ));
            ;
            customerProfileRepository.save(new CustomerProfile(
                    "P13",
                    CodeProfile.ML_KNOWLEDGE_SEEKER,
                    "Improve ML skills only",
                    "Doesn’t want to program; already knows ML and wants to go deeper",
                    "Improve ML skills only",
                    new Boolean[]{false, false, true, true}
            ));
            ;
            customerProfileRepository.save(new CustomerProfile(
                    "P14",
                    CodeProfile.BASIC_ML_USER,
                    "ML user who doesn’t want to go deeper",
                    "Knows a little ML and doesn’t want to program or go deeper",
                    "ML user who doesn’t want to go deeper",
                    new Boolean[]{false, false, true, false}
            ));
            ;
            customerProfileRepository.save(new CustomerProfile(
                    "P15",
                    CodeProfile.AI_ML_INTRODUCTORY_LEARNER,
                    "Introductory AI/ML course",
                    "Just wants to understand the terminology used by AI specialists",
                    "Introductory AI/ML course",
                    new Boolean[]{false, false, false, true}
            ));
            ;
            customerProfileRepository.save(new CustomerProfile(
                    "P16",
                    CodeProfile.GENERAL_LEARNER,
                    "General introductory course",
                    "General knowledge or understanding what others do",
                    "General introductory course",
                    new Boolean[]{false, false, false, false}
            ));
        }
    }
}
