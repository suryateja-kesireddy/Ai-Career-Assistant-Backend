package com.surya.aicareerassistant.service.impl;

import com.surya.aicareerassistant.dto.InterviewQuestionResponse;
import com.surya.aicareerassistant.service.InterviewService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Override
    public InterviewQuestionResponse generateQuestions(List<String> skills) {

        Map<String, List<String>> questions = new HashMap<>();

        for (String skill : skills) {

            switch (skill.toLowerCase()) {

                case "java" -> questions.put("Java", List.of(
                        "What is JVM?",
                        "Difference between JDK and JRE?",
                        "Explain OOP concepts."
                ));

                case "spring boot" -> questions.put("Spring Boot", List.of(
                        "What is dependency injection?",
                        "Explain Spring Boot starters.",
                        "What is Spring Security?"
                ));

                case "react" -> questions.put("React", List.of(
                        "What are React hooks?",
                        "Difference between props and state?",
                        "Explain virtual DOM."
                ));

                case "sql" -> questions.put("SQL", List.of(
                        "What is normalization?",
                        "Difference between DELETE and TRUNCATE?",
                        "Explain joins."
                ));

                default -> questions.put(skill, List.of(
                        "Explain basics of " + skill
                ));
            }
        }

        return new InterviewQuestionResponse(questions);
    }
}