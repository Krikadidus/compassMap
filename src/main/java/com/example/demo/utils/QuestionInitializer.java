package com.example.demo.utils;
import com.example.demo.model.AnswerType;
import com.example.demo.model.Dimension;
import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Component;


@Component
public class QuestionInitializer {

    private final QuestionRepository questionRepository;

    public QuestionInitializer(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
    }


    public void initialize() {
        if (questionRepository.count() == 0) {
            questionRepository.save(new Question(
                    "q001",
                    "Do you know how to program?",
                    new String[]{"True", "False"},
                    "true",
                    Dimension.KWOWS_CODE,
                    1,
                    1,
                    AnswerType.BOOLEAN
            ));
            questionRepository.save(new Question(
                    "q002",
                    "Do you want to learn programming?",
                    new String[]{"True", "False"},
                    "true",
                    Dimension.WANTS_TO_LEARN,
                    2,
                    1,
                    AnswerType.BOOLEAN
            ));
            questionRepository.save(new Question(
                    "q003",
                    "Do you know machine learning?",
                    new String[]{"True", "False"},
                    "true",
                    Dimension.KNOWS_ML,
                    3,
                    1,
                    AnswerType.BOOLEAN
            ));
            questionRepository.save(new Question(
                    "q004",
                    "Do you want to learn machine learning??",
                    new String[]{"True", "False"},
                    "true",
                    Dimension.WANTS_TO_LEARN_ML,
                    4,
                    1,
                    AnswerType.BOOLEAN
            ));
            questionRepository.save(new Question(
                    "q005",
                    "Do you know how to use git??",
                    new String[]{"True", "False"},
                    "true",
                    Dimension.KNOWS_GIT,
                    5,
                    0.8,
                    AnswerType.BOOLEAN
            ));
        }
    }
}