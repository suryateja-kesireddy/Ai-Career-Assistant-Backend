package com.surya.aicareerassistant.service;

import com.surya.aicareerassistant.dto.InterviewQuestionResponse;

import java.util.List;

public interface InterviewService {

    InterviewQuestionResponse generateQuestions(List<String> skills);
}