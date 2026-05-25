package com.surya.aicareerassistant.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/profile")
    public String profile(Authentication authentication) {

        return "Welcome : " + authentication.getName();
    }
}