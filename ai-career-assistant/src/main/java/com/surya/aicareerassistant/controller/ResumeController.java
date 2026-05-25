package com.surya.aicareerassistant.controller;

import com.surya.aicareerassistant.dto.ResumeAnalysisResponse;
import com.surya.aicareerassistant.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    private static final String UPLOAD_DIR = "C:/resume-uploads/";

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(
            @RequestParam("file") MultipartFile file) {

        try {

            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("File is empty");
            }

            File directory = new File(UPLOAD_DIR);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = UPLOAD_DIR + file.getOriginalFilename();

            File destFile = new File(filePath);

            file.transferTo(destFile);

            PDDocument document = PDDocument.load(destFile);

            PDFTextStripper pdfStripper = new PDFTextStripper();

            String text = pdfStripper.getText(document);

            document.close();

            ResumeAnalysisResponse response =
                    resumeService.analyzeResume(text);

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest()
                    .body("ERROR : " + e.getMessage());
        }
    }
}