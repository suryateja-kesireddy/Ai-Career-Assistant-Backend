package com.surya.aicareerassistant.service;

import com.surya.aicareerassistant.dto.AuthenticationResponse;
import com.surya.aicareerassistant.dto.LoginRequest;
import com.surya.aicareerassistant.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}