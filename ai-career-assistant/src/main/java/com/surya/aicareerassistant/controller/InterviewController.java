package com.surya.aicareerassistant.controller;

import com.surya.aicareerassistant.dto.InterviewQuestionResponse;
import com.surya.aicareerassistant.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping("/questions")
    public InterviewQuestionResponse generateQuestions(
            @RequestBody List<String> skills) {

        return interviewService.generateQuestions(skills);
    }
}