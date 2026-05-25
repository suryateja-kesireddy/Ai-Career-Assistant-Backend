package com.surya.aicareerassistant.service.impl;

import com.surya.aicareerassistant.dto.ChatResponse;
import com.surya.aicareerassistant.service.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Override
    public ChatResponse chat(String message) {

        message = message.toLowerCase();

        String reply;

        if (message.contains("java")) {

            reply =
                    "Practice Core Java, OOPs, Collections and Spring Boot daily.";

        } else if (message.contains("spring")) {

            reply =
                    "Focus on Spring Boot, Security, JPA and REST APIs.";

        } else if (message.contains("react")) {

            reply =
                    "Learn hooks, routing, state management and API integration.";

        } else {

            reply =
                    "Keep practicing consistently to improve your career skills.";
        }

        return new ChatResponse(reply);
    }
}