package com.surya.aicareerassistant.service.impl;

import com.surya.aicareerassistant.dto.ResumeAnalysisResponse;
import com.surya.aicareerassistant.service.ResumeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Override
    public ResumeAnalysisResponse analyzeResume(String text) {

        text = text.toLowerCase();

        List<String> skills = new ArrayList<>();

        String[] skillSet = {
                "java",
                "spring boot",
                "react",
                "sql",
                "mysql",
                "html",
                "css",
                "javascript",
                "aws",
                "docker",
                "git"
        };

        for (String skill : skillSet) {

            if (text.contains(skill.toLowerCase())) {
                skills.add(skill);
            }
        }

        int score = skills.size() * 10;

        if (score > 100) {
            score = 100;
        }

        List<String> suggestions = new ArrayList<>();

        if (!skills.contains("aws")) {
            suggestions.add("Learn AWS Cloud");
        }

        if (!skills.contains("docker")) {
            suggestions.add("Add Docker knowledge");
        }

        if (!skills.contains("git")) {
            suggestions.add("Add Git/GitHub projects");
        }

        if (skills.size() < 5) {
            suggestions.add("Add more technical skills");
        }

        return new ResumeAnalysisResponse(
                skills,
                score,
                suggestions
        );
    }
}