package com.surya.aicareerassistant.controller;

import com.surya.aicareerassistant.dto.ChatRequest;
import com.surya.aicareerassistant.dto.ChatResponse;
import com.surya.aicareerassistant.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatResponse chat(
            @RequestBody ChatRequest request) {

        return chatService.chat(request.getMessage());
    }
}