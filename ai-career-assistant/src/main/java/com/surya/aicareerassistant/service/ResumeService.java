package com.surya.aicareerassistant.service;

import com.surya.aicareerassistant.dto.ResumeAnalysisResponse;

public interface ResumeService {

    ResumeAnalysisResponse analyzeResume(String text);
}