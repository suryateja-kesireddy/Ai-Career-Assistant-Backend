package com.surya.aicareerassistant.service.impl;

import com.surya.aicareerassistant.dto.AuthenticationResponse;
import com.surya.aicareerassistant.dto.LoginRequest;
import com.surya.aicareerassistant.dto.RegisterRequest;
import com.surya.aicareerassistant.entity.User;
import com.surya.aicareerassistant.repository.UserRepository;
import com.surya.aicareerassistant.security.JwtService;
import com.surya.aicareerassistant.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthenticationResponse(token);
    }
}