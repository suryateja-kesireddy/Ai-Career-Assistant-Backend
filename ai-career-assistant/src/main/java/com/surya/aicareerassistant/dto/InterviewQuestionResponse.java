package com.surya.aicareerassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class InterviewQuestionResponse {

    private Map<String, List<String>> questions;
}