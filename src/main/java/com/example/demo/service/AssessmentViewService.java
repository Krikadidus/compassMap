package com.example.demo.service;

import com.example.demo.model.AssessmentView;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerProfile;
import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.repository.AssessmentViewRepository;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.QuestionAndAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class AssessmentViewService {

    @Autowired
    private AssessmentViewRepository assessmentViewRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private QuestionAndAnswerRepository questionAndAnswerRepository;
    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    //------------------ CREATE ----------------------
    public AssessmentView createAssessmentView(AssessmentView assessmentView) {

        // call repository to use SAVE operation to save data to h2 db
        AssessmentView createdAssessmentView = assessmentViewRepository.save(assessmentView);
        System.out.println("Service created assessmentView: " + createdAssessmentView);
        return createdAssessmentView;
    }

    public Iterable<AssessmentView> saveAll(Iterable<AssessmentView> assessmentViews) {
        return assessmentViewRepository.saveAll(assessmentViews);
    }
    //------------------ DELETE ----------------------
    public void deleteAssessmentView (String id){
        assessmentViewRepository.deleteById(id);

    }
    public void deleteAllAssessmentViews() {
        assessmentViewRepository.deleteAll();
    }

    //------------------ GET  ----------------------
    public AssessmentView getAssessmentViewById(String id){

        Optional<AssessmentView> foundAssessmentView = assessmentViewRepository.findById(id);

        return foundAssessmentView.orElse(null);
    }

    public Iterable<AssessmentView> getAllAssessmentViews(){
        return assessmentViewRepository.findAll();
    }

    //------------------ COUNT  ----------------------
    public long countAssessmentViews() {
        return assessmentViewRepository.count();
    }

    //------------------ UPDATE  ----------------------
    public AssessmentView updateAssessmentView(AssessmentView incoming) {
        if  (incoming != null) {
            System.out.println("Updating assessmentView is empty");
            return null;
        }
        AssessmentView existing = getAssessmentViewById(incoming.getId());
        if (existing == null) {
            System.out.println("Assessment view with id " + incoming.getId() + " does not exist");
            return null;
        }
        Customer customerForCheck = incoming.getCustomer();
        if (customerForCheck!=null) {
            if (!customerRepository.existsById(customerForCheck.getId())) {
                customerRepository.save(customerForCheck);
            }
            existing.setCustomer(customerForCheck);
        }
        if (incoming.getTimestep()!=null) {
            existing.setTimestep(incoming.getTimestep());
            if(incoming.getTimestep()==null){
                existing.setTimestep(Instant.now());
            }
        }
        ArrayList<QuestionAndAnswer> qAS = incoming.getQuestionsAndAnswers();
        if (qAS != null) {
            if (!questionAndAnswerRepository.findAll().equals(qAS)) {
                System.out.println(qAS + "don´t have in repository, so need to change it in QuestionAndAnswer firstly");
                return null;
            }
            existing.setQuestionsAndAnswers(qAS);
        }

        CustomerProfile cust = incoming.getCustomerProfile();
        if (cust!=null) {
            String id = cust.getId();
            if (!customerProfileRepository.findById(id).isPresent()) {
                System.out.println(cust + "don´t have in repository, so need to change it in CustomerProfile firstly");
                return null;
            }
        }
    return assessmentViewRepository.save(existing);
    }
}