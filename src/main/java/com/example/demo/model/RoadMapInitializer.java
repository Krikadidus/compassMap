package com.example.demo.model;

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
        }
    }
}
