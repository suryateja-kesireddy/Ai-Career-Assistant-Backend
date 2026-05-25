package com.surya.aicareerassistant.service;

import com.surya.aicareerassistant.dto.ChatResponse;

public interface ChatService {

    ChatResponse chat(String message);
}