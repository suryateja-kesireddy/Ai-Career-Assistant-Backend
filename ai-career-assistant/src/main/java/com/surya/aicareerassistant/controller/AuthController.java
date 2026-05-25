package com.surya.aicareerassistant.controller;

import com.surya.aicareerassistant.dto.AuthenticationResponse;
import com.surya.aicareerassistant.dto.LoginRequest;
import com.surya.aicareerassistant.dto.RegisterRequest;
import com.surya.aicareerassistant.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}