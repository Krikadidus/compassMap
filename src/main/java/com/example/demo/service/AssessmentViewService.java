package com.example.demo.service;

import com.example.demo.model.AssessmentView;
import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.repository.AssessmentViewRepository;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.QuestionAndAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class AssessmentViewService {

    @Autowired
    private AssessmentViewRepository assessmentViewRepository;
    private CustomerRepository customerRepository;
    private QuestionAndAnswerRepository questionAndAnswerRepository;
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
        if (incoming.getCustomer()!=null) {
            if (!customerRepository.existsById(incoming.getCustomer().getId())) {
                customerRepository.save(incoming.getCustomer());
            }
            existing.setCustomer(incoming.getCustomer());
        }
        if (incoming.getTimestep()!=null) {
            existing.setTimestep(incoming.getTimestep());
            if(incoming.getTimestep()==null){
                existing.setTimestep(Instant.now());
            }
        }
        if (incoming.getQuestionsAndAnswers()!=null) {
            if (!questionAndAnswerRepository.findAll().equals(incoming.getQuestionsAndAnswers())) {
                System.out.println(incoming.getQuestionsAndAnswers() + "don´t have in repository, so need to change it in QuestionAndAnswer firstly");
                return null;
            }
            existing.setQuestionsAndAnswers(incoming.getQuestionsAndAnswers());
        }
        if (incoming.getProfile()!=null) {
            String id = incoming.getProfile().getId();
            if (!customerProfileRepository.findById(id).isPresent()) {
                System.out.println(incoming.getProfile() + "don´t have in repository, so need to change it in CustomerProfile firstly");
                return null;
            }
        }
    return assessmentViewRepository.save(existing);
    }
}