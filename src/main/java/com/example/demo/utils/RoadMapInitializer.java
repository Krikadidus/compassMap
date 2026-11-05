package com.example.demo.utils;

import com.example.demo.model.RoadMap;
import com.example.demo.repository.RoadMapRepository;
import org.springframework.stereotype.Component;

import java.util.Map;




@Component
public class RoadMapInitializer {
    private final RoadMapRepository roadMapRepository;

    public RoadMapInitializer(RoadMapRepository roadMapRepository) {
        this.roadMapRepository = roadMapRepository;

    }

    public void initialize() {
        if (roadMapRepository.count() == 0) {

            //Create Roadmaps with initials dates

            // For Code with answers: Knows code (true),  Wants to learn code (true)
            roadMapRepository.save(new RoadMap(
                    "RM01",
                    "Backend Advanced",
                    "Deepen backend skills: architecture, patterns and testing.",
                    Map.of("1", "Design patterns", "2", "Clean architecture", "3", "REST APIs", "4", "Testing", "5", "Microservices"),
                    5,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM02",
                    "Frontend Advanced",
                    "Master modern frontend frameworks and best practices.",
                    Map.of("1", "Advanced JavaScript", "2", "TypeScript", "3", "React", "4", "State management", "5", "Frontend testing"),
                    5,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM03",
                    "Fullstack Advanced",
                    "Build complete applications end to end.",
                    Map.of("1", "Spring Boot", "2", "React", "3", "Databases", "4", "Authentication", "5", "Deployment"),
                    5,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM04",
                    "DevOps",
                    "Automate build, test and deployment pipelines.",
                    Map.of("1", "Linux", "2", "Docker", "3", "CI/CD", "4", "Kubernetes"),
                    4,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM05",
                    "Mobile Advanced",
                    "Go deeper into mobile app development.",
                    Map.of("1", "Kotlin", "2", "Android architecture", "3", "Flutter", "4", "Mobile testing"),
                    4,
                    false
            ));

            //For ML with answers: Knows ML (true),  Wants to learn ML (true)
            roadMapRepository.save(new RoadMap(
                    "RM06",
                    "AI for Backend",
                    "Use AI tools to speed up backend development.",
                    Map.of("1", "AI coding assistants", "2", "Prompting for APIs", "3", "AI code review"),
                    3,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM07",
                    "AI for Frontend",
                    "Generate and iterate UIs with AI tools.",
                    Map.of("1", "AI UI generators", "2", "Prompting for components", "3", "AI refactoring"),
                    3,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM08",
                    "AI Fullstack Projects",
                    "Ship full projects quickly with AI agents.",
                    Map.of("1", "Project scaffolding with AI", "2", "AI agents", "3", "AI debugging", "4", "Deploy"),
                    4,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM09",
                    "AI for DevOps",
                    "Automate infrastructure tasks with AI.",
                    Map.of("1", "AI shell assistants", "2", "AI for CI/CD", "3", "AI monitoring"),
                    3,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM10",
                    "AI APIs Integration",
                    "Integrate LLM APIs into existing projects.",
                    Map.of("1", "LLM APIs", "2", "RAG basics", "3", "AI integration"),
                    3,
                    false
            ));

            // For Code with answers: Knows code (false),  Wants to learn code (true)
            roadMapRepository.save(new RoadMap(
                    "RM11",
                    "Backend from Scratch",
                    "Learn backend programming from zero.",
                    Map.of("1", "Logic", "2", "Java basics", "3", "OOP", "4", "SQL", "5", "First API"),
                    5,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM12",
                    "Frontend from Scratch",
                    "Learn to build web pages from zero.",
                    Map.of("1", "HTML", "2", "CSS", "3", "JavaScript basics", "4", "DOM", "5", "First website"),
                    5,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM13",
                    "Fullstack from Scratch",
                    "First steps across frontend and backend.",
                    Map.of("1", "Logic", "2", "HTML/CSS", "3", "JavaScript", "4", "Backend basics", "5", "First app"),
                    5,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM14",
                    "Python from Scratch",
                    "Learn programming fundamentals with Python.",
                    Map.of("1", "Variables", "2", "Control flow", "3", "Functions", "4", "Data structures"),
                    4,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM15",
                    "Data Structures Basics",
                    "Core data structures and algorithms for beginners.",
                    Map.of("1", "Arrays", "2", "Lists", "3", "Maps", "4", "Sorting"),
                    4,
                    false
            ));
            //For ML with answers: Knows ML (false),  Wants to learn ML (true)
            roadMapRepository.save(new RoadMap(
                    "RM16",
                    "Intro to Backend",
                    "Understand what backend developers do.",
                    Map.of("1", "What is a server", "2", "What is an API", "3", "What is a database"),
                    3,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM17",
                    "Intro to Frontend",
                    "Understand how web interfaces are built.",
                    Map.of("1", "How the web works", "2", "HTML/CSS overview", "3", "UX basics"),
                    3,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM18",
                    "Intro to Software Teams",
                    "Learn how developer teams work.",
                    Map.of("1", "Roles", "2", "Agile", "3", "Git overview"),
                    3,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM19",
                    "Intro to DevOps & Cloud",
                    "Overview of cloud and deployment concepts.",
                    Map.of("1", "What is the cloud", "2", "Deployment overview", "3", "Costs"),
                    3,
                    false
            ));
            roadMapRepository.save(new RoadMap(
                    "RM20",
                    "Intro to AI",
                    "Understand AI concepts and their impact.",
                    Map.of("1", "What is AI", "2", "LLMs overview", "3", "AI use cases"),
                    3,
                    false
            ));

            // For Code with answers: Knows code (true),  Wants to learn code (false)
            roadMapRepository.save(new RoadMap(
                    "RM21",
                    "AI Productivity for Developers",
                    "Learn how to use AI tools to speed up everyday development tasks.",
                    Map.of("1", "AI coding assistants", "2", "Effective prompting", "3", "Code generation", "4", "AI-powered debugging"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM22",
                    "AI for Daily Development",
                    "Use AI to simplify routine programming and development workflows.",
                    Map.of("1", "AI code completion", "2", "Code explanation", "3", "Automated documentation", "4", "Code refactoring with AI"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM23",
                    "AI Workflow Automation",
                    "Automate repetitive development tasks using AI-powered tools.",
                    Map.of("1", "AI automation tools", "2", "Automating repetitive tasks", "3", "AI agents for workflows", "4", "Building automated workflows"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM24",
                    "AI for Research and Problem Solving",
                    "Use AI to research technical topics and find solutions faster.",
                    Map.of("1", "AI-powered technical research", "2", "Understanding unfamiliar code", "3", "Comparing technical solutions", "4", "AI-assisted problem solving"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM25",
                    "AI-Powered Testing and Documentation",
                    "Use AI tools to simplify testing and documentation without deepening programming knowledge.",
                    Map.of("1", "Generating test cases", "2", "AI-assisted test execution", "3", "Generating documentation", "4", "Reviewing test results with AI"),
                    4,
                    false
            ));

            // For Code with answers: Knows code (false),  Wants to learn code (false)


            roadMapRepository.save(new RoadMap(
                    "RM26",
                    "Introduction to Software Development",
                    "Understand how software is built and what developers do in their daily work.",
                    Map.of("1", "How software works", "2", "Programming fundamentals", "3", "How applications are built", "4", "Development lifecycle"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM27",
                    "Understanding Web Development",
                    "Learn how websites and web applications work from frontend to backend.",
                    Map.of("1", "How the web works", "2", "Frontend fundamentals", "3", "Backend fundamentals", "4", "How frontend and backend communicate"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM28",
                    "Understanding APIs and Databases",
                    "Learn how applications exchange information and store data.",
                    Map.of("1", "What is an API", "2", "How REST APIs work", "3", "Database fundamentals", "4", "How applications manage data"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM29",
                    "Software Development for Product Managers",
                    "Understand technical concepts and development processes to collaborate effectively with engineering teams.",
                    Map.of("1", "Software architecture basics", "2", "Agile and Scrum", "3", "Technical requirements and user stories", "4", "Working with developers"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM30",
                    "Building Your First Digital Product",
                    "Understand the process of turning an idea into a working digital product.",
                    Map.of("1", "Defining a product idea", "2", "UI and UX fundamentals", "3", "MVP development process", "4", "Deployment and product launch"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM31",
                    "No-Code and Low-Code Development",
                    "Learn how to create simple digital products without traditional programming.",
                    Map.of("1", "No-code and low-code concepts", "2", "Visual application builders", "3", "Connecting APIs and services", "4", "Building a simple application"),
                    4,
                    false
            ));

            //  For ML with answers: Knows ML (false),  Wants to learn ML (true)
            roadMapRepository.save(new RoadMap(
                    "RM32",
                    "Pretrained Models and APIs",
                    "Build ML-powered solutions quickly using existing pretrained models and APIs.",
                    Map.of("1", "Pretrained model libraries", "2", "Hugging Face models", "3", "Model APIs", "4", "Integrating pretrained models"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM33",
                    "Rapid ML Prototyping",
                    "Create and validate ML prototypes quickly using existing tools and frameworks.",
                    Map.of("1", "ML prototyping tools", "2", "Ready-to-use datasets", "3", "Rapid model experimentation", "4", "Prototype validation"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM34",
                    "AutoML and No-Code ML",
                    "Build machine learning solutions with minimal manual model development.",
                    Map.of("1", "AutoML fundamentals", "2", "Automated model training", "3", "No-code ML platforms", "4", "Model evaluation and deployment"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM35",
                    "LLM Application Development",
                    "Build practical AI applications using existing large language models and frameworks.",
                    Map.of("1", "LLM APIs", "2", "Prompt engineering", "3", "RAG and vector databases", "4", "Building LLM-powered applications"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM36",
                    "ML Deployment with Existing Tools",
                    "Deploy and integrate machine learning models without building complex infrastructure.",
                    Map.of("1", "Model hosting platforms", "2", "Inference APIs", "3", "Model integration", "4", "Monitoring deployed models"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM37",
                    "AI-Assisted ML Development",
                    "Use AI coding assistants and automation tools to accelerate machine learning development.",
                    Map.of("1", "AI coding assistants for ML", "2", "AI-assisted data preparation", "3", "Automated experimentation", "4", "AI-assisted debugging and optimization"),
                    4,
                    false
            ));

            //  For ML with answers: Knows ML (false),  Wants to learn ML (false)
            roadMapRepository.save(new RoadMap(
                    "RM38",
                    "Introduction to Machine Learning",
                    "Understand the basic concepts, terminology and applications of machine learning.",
                    Map.of("1", "What is machine learning", "2", "Supervised and unsupervised learning", "3", "Training and inference", "4", "Real-world ML applications"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM39",
                    "Understanding Data Science",
                    "Learn how data scientists collect, analyze and interpret data to support decisions.",
                    Map.of("1", "Data science fundamentals", "2", "Data collection and preparation", "3", "Exploratory data analysis", "4", "Data-driven decision making"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM40",
                    "Understanding AI and ML Terminology",
                    "Learn the technical vocabulary needed to communicate effectively with AI and ML teams.",
                    Map.of("1", "AI, ML and Deep Learning", "2", "Datasets and features", "3", "Models, training and inference", "4", "Accuracy and evaluation metrics"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM41",
                    "Machine Learning Project Lifecycle",
                    "Understand how machine learning projects are planned, developed and delivered.",
                    Map.of("1", "Defining an ML problem", "2", "Data preparation", "3", "Model development and evaluation", "4", "Deployment and monitoring"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM42",
                    "Working with Data Scientists and ML Engineers",
                    "Understand team responsibilities, workflows and communication in machine learning projects.",
                    Map.of("1", "Data Scientist vs ML Engineer", "2", "Understanding ML requirements", "3", "Communicating technical constraints", "4", "Collaborating on ML projects"),
                    4,
                    false
            ));

            roadMapRepository.save(new RoadMap(
                    "RM43",
                    "AI and ML for Business",
                    "Understand how machine learning and AI can create business value and support product decisions.",
                    Map.of("1", "AI business applications", "2", "Identifying ML opportunities", "3", "Understanding project costs and limitations", "4", "Evaluating AI solutions and ROI"),
                    4,
                    false
            ));
        }
    }
}
