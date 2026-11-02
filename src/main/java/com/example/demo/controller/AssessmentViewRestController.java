package com.example.demo.controller;

import com.example.demo.model.AssessmentView;
import com.example.demo.service.AssessmentViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/assesssmentview")
public class AssessmentViewRestController {

        @Autowired
        private AssessmentViewService assessmentViewService;

        //----------------------------- Create -----------------------------
        @PostMapping("/create")
        public AssessmentView createAssessmentView1(@RequestBody AssessmentView assessmentView) {
            AssessmentView newAssessmentView = assessmentViewService.createAssessmentView(assessmentView);
            System.out.println("Service createAssessmentView: " + newAssessmentView);
            return newAssessmentView;
        }
        //----------------------------- UPDATE -----------------------------
        @PutMapping("/byId")
        public AssessmentView updateAssessmentView(@RequestBody AssessmentView assessmentView) {
            AssessmentView updatedAssessmentView = assessmentViewService.updateAssessmentView(assessmentView);
            if (updatedAssessmentView == null){
                System.out.println("AssessmentView is empty");
                return null;
            }
            System.out.println("Service updateAssessmentView: " + updatedAssessmentView);
            return updatedAssessmentView;
        }
        //----------------------------- GET -----------------------------
        @GetMapping("/byId")
        public AssessmentView getAssessmentViewById(@RequestParam("id") String id) {
            AssessmentView found = assessmentViewService.getAssessmentViewById(id);
            if (found == null) {
                System.out.println("AssessmentView is not found");
                return null;
            }
            System.out.println("Service getAssessmentView: " + found);
            return found;
        }
        @GetMapping("/all")
        public Iterable<AssessmentView> getAllAssessmentViews(){
            Iterable<AssessmentView> assessmentViews =  assessmentViewService.getAllAssessmentViews();
            System.out.println("Service getAllAssessmentView: " + assessmentViews);
            return assessmentViews;
        }
}

