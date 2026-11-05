package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CustomerService;
import com.example.demo.service.QuestionAndAnswerService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	//@Autowired
	//private CustomerRepository customerRepository;
	@Autowired
	private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerProfileRepository customerProfileRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private RoadMapRepository roadMapRepository;
    @Autowired
    private QuestionAndAnswerRepository questionAndAnswerRepository;
    @Autowired
    private QuestionAndAnswerService questionAndAnswerService;
    @Autowired
    private AssessmentViewRepository  assessmentViewRepository;

    /*	@Test
        void contextLoads() {
        }

        @Test
        void findCustomerById (){

            Customer customerFound1 = customerService.getCustomerById("64c7be39-d974-419f-a766-a6063346676b");
            System.out.println("Customer found 1 : " + customerFound1 );

            Customer customerFound2 = customerService.getCustomerById("banana");
            System.out.println("Customer found 2 : " + customerFound2 );


        }

        @Test
        void deleteCustomerById(){

            customerService.deleteCustomer("8b4ca0f7-5de0-4ab2-a431-a849f158cd62");
        }


        @Test
        void javaFakerCreateObjects(){


            Faker faker = new Faker();

            //String name = faker.name().fullName(); // Miss Samanta Schmidt
            //String firstName = faker.name().firstName(); // Emory
            //String lastName = faker.name().lastName(); // Barton

            //String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

            //String titleBook = faker.book().title();

            Customer newCustomer = new Customer();

            for (int i= 0; i < 1000; i++){

                // id?
                newCustomer.setFirstName( faker.name().firstName()  );
                newCustomer.setLastName(  faker.name().lastName());

                customerService.createCustomer(newCustomer);
            }
        }*/
  /*  @Test
    // Create Question and Answer for test
    void createQandA(){
        Answer ans1 = new Answer("answer1ForTest", AnswerType.BOOLEAN,true);
        Answer ans2 = new Answer("answer2ForTest", AnswerType.BOOLEAN,true);
        Answer ans3 = new Answer("answer3ForTest", AnswerType.BOOLEAN,true);
        Answer ans4 = new Answer("answer4ForTest", AnswerType.BOOLEAN,true);

        Question quest1 = new Question(
                "question1ForTest",
                "Do you know how to program?",
                new String[]{"True", "False"},
                "true",
                Dimension.KWOWS_CODE,
                1,
                1,
                AnswerType.BOOLEAN
        );
        Question quest2 = new Question(
                "question2ForTest",
                "Do you want to learn programming?",
                new String[]{"True", "False"},
                "true",
                Dimension.WANTS_TO_LEARN,
                2,
                1,
                AnswerType.BOOLEAN
        );
        Question quest3 = new Question(
                "question3ForTest",
                "Do you know machine learning?",
                new String[]{"True", "False"},
                "true",
                Dimension.KNOWS_ML,
                3,
                1,
                AnswerType.BOOLEAN
        );
        Question quest4 = new Question(
                "question4ForTest",
                "Do you want to learn machine learning??",
                new String[]{"True", "False"},
                "true",
                Dimension.WANTS_TO_LEARN_ML,
                4,
                1,
                AnswerType.BOOLEAN);

        QuestionAndAnswer qandA1 = new  QuestionAndAnswer("QandA1ForTest", quest1, ans1);
        QuestionAndAnswer qandA2 = new  QuestionAndAnswer("QandA2ForTest", quest2, ans2);
        QuestionAndAnswer qandA3 = new  QuestionAndAnswer("QandA3ForTest", quest3, ans3);
        QuestionAndAnswer qandA4 = new  QuestionAndAnswer("QandA4ForTest", quest4, ans4);

        ans1.addQuestionAndAnswer(qandA1);
        ans2.addQuestionAndAnswer(qandA2);
        ans3.addQuestionAndAnswer(qandA3);
        ans4.addQuestionAndAnswer(qandA4);

        quest1.addQuestionAndAnswer(qandA1);
        quest2.addQuestionAndAnswer(qandA2);
        quest3.addQuestionAndAnswer(qandA3);
        quest4.addQuestionAndAnswer(qandA4);

        questionAndAnswerService.createQuestionAndAnswer2(qandA1);
        questionAndAnswerService.createQuestionAndAnswer2(qandA2);
        questionAndAnswerService.createQuestionAndAnswer2(qandA3);
        questionAndAnswerService.createQuestionAndAnswer2(qandA4);
    }
*/
    @Test
        // Create AssessmentVies for test
    void createAssessmentVies(){
        Answer ans1 = new Answer("answer1ForTestAV", AnswerType.BOOLEAN,true);
        Answer ans2 = new Answer("answer2ForTestAV", AnswerType.BOOLEAN,true);
        Question quest1 = new Question(
                "question1ForTestAV",
                "Do you know how to program?",
                new String[]{"True", "False"},
                "true",
                Dimension.KWOWS_CODE,
                1,
                1,
                AnswerType.BOOLEAN
        );
        Question quest2 = new Question(
                "question2ForTestAV",
                "Do you want to learn programming?",
                new String[]{"True", "False"},
                "true",
                Dimension.WANTS_TO_LEARN,
                2,
                1,
                AnswerType.BOOLEAN
        );
        QuestionAndAnswer qandA1 = new  QuestionAndAnswer("QandA1ForTestAV", quest1, ans1);
        QuestionAndAnswer qandA2 = new  QuestionAndAnswer("QandA2ForTestAV", quest2, ans2);
        questionAndAnswerService.createQuestionAndAnswer2(qandA1);
        questionAndAnswerService.createQuestionAndAnswer2(qandA2);

        Customer cust1 =  new Customer("Customer1ForTestAV", "John", "Smith", "123@gmail.com", "65322234", "Barcelona");
        Customer cust2 =  new Customer("Customer2ForTestAV", "Alexa", "Wolf", "Wolf@gmail.com", "5222345", "Barcelona");

        customerRepository.save(cust1);
        customerRepository.save(cust2);

        RoadMap roadmap1 = new RoadMap("RM1ForTestAV",
                "Backend Advanced",
                "Deepen backend skills: architecture, patterns and testing.",
                Map.of("1", "Design patterns", "2", "Clean architecture", "3", "REST APIs", "4", "Testing", "5", "Microservices"),
                5,
                false);
        RoadMap roadmap2 = new RoadMap("RM2ForTestAV",
                "Frontend Advanced",
                "Master modern frontend frameworks and best practices.",
                Map.of("1", "Advanced JavaScript", "2", "TypeScript", "3", "React", "4", "State management", "5", "Frontend testing"),
                5,
                false);

        CustomerProfile customerProfile1 =  new CustomerProfile("P1ForTestAV",
                CodeProfile.AI_ML_INTRODUCTORY_LEARNER,
                "Introductory AI/ML course",
                "Just wants to understand the terminology used by AI specialists",
                "Introductory AI/ML course",
                new Boolean[]{false, false, false, true});
        CustomerProfile customerProfile2 =  new CustomerProfile("P2ForTestAV",
                CodeProfile.GENERAL_LEARNER,
                "General introductory course",
                "General knowledge or understanding what others do",
                "General introductory course",
                new Boolean[]{false, false, false, false});

        /*   roadmap1.addCustomerProfile(customerProfile1);
        roadmap2.addCustomerProfile(customerProfile2);*/
        roadMapRepository.save(roadmap1);
        roadMapRepository.save(roadmap2);

        customerProfile1.addRoadMap(roadmap1);
        customerProfile2.addRoadMap(roadmap2);
        customerProfileRepository.save(customerProfile1);
        customerProfileRepository.save(customerProfile2);


        List<QuestionAndAnswer> questionsAndAnswers = new ArrayList<>();
        questionsAndAnswers.add(qandA1);
        questionsAndAnswers.add(qandA2);
        AssessmentView assessmentView1 = new  AssessmentView(
                "AV1ForTestAV",
                cust1,
                Instant.now(),
                questionsAndAnswers,
                customerProfile1
        );
        AssessmentView assessmentView2 = new  AssessmentView(
                "AV2ForTestAV",
                cust2,
                Instant.now(),
                questionsAndAnswers,
                customerProfile2
        );

        assessmentViewRepository.save(assessmentView1);
        assessmentViewRepository.save(assessmentView2);
        qandA1.setAssessmentViewInQandA(assessmentView1);
        qandA2.setAssessmentViewInQandA(assessmentView2);
        questionAndAnswerService.updateQuestionAndAnswer(qandA1);
        questionAndAnswerService.updateQuestionAndAnswer(qandA2);

    }
}
