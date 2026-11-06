package com.example.demo.service;

import com.example.demo.model.AssessmentView;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerProfile;
import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    //------------------ CREATE ----------------------
    public AssessmentView createAssessmentView(AssessmentView assessmentView) {

        // call repository to use SAVE operation to save data to h2 db
        assessmentView.setId(UUID.randomUUID().toString());
        if (assessmentView.getTimestep() == null) {
            assessmentView.setTimestep(Instant.now());
        }

        // customer and profile are referenced by id, not created here
        if (assessmentView.getCustomer() != null && assessmentView.getCustomer().getId() != null) {
            assessmentView.setCustomer(customerRepository.findById(assessmentView.getCustomer().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + assessmentView.getCustomer().getId())));
        }
        if (assessmentView.getCustomerProfile() != null && assessmentView.getCustomerProfile().getId() != null) {
            assessmentView.setCustomerProfile(customerProfileRepository.findById(assessmentView.getCustomerProfile().getId())
                    .orElseThrow(() -> new IllegalArgumentException("CustomerProfile not found: " + assessmentView.getCustomerProfile().getId())));
        }

        // rebuild the list with the helper so both sides point to each other
        List<QuestionAndAnswer> incoming = assessmentView.getQuestionsAndAnswers() == null
                ? new ArrayList<>()
                : new ArrayList<>(assessmentView.getQuestionsAndAnswers());

        assessmentView.setQuestionsAndAnswers(new ArrayList<>());

        for (QuestionAndAnswer questionAndAnswer : incoming) {
            questionAndAnswer.setId(UUID.randomUUID().toString());
            if (questionAndAnswer.getQuestion() == null || questionAndAnswer.getQuestion().getId() == null) {
                throw new IllegalArgumentException("QuestionAndAnswer requires an existing question id");
            }
            String questionId = questionAndAnswer.getQuestion().getId();
            questionAndAnswer.setQuestion(questionRepository.findById(questionId)
                    .orElseThrow(() -> new IllegalArgumentException("Question not found: " + questionId)));
            if (questionAndAnswer.getAnswer() != null && questionAndAnswer.getAnswer().getId() == null) {
                questionAndAnswer.getAnswer().setId(UUID.randomUUID().toString());
            }
            if (questionAndAnswer.getAnswer() == null || questionAndAnswer.getAnswer().getId() == null) {
                throw new IllegalArgumentException("QuestionAndAnswer requires an existing answer id");
            }
            String answerId = questionAndAnswer.getAnswer().getId();
            questionAndAnswer.setAnswer(answerRepository.findById(questionId)
                    .orElseThrow(() -> new IllegalArgumentException("Answer not found: " + answerId)));
            assessmentView.addQuestionAndAnswer(questionAndAnswer);
        }

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
        List<QuestionAndAnswer> qAS = incoming.getQuestionsAndAnswers();
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