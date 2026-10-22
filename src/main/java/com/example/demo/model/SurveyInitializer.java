package com.example.demo.model;

import java.util.ArrayList;

public class SurveyInitializer {
   public static ArrayList <Question> createQuestions(){
       ArrayList<Question> questions = new ArrayList<>();

       questions.add (new Question(
               "q001",
               "Do you know how to program?",
               new String[]{"True", "False"},
               Dimension.KWOWS_CODE,
               1,
               1,
               AnswerType.BOOLEAN
       ));
       questions.add (new Question(
               "q002",
               "Do you want to learn programming?",
               new String[]{"True", "False"},
               Dimension.WANTS_TO_LEARN,
               2,
               1,
               AnswerType.BOOLEAN
       ));
       questions.add (new Question(
               "q003",
               "Do you know machine learning?",
               new String[]{"True", "False"},
               Dimension.KWOWS_CODE,
               3,
               1,
               AnswerType.BOOLEAN
       ));
       questions.add (new Question(
               "q004",
               "Do you want to learn machine learning??",
               new String[]{"True", "False"},
               Dimension.WANTS_TO_LEARN,
               4,
               1,
               AnswerType.BOOLEAN
       ));
       return questions;
   }
}
